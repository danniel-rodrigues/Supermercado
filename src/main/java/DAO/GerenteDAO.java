package DAO;

import Models.Endereco;
import Models.Gerente;

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

public class GerenteDAO {
    // URL de conexão com o banco de dados SQLite
    private static final String URL = "jdbc:sqlite:gerente.db";

    // SQL para criar a tabela caso ela não exista
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS gerente (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome TEXT NOT NULL," +
            "cpf TEXT NOT NULL UNIQUE," +
            "data_nasc TEXT NOT NULL," +
            "email TEXT NOT NULL," +
            "telefone TEXT NOT NULL," +
            "sexo TEXT NOT NULL," +
            "login TEXT NOT NULL," +
            "senha TEXT NOT NULL," +
            "status TEXT NOT NULL" +
            ")";

    // Metodo para criar a tabela no banco de dados
    public static void criarTabela() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            // Executando o comando SQL para criar a tabela
            stmt.execute(CREATE_TABLE_SQL);
            System.out.println("Tabela 'gerente' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    // Método para adicionar um gerente ao banco de dados
    public static boolean adicionarGerente(Gerente gerente) {
        criarTabela();
        String sql = "INSERT INTO gerente (nome, cpf, data_nasc, email, telefone, sexo, login, senha, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, gerente.getNome());
            pstmt.setString(2, gerente.getCpf());
            pstmt.setString(3, gerente.getDataNasc().toString()); // Convertendo a data para String por simplicidade
            pstmt.setString(4, gerente.getEmail());
            pstmt.setString(5, gerente.getTelefone());
            pstmt.setString(6, gerente.getSexo());
            pstmt.setString(7, gerente.getLogin());
            pstmt.setString(8, gerente.getSenha());
            pstmt.setString(9, gerente.getStatus());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Gerente adicionado com sucesso.");
                return true; // Retorna true se a operação foi bem-sucedida
            }
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar gerente: " + e.getMessage());
        }
        return false; // Retorna false se a operação falhar por algum motivo
    }

    // Método para listar todos os gerentes do banco de dados
    public static List<Gerente> listarGerentes() {
        List<Gerente> gerentes = new ArrayList<>();
        String sql = "SELECT * FROM gerente WHERE status = 'Ativo'";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Gerente gerente = criarGerente(rs);
                gerentes.add(gerente);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar gerentes: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return gerentes;
    }

    // Método para criar um gerente a partir do ResultSet
    private static Gerente criarGerente(ResultSet rs) throws SQLException, ParseException {
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
        return new Gerente(nome, cpf, dataNasc, email, telefone, sexo, login, senha, status, endereco);
    }

    // Método para buscar um gerente pelo CPF
    public static Gerente buscarGerentePorCPF(String cpf) {
        String sql = "SELECT * FROM gerente WHERE cpf = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return criarGerente(rs);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar gerente por CPF: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return null; // Retorna null se não encontrar nenhum gerente com o CPF fornecido
    }

    // Método para atualizar um gerente no banco de dados
    public static boolean atualizarGerente(Gerente gerente) {
        String sql = "UPDATE gerente SET nome = ?, data_nasc = ?, email = ?, telefone = ?, sexo = ?, login = ?, senha = ?, status = ? WHERE cpf = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, gerente.getNome());
            pstmt.setString(2, gerente.getDataNasc().toString()); // Convertendo a data para String por simplicidade
            pstmt.setString(3, gerente.getEmail());
            pstmt.setString(4, gerente.getTelefone());
            pstmt.setString(5, gerente.getSexo());
            pstmt.setString(6, gerente.getLogin());
            pstmt.setString(7, gerente.getSenha());
            pstmt.setString(8, gerente.getStatus());
            pstmt.setString(9, gerente.getCpf());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Gerente atualizado com sucesso.");
                return true; // Retorna true se a operação foi bem-sucedida
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar gerente: " + e.getMessage());
        }
        return false; // Retorna false se a operação falhar por algum motivo
    }
}
