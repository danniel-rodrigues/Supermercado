package DAO;

import Models.Venda;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static Views.TelaVendas.calcularSomaValorTotalCarrinho;

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

    public static void salvarVenda(ObservableList<Venda> carrinho) {
        criarTabela();

        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataAtual.format(formatter);

        String sql = "INSERT INTO venda (data, valor) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, dataFormatada);
            pstmt.setFloat(2, Float.parseFloat(calcularSomaValorTotalCarrinho()));

            pstmt.executeUpdate();
            System.out.println("Item adicionado com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar item: " + e.getMessage());
        }

        for (Venda venda : carrinho) {
            Integer codProduto = venda.getCodigoProdutoItem();
            Integer qtdItensVendidos = venda.getQuantidadeItens();

            if (ItemDAO.removerItem(codProduto, qtdItensVendidos)) {
                System.out.println("Quantidade de itens vendidos removida para o produto com código " + codProduto);
            } else {
                System.out.println("Não foi possível remover a quantidade de itens vendidos para o produto com código " + codProduto);
            }
        }
    }

    public static String calcularSomaValorTotal() {
        String resultado = "0.00";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            String sql = "SELECT SUM(valor) AS total FROM venda";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                double total = rs.getDouble("total");
                resultado = String.format("%.2f", total);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao calcular a soma do valor total das vendas: " + e.getMessage());
        }

        return resultado;
    }
}
