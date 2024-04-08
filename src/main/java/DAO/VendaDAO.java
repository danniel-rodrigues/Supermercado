package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    public static void salvarVenda() {

    }


}
