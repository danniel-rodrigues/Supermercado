package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import Models.Produto;

public class ProdutoDAO {
    // URL de conexão com o BD SQLite
    private static final String URL = "jdbc:sqlite:supermercado.db";

    // Comando SQL para criar a tabela caso ela não exista
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS produto (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nome TEXT NOT NULL, " +
            "marca TEXT NOT NULL, " +
            "codigo INTEGER NOT NULL UNIQUE, " +
            "tipo TEXT NOT NULL, " +
            "preco REAL NOT NULL, " +
            "status TEXT NOT NULL)";

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
    public static boolean adicionarProduto(Produto produto) {
        criarTabela();
        String sql = "INSERT INTO produto " +
                     "(nome, marca, codigo, tipo, preco, status) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getMarca());
            pstmt.setInt(3, produto.getCodigo());
            pstmt.setString(4, produto.getTipo());
            pstmt.setFloat(5, produto.getPreco());
            pstmt.setString(6, produto.getStatus());

            pstmt.executeUpdate();
            System.out.println("Produto adicionado com sucesso.");
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar produto: " + e.getMessage());
        }
        return false;
    }

    // Método para listar todos os funcionários do banco de dados
    public static List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto WHERE status = 'Ativo'";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto produto = criarProduto(rs);
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return produtos;
    }

    // Método para criar um produto a partir de um ResultSet (conjunto de resultados da consulta SQL)
    public static Produto criarProduto(ResultSet rs) throws SQLException, ParseException {
        String nome = rs.getString("nome");
        String marca = rs.getString("marca");
        Integer codigo = rs.getInt("codigo");
        String tipo = rs.getString("tipo");
        float preco = rs.getFloat("preco");
        String status = rs.getString("status");

        return new Produto(nome, marca, codigo, tipo, preco, status);
    }

    // Método para buscar um produto pelo código
    public static Produto buscarProdutoPorCodigo(Integer codigo) {
        String sql = "SELECT * FROM produto WHERE codigo = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return criarProduto(rs);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar produto por código: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return null; // Retorna NULL se não encontrar nenhum produto com o código fornecido
    }

    // Método para atualizar um produto no banco de dados
    public static boolean atualizarProduto(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, " +
                                            "marca = ?, " +
                                            "codigo = ?, " +
                                            "tipo = ?, " +
                                            "preco = ?, " +
                                            "status = ? ";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getMarca());
            pstmt.setInt(3, produto.getCodigo());
            pstmt.setString(4, produto.getTipo());
            pstmt.setFloat(5, produto.getPreco());
            pstmt.setString(6, produto.getStatus());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produto atualizado com sucesso");
                return true; // Retorna true se a operação foi bem sucedida
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
        }
        return false;
    }

    public static boolean desativarProduto(String codigo) {
        String sql = "UPDATE produto SET status = 'Inativo' WHERE codigo = ? AND status = 'Ativo'";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, codigo);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) return true; // Retorna true se a operação for bem sucedida
        } catch (SQLException e){
            System.err.println("Erro ao desativar produto: " + e.getMessage());
        }

        return false;
    }
}
