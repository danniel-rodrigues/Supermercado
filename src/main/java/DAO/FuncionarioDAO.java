package DAO;

import Models.Endereco;
import Models.Funcionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FuncionarioDAO {
    // URL de conexão com o banco de dados SQLite
    private static final String URL = "jdbc:sqlite:supermercado.db";

    // SQL para criar a tabela caso ela não exista
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS funcionario (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome TEXT NOT NULL," +
            "cpf TEXT NOT NULL UNIQUE," +
            "data_nasc TEXT NOT NULL," +
            "email TEXT NOT NULL," +
            "telefone TEXT NOT NULL," +
            "sexo TEXT NOT NULL," +
            "login TEXT NOT NULL," +
            "senha TEXT NOT NULL," +
            "status TEXT NOT NULL," +
            "id_endereco TEXT NOT NULL," +
            "cargo TEXT NOT NULL," +
            "FOREIGN KEY (id_endereco) REFERENCES endereco (id)" +
            ")";

    // Metodo para criar a tabela no banco de dados
    public static void criarTabela() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            // Executando o comando SQL para criar a tabela
            stmt.execute(CREATE_TABLE_SQL);
            System.out.println("Tabela 'funcionario' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    // Método para adicionar um funcionario ao banco de dados
    public static boolean adicionarFuncionario(Funcionario funcionario) {
        criarTabela();
        String sql = "INSERT INTO funcionario (nome, cpf, data_nasc, email, telefone, sexo, login, senha, status, id_endereco, cargo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, funcionario.getNome());
            pstmt.setString(2, funcionario.getCpf());
            pstmt.setString(3, funcionario.getDataNasc().toString()); // Convertendo a data para String por simplicidade
            pstmt.setString(4, funcionario.getEmail());
            pstmt.setString(5, funcionario.getTelefone());
            pstmt.setString(6, funcionario.getSexo());
            pstmt.setString(7, funcionario.getLogin());
            pstmt.setString(8, funcionario.getSenha());
            pstmt.setString(9, funcionario.getStatus());
            pstmt.setString(10, "@@IDENTITY");  // Utiliza o id do ultimo endereco cadastrado
            pstmt.setString(11, funcionario.getCargo());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Funcionario adicionado com sucesso.");
                return true; // Retorna true se a operação foi bem-sucedida
            }
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar funcionario: " + e.getMessage());
        }
        return false; // Retorna false se a operação falhar por algum motivo
    }

    // Método para listar todos os funcionarios do banco de dados
    public static List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario WHERE status = 'Ativo'";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Funcionario funcionario = criarFuncioario(rs);
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar funcionarios: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return funcionarios;
    }

    // Método para criar um funcionario a partir do ResultSet
    private static Funcionario criarFuncioario(ResultSet rs) throws SQLException, ParseException {
        int id = rs.getInt("id");
        String nome = rs.getString("nome");
        String cpf = rs.getString("cpf");
        // Convertendo a String de data para Date usando SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        Date dataNasc = sdf.parse(rs.getString("data_nasc"));
        String email = rs.getString("email");
        String telefone = rs.getString("telefone");
        String sexo = rs.getString("sexo");
        String login = rs.getString("login");
        String senha = rs.getString("senha");
        String status = rs.getString("status");
        String cargo = rs.getString("cargo");
        Endereco endereco = EnderecoDAO.buscarEnderecoPorCPF(cpf);
        Funcionario funcionario = new Funcionario(nome, cpf, dataNasc, email, telefone, sexo, login, senha, status, endereco, cargo);
        funcionario.setId(id);
        return funcionario;
    }

    // Método para buscar um funcionario pelo CPF
    public static Funcionario buscarFuncionarioPorCPF(String cpf) {
        String sql = "SELECT * FROM funcionario WHERE cpf = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return criarFuncioario(rs);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar funcionario por CPF: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return null; // Retorna null se não encontrar nenhum funcionario com o CPF fornecido
    }

    // Método para buscar um funcionario pelo ID
    public static Funcionario buscarFuncionarioPorId(int id) {
        String sql = "SELECT * FROM funcionario WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return criarFuncioario(rs);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar funcionario por ID: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return null; // Retorna null se não encontrar nenhum funcionario com o id fornecido
    }

    // Método para atualizar um funcionario no banco de dados
    public static boolean atualizarFuncionario(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ?, data_nasc = ?, email = ?, telefone = ?, sexo = ?, login = ?, senha = ?, status = ? WHERE cpf = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, funcionario.getNome());
            pstmt.setString(2, funcionario.getDataNasc().toString()); // Convertendo a data para String por simplicidade
            pstmt.setString(3, funcionario.getEmail());
            pstmt.setString(4, funcionario.getTelefone());
            pstmt.setString(5, funcionario.getSexo());
            pstmt.setString(6, funcionario.getLogin());
            pstmt.setString(7, funcionario.getSenha());
            pstmt.setString(8, funcionario.getStatus());
            pstmt.setString(9, funcionario.getCpf());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Funcionario atualizado com sucesso.");
                return true; // Retorna true se a operação foi bem-sucedida
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar funcionario: " + e.getMessage());
        }
        return false; // Retorna false se a operação falhar por algum motivo
    }

    // Altera o status do Funcionario para "Desligado", mas mantem ele no banco
    public static boolean demitirFuncionario(String cpf){
        String sql = "UPDATE funcionario SET status = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "Desligado");

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Funcionario demitido com sucesso.");
                return true; // Retorna true se a operação foi bem-sucedida
            }
        } catch (SQLException e) {
            System.err.println("Erro ao demitir funcionario: " + e.getMessage());
        }
        return false; // Retorna false se a operação falhar por algum motivo
    }
}
