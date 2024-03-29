package DAO;

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


import Models.OperadorCaixa;
import Models.Endereco;

public class OperadorCaixaDAO {
    // URL de conexão com o banco de dados SQLite
    private static final String URL = "jdbc:sqlite:supermercado.db";

    // SQL para criar a tabela caso ela não exista
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS operadorCaixa (" +
            "id_funcionario INTEGER PRIMARY KEY," +
            "FOREIGN KEY (id_funcionario) REFERENCES funcionario (id)" +
            ")";

    // Metodo para criar a tabela no banco de dados
    public static void criarTabela() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            // Executando o comando SQL para criar a tabela
            stmt.execute(CREATE_TABLE_SQL);
            System.out.println("Tabela 'operadorCaixa' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    // Método para adicionar um operador ao banco de dados
    public static boolean adicionarOperador(OperadorCaixa operador) {
        criarTabela();
        String sql = "INSERT INTO operadorCaixa (id) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, operador.getNome());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Operador adicionado com sucesso.");
                return true; // Retorna true se a operação foi bem-sucedida
            }
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar operador: " + e.getMessage());
        }
        return false; // Retorna false se a operação falhar por algum motivo
    }

    // Método para listar todos os operadores do banco de dados
    public static List<OperadorCaixa> listarOperadores() {
        List<OperadorCaixa> operadores = new ArrayList<>();
        String sql = "SELECT * FROM operador_caixa WHERE status = 'Ativo'";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                OperadorCaixa operador = criarOperador(rs);
                operadores.add(operador);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar operadores: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return operadores;
    }

    // Método para criar um operador a partir do ResultSet
    private static OperadorCaixa criarOperador(ResultSet rs) throws SQLException, ParseException {
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
        Endereco endereco = EnderecoDAO.buscarEnderecoPorCPF(cpf);
        return new OperadorCaixa(nome, cpf, dataNasc, email, telefone, sexo, login, senha, status, endereco);
    }

    // Método para buscar um operador pelo CPF
    public static OperadorCaixa buscarOperadorPorCPF(String cpf) {
        String sql = "SELECT * FROM operador_caixa WHERE cpf = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return criarOperador(rs);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar operador por CPF: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return null; // Retorna null se não encontrar nenhum operador com o CPF fornecido
    }

    // Método para atualizar um operador no banco de dados
    public static boolean atualizarOperador(OperadorCaixa operador) {
        String sql = "UPDATE operador_caixa SET nome = ?, data_nasc = ?, email = ?, telefone = ?, sexo = ?, login = ?, senha = ?, status = ? WHERE cpf = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, operador.getNome());
            pstmt.setString(2, operador.getDataNasc().toString()); // Convertendo a data para String por simplicidade
            pstmt.setString(3, operador.getEmail());
            pstmt.setString(4, operador.getTelefone());
            pstmt.setString(5, operador.getSexo());
            pstmt.setString(6, operador.getLogin());
            pstmt.setString(7, operador.getSenha());
            pstmt.setString(8, operador.getStatus());
            pstmt.setString(9, operador.getCpf());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Operador atualizado com sucesso.");
                return true; // Retorna true se a operação foi bem-sucedida
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar operador: " + e.getMessage());
        }
        return false; // Retorna false se a operação falhar por algum motivo
    }

}
