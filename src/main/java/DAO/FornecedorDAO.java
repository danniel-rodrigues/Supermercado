package DAO;

import Models.Fornecedor;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {
    // URL de conexão com o banco de dados SQLite
    private static final String URL = "jdbc:sqlite:supermercado.db";

    // SQL para criar a tabela caso ela não exista
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS fornecedor (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome TEXT NOT NULL," +
            "cnpj TEXT NOT NULL UNIQUE," +
            "email TEXT NOT NULL," +
            "contato TEXT NOT NULL" +
            ")";

    // Metodo para criar a tabela no banco de dados
    public static void criarTabela() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            // Executando o comando SQL para criar a tabela
            stmt.execute(CREATE_TABLE_SQL);
            System.out.println("Tabela 'fornecedor' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    // Método para adicionar um fornecedor ao banco de dados
    public static boolean adicionarFornecedor(Fornecedor fornecedor) {
        criarTabela();
        String sql = "INSERT INTO fornecedor (nome, cnpj, email, telefone) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fornecedor.getNome());
            pstmt.setString(2, fornecedor.getCnpj());
            pstmt.setString(3, fornecedor.getEmail());
            pstmt.setString(4, fornecedor.getTelefone());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Fornecedor adicionado com sucesso.");
                return true; // Retorna true se a operação foi bem-sucedida
            }
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar fornecedor: " + e.getMessage());
        }
        return false; // Retorna false se a operação falhar por algum motivo
    }

    // Método para listar todos os fornecedores do banco de dados
    public static List<Fornecedor> listarFornecedores() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM fornecedor";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Fornecedor fornecedor = criarFuncioario(rs);
                fornecedores.add(fornecedor);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar fornecedores: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return fornecedores;
    }

    // Método para criar um fornecedor a partir do ResultSet
    private static Fornecedor criarFuncioario(ResultSet rs) throws SQLException, ParseException {
        String nome = rs.getString("nome");
        String cnpj = rs.getString("cnpj");
        String email = rs.getString("email");
        String contato = rs.getString("contato");
        return new Fornecedor(nome, cnpj, contato, email);
    }

    // Método para buscar um fornecedor pelo CNPJ
    public static Fornecedor buscarFornecedorPorCNPJ(String cnpj) {
        String sql = "SELECT * FROM fornecedor WHERE cnpj = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cnpj);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return criarFuncioario(rs);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar fornecedor por CNPJ: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return null; // Retorna null se não encontrar nenhum fornecedor com o CNPJ fornecido
    }

    // Método para atualizar um fornecedor no banco de dados
    public static boolean atualizarFornecedor(Fornecedor fornecedor) {
        String sql = "UPDATE fornecedor SET nome = ?, email = ?, telefone = ? WHERE cnpj = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fornecedor.getNome());
            pstmt.setString(2, fornecedor.getTelefone());
            pstmt.setString(3, fornecedor.getEmail());
            pstmt.setString(4, fornecedor.getCnpj());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Fornecedor atualizado com sucesso.");
                return true; // Retorna true se a operação foi bem-sucedida
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar fornecedor: " + e.getMessage());
        }
        return false; // Retorna false se a operação falhar por algum motivo
    }
}
