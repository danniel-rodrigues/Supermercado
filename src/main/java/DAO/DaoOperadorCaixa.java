package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Models.OperadorCaixa;
import Models.Endereco;

public class DaoOperadorCaixa {
    private Connection connection;

    public DaoOperadorCaixa(Connection connection) {
        this.connection = connection;
    }

    public void adicionarOperadorCaixa(OperadorCaixa operadorCaixa) throws SQLException {
        String sql = "INSERT INTO OperadorCaixa (nome, cpf, dataNasc, email, telefone, sexo, login, senha, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, operadorCaixa.getNome());
            statement.setString(2, operadorCaixa.getCpf());
            statement.setDate(3, new java.sql.Date(operadorCaixa.getDataNasc().getTime()));
            statement.setString(4, operadorCaixa.getEmail());
            statement.setString(5, operadorCaixa.getTelefone());
            statement.setString(6, operadorCaixa.getSexo());
            statement.setString(7, operadorCaixa.getLogin());
            statement.setString(8, operadorCaixa.getSenha());
            statement.setString(9, operadorCaixa.getStatus());
            statement.executeUpdate();
        }
    }

    public List<OperadorCaixa> listarOperadoresCaixa() throws SQLException {
        List<OperadorCaixa> operadoresCaixa = new ArrayList<>();
        String sql = "SELECT * FROM OperadorCaixa";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                Date dataNasc = resultSet.getDate("dataNasc");
                String email = resultSet.getString("email");
                String telefone = resultSet.getString("telefone");
                String sexo = resultSet.getString("sexo");
                String login = resultSet.getString("login");
                String senha = resultSet.getString("senha");
                String status = resultSet.getString("status");
                // Aqui você precisaria carregar o Endereco do operador, se necessário
                Endereco endereco = null; // Implemente a lógica para carregar o Endereco
                OperadorCaixa operadorCaixa = new OperadorCaixa(nome, cpf, dataNasc, email, telefone, sexo, login, senha, status, endereco);
                operadoresCaixa.add(operadorCaixa);
            }
        }
        return operadoresCaixa;
    }
}
