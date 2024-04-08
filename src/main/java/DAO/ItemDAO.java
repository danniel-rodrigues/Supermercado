package DAO;

import Models.Item;

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
        Integer idProduto = buscarIdPeloCodigo(item.getCodigoProduto());

        // Verifica se já existe um item com o id_produto especificado
        Item itemExistente = buscarItemPeloIdProduto(idProduto);
        if (itemExistente != null) {
            // Se já existir, incrementa a quantidade do item existente
            return incrementarQuantidadeItem(idProduto, item.getQuantidade());
        } else {
            // Se não existir, adiciona um novo item
            String sql = "INSERT INTO item " +
                    "(dataValidade, dataFabricacao, peso, lote, quantidade, id_produto) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

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
        }
        return false;
    }

    // Função para remover uma quantidade definida de um item
    public static boolean removerItem(Integer codigoProduto, Integer quantidade) {
        Integer idProduto = buscarIdPeloCodigo(codigoProduto);

        if (idProduto != null) {
            // Verifica se existe um item com o código do produto
            Item itemExistente = buscarItemPeloIdProduto(idProduto);
            if (itemExistente != null) {
                // Verifica se a quantidade a ser removida é menor ou igual à quantidade existente
                if (quantidade <= itemExistente.getQuantidade()) {
                    String sql = "UPDATE item SET quantidade = quantidade - ? WHERE id_produto = ?";

                    try (Connection conn = DriverManager.getConnection(URL);
                         PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setInt(1, quantidade);
                        pstmt.setInt(2, idProduto);

                        pstmt.executeUpdate();
                        System.out.println("Quantidade do item removida com sucesso");
                        return true;
                    } catch (SQLException e) {
                        System.err.println("Erro ao remover quantidade do item: " + e.getMessage());
                    }
                } else {
                    System.err.println("Quantidade a ser removida maior que a quantidade existente");
                }
            } else {
                System.err.println("Item com código do produto especificado não encontrado");
            }
        } else {
            System.err.println("ID do produto não encontrado para o código especificado");
        }
        return false;
    }

    public static List<Item> listarItens() {
        List<Item> itens = new ArrayList<>();
        String sql = "SELECT * FROM item WHERE quantidade > 0";

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

    // Função para buscar um item pelo id_produto
    public static Item buscarItemPeloIdProduto(Integer idProduto) {
        String sql = "SELECT * FROM item WHERE id_produto = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idProduto);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return criarItem(rs);
            }
        } catch (SQLException | ParseException e) {
            System.err.println("Erro ao buscar item pelo id_produto: " + e.getMessage());
        }
        return null;
    }

    // Função para incrementar a quantidade de um item existente
    public static boolean incrementarQuantidadeItem(Integer idProduto, Integer quantidade) {
        String sql = "UPDATE item SET quantidade = quantidade + ? WHERE id_produto = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, quantidade);
            pstmt.setInt(2, idProduto);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Quantidade do item incrementada com sucesso");
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao incrementar quantidade do item: " + e.getMessage());
        }
        return false;
    }

    // Função para buscar o id de um produto pelo codigo
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

    // Função para buscar o codigo de um produto pelo id
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
