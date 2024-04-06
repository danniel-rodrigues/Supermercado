package DAO;

import Models.Item;
import Models.Produto;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ItemDAO {
    // URL de conexão com o BD SQLite
    private static final String URL = "jdbc:sqlite:supermercado.db";

    // Comando SQL para criar a tabela caso ela não exista
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS item (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "dataValidade TEXT NOT NULL, " +
            "dataFabricacao TEXT NOT NULL, " +
            "peso REAL NOT NULL, " +
            "lote TEXT NOT NULL, " +
            "quantidade INTEGER NOT NULL, " +
            "id_produto INTEGER NOT NULL UNIQUE," +
            "FOREIGN KEY (id_produto) REFERENCES produto (id)" +
            ")";

    public static void criarTabela() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            // Executando o comando SQL para criar a tabela
            stmt.execute(CREATE_TABLE_SQL);
            System.out.println("Tabela 'item' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela 'item': " + e.getMessage());
        }
    }

    public static boolean adicionarItem(Item item) {
        criarTabela();
        String sql = "INSERT INTO item " +
                "(dataValidade, dataFabricacao, peso, lote, quantidade, id_produto) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        Integer idProduto = buscarIdPeloCodigo(item.getCodigoProduto());

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, item.getDataVal().toString());
            pstmt.setString(2, item.getDataFab().toString());
            pstmt.setFloat(3, item.getPeso());
            pstmt.setString(4, item.getLote());
            pstmt.setInt(5, item.getQuantidade());
            pstmt.setInt(6, idProduto);

            pstmt.executeUpdate();
            System.out.println("Item adicionado com sucesso.");
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar item: " + e.getMessage());
        }
        return false;
    }

    public static List<Item> listarItens() {
        List<Item> itens = new ArrayList<>();
        String sql = "SELECT * FROM item";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Item item = criarItem(rs);
                itens.add(item);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar itens: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return itens;
    }

    public static Item criarItem(ResultSet rs) throws SQLException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        Date dataValidade = sdf.parse(rs.getString("dataValidade"));
        Date dataFabricacao = sdf.parse(rs.getString("dataFabricacao"));
        float peso = rs.getFloat("peso");
        String lote = rs.getString("lote");
        Integer quantidade = rs.getInt("quantidade");
        Integer codigoProduto = buscarCodigoPeloId(rs.getInt("id_produto"));

        return new Item(codigoProduto, lote, dataValidade, dataFabricacao, peso, quantidade);
    }

    public static Integer buscarIdPeloCodigo(Integer codigo) {
        String sql = "SELECT id FROM produto WHERE codigo = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, codigo);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar ID pelo código do produto: " + e.getMessage());
        }
        return null;
    }

    public static Integer buscarCodigoPeloId(Integer id) {
        String sql = "SELECT codigo FROM produto WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("codigo");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar código pelo ID do produto: " + e.getMessage());
        }
        return null;
    }
}
