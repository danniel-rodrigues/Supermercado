package DAO;

import Models.Remessa;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class RemessaDAO {
    // URL de conexão com o banco de dados SQLite
    private static final String URL = "jdbc:sqlite:supermercado.db";

    // SQL para criar a tabela caso ela não exista
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS remessa (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "dataEnvio TEXT NOT NULL," +
            "dataRecebimento TEXT NOT NULL," +
            "status TEXT NOT NULL," +
            "id_fornecedor INTEGER NOT NULL," +
            "FOREIGN KEY (id_fornecedor) REFERENCES fornecedor (id)" +
            ")";

    // Metodo para criar a tabela no banco de dados
    public static void criarTabela() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            // Executando o comando SQL para criar a tabela
            stmt.execute(CREATE_TABLE_SQL);
            System.out.println("Tabela 'remessa' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    // Método para adicionar uma remessa ao banco de dados
    public static boolean adicionarRemessa(Remessa remessa) {
        criarTabela();
        String sql = "INSERT INTO remessa (dataEnvio, dataRecebimento, status, id_fornecedor) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, remessa.getDataEnvio().toString());
            pstmt.setString(2, remessa.getDataRecebimento().toString());
            pstmt.setString(3, remessa.getStatus());
            pstmt.setInt(4, remessa.getFornecedorId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Remessa adicionado com sucesso.");
                return true; // Retorna true se a operação foi bem-sucedida
            }
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar remessa: " + e.getMessage());
        }
        return false; // Retorna false se a operação falhar por algum motivo
    }

    // Método para listar todos os remessas do banco de dados
    public static List<Remessa> listarRemessas() {
        List<Remessa> remessas = new ArrayList<>();
        String sql = "SELECT * FROM remessa";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Remessa remessa = criarRemessa(rs);
                remessas.add(remessa);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar remessas: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return remessas;
    }

    // Método para criar um remessa a partir do ResultSet
    private static Remessa criarRemessa(ResultSet rs) throws SQLException, ParseException {
        Date dataEnvio = Date.valueOf(rs.getString("dataEnvio"));
        int idFornecedor = rs.getInt("id_fornecedor");
        int id = rs.getInt("id");
        Date dataRecebimento = Date.valueOf(rs.getString("dataRecebimento"));
        String status = rs.getString("status");
        return new Remessa(id,idFornecedor, dataEnvio, dataRecebimento, status);
    }

    // Método para buscar uma remessa pelo Id
    public static Remessa buscarRemessaPorId(int id) {
        String sql = "SELECT * FROM remessa WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return criarRemessa(rs);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar remessa por Id: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return null; // Retorna null se não encontrar nenhum remessa com o Id fornecido
    }

    // Método para atualizar um remessa no banco de dados
    public static boolean atualizarRemessa(Remessa remessa) {
        String sql = "UPDATE remessa SET idFornecedor = ?, dataEnvio = ?, dataRecebimento = ?, status = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, remessa.getFornecedorId());
            pstmt.setString(2, remessa.getDataEnvio().toString());
            pstmt.setString(3, remessa.getDataRecebimento().toString());
            pstmt.setString(4, remessa.getStatus());
            pstmt.setInt(5, remessa.getId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Remessa atualizado com sucesso.");
                return true; // Retorna true se a operação foi bem-sucedida
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar remessa: " + e.getMessage());
        }
        return false; // Retorna false se a operação falhar por algum motivo
    }
}
