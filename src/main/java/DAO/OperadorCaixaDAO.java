package DAO;

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


import Models.OperadorCaixa;
import Models.Endereco;
public class OperadorCaixaDAO {
    // URL de conexão com o banco de dados SQLite
    private static final String URL = "jdbc:sqlite:operador_caixa.db";

    // SQL para criar a tabela caso ela não exista
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS operador_caixa (" +
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
            System.out.println("Tabela 'operador_caixa' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    // Metodo para adicionar um operador ao banco de dados
    public static void adicionarOperador(OperadorCaixa operador) {
        criarTabela();
        String sql = "INSERT INTO operador_caixa (nome, cpf, data_nasc, email, telefone, sexo, login, senha, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, operador.getNome());
            pstmt.setString(2, operador.getCpf());
            pstmt.setString(3, operador.getDataNasc().toString()); // Convertendo a data para String por simplicidade
            pstmt.setString(4, operador.getEmail());
            pstmt.setString(5, operador.getTelefone());
            pstmt.setString(6, operador.getSexo());
            pstmt.setString(7, operador.getLogin());
            pstmt.setString(8, operador.getSenha());
            pstmt.setString(9, operador.getStatus());

            pstmt.executeUpdate();
            System.out.println("Operador adicionado com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar operador: " + e.getMessage());
        }
    }

    // Método para listar todos os operadores do banco de dados
    public static List<OperadorCaixa> listarOperadores() {
        List<OperadorCaixa> operadores = new ArrayList<>();
        String sql = "SELECT * FROM operador_caixa WHERE status = 'Ativo'";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
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

                OperadorCaixa operador = new OperadorCaixa(nome, cpf, dataNasc, email, telefone, sexo, login, senha, status, null);
                operadores.add(operador);
            }
        } catch (SQLException | ParseException e) {
            System.err.println("Erro ao listar operadores: " + e.getMessage());
        }
        return operadores;
    }
}
