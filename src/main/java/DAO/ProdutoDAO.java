package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Models.Produto;

public class ProdutoDAO {
    // URL de conexão com o BD SQLite
    private static final String URL = "jdbc:sqlite:supermercado.db";

    // Comando SQL para criar a tabela caso ela não exista
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS produto (" +
            "nome TEXT NOT NULL, " +
            "marca TEXT NOT NULL, " +
            "codigo INTEGER NOT NULL UNIQUE, " +
            "tipo TEXT NOT NULL, " +
            "preco REAL NOT NULL" +
            ")";

    // Método para criar a tabela no banco de dados
    public static void criarTabela() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            // Executando o comando SQL para criar a tabela
            stmt.execute(CREATE_TABLE_SQL);
            System.out.println("Tabela 'produto' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela 'produto': " + e.getMessage());
        }
    }

    // Método para adicionar um produto no banco de dados
    public static void adicionarProduto(Produto produto) {
        criarTabela();
        String sql = "INSERT INTO produto " +
                     "(nome, marca, codigo, tipo, preco) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getMarca());
            pstmt.setInt(3, produto.getCodigo());
            pstmt.setString(4, produto.getTipo());
            pstmt.setFloat(5, produto.getPreco());

            pstmt.executeUpdate();
            System.out.println("Produto adicionado com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar produto: " + e.getMessage());
        }
    }
}
