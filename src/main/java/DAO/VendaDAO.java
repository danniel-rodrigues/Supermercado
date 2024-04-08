package DAO;

import Models.Venda;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VendaDAO {
    // URL de conexão com o BD SQLite
    private static final String URL = "jdbc:sqlite:supermercado.db";

    // Comando SQL para criar a tabela caso ela não exista
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS venda (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "data TEXT NOT NULL, " +
            "valor REAL NOT NULL)";

    public static void criarTabela() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            // Executando o comando SQL para criar a tabela
            stmt.execute(CREATE_TABLE_SQL);
            System.out.println("Tabela 'venda' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela 'venda': " + e.getMessage());
        }
    }

    public static void salvarVenda(Venda venda, float totalVenda) {
        adicionarVenda(venda, totalVenda);

        Integer codProduto = venda.getCodigoProdutoItem();
        Integer qtdItensVendidos = venda.getQuantidadeItens();

        if(ItemDAO.removerItem(codProduto, qtdItensVendidos)) {
            System.out.println("Quantidade de itens vendidos removidos.");
        } else {
            System.out.println("Não foi possível remover a qtd de itens informada!");
        }
    }

    public static boolean adicionarVenda(Venda venda, float totalVenda) {
        criarTabela();
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataAtual.format(formatter);

        Integer idProduto = venda.getCodigoProdutoItem();
        var item = ItemDAO.buscarItemPeloIdProduto(idProduto);
        if(item != null) {
            String sql = "INSERT INTO venda (data, valor) VALUES (?, ?)";

            try (Connection conn = DriverManager.getConnection(URL);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, dataFormatada);
                    pstmt.setFloat(2, totalVenda);

                    pstmt.executeUpdate();
                    System.out.println("Item adicionado com sucesso.");
                    return true;
                } catch (SQLException e) {
                    System.err.println("Erro ao adicionar item: " + e.getMessage());
                }
            }
        return false;
        }
    }
