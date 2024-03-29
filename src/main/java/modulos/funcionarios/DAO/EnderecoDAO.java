package modulos.funcionarios.DAO;

import modulos.funcionarios.Models.Endereco;

import java.sql.*;

public class EnderecoDAO {
    // URL de conexão com o banco de dados SQLite
    private static final String URL = "jdbc:sqlite:endereco.db";

    // Comando SQL para criar a tabela caso ela não exista
    private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS endereco (" +
            "rua TEXT NOT NULL," +
            "bairro TEXT NOT NULL," +
            "cidade TEXT NOT NULL," +
            "estado TEXT NOT NULL," +
            "cep TEXT NOT NULL," +
            "numero TEXT NOT NULL," +
            "cpf TEXT NOT NULL" +
            ")";

    // Método para criar a tabela no banco de dados
    public static void criarTabela() {
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            // Executando o comando SQL para criar a tabela
            stmt.execute(CREATE_TABLE_SQL);
            System.out.println("Tabela 'endereco' criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    // Método para adicionar um endereço ao banco de dados
    public static void adicionarEndereco(Endereco endereco) {
        criarTabela();
        String sql = "INSERT INTO endereco (rua, bairro, cidade, estado, cep, numero, cpf) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, endereco.getRua());
            pstmt.setString(2, endereco.getBairro());
            pstmt.setString(3, endereco.getCidade());
            pstmt.setString(4, endereco.getEstado());
            pstmt.setString(5, endereco.getCep());
            pstmt.setString(6, endereco.getNumero());
            pstmt.setString(7, endereco.getCpf());

            pstmt.executeUpdate();
            System.out.println("Endereço adicionado com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar endereço: " + e.getMessage());
        }
    }

    // Método para retornar um endereço pelo CPF
    public static Endereco buscarEnderecoPorCPF(String cpf) {
        criarTabela();
        String sql = "SELECT * FROM endereco WHERE cpf = ?";
        Endereco endereco = null;

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            ResultSet rs = pstmt.executeQuery();

            // Verificando se o ResultSet contém algum resultado
            if (rs.next()) {
                // Criando um objeto Endereco com os dados do ResultSet
                endereco = new Endereco(
                        rs.getString("rua"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("cep"),
                        rs.getString("numero"),
                        rs.getString("cpf")
                );
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar endereço por CPF: " + e.getMessage());
        }

        return endereco;
    }

    // Método para atualizar um endereço no banco de dados
    public static boolean atualizarEndereco(Endereco endereco) {
        String sql = "UPDATE endereco SET rua = ?, bairro = ?, cidade = ?, estado = ?, cep = ?, numero = ? WHERE cpf = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, endereco.getRua());
            pstmt.setString(2, endereco.getBairro());
            pstmt.setString(3, endereco.getCidade());
            pstmt.setString(4, endereco.getEstado());
            pstmt.setString(5, endereco.getCep());
            pstmt.setString(6, endereco.getNumero());
            pstmt.setString(7, endereco.getCpf());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Endereço atualizado com sucesso.");
                return true; // Retorna true se a operação foi bem-sucedida
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar endereço: " + e.getMessage());
        }
        return false; // Retorna false se a operação falhar por algum motivo
    }
    public static void main(String[] args) {
        String cpf = "12345678901"; // CPF de exemplo

        // Buscando o endereço pelo CPF
        Endereco endereco = buscarEnderecoPorCPF(cpf);

        // Verificando se um endereço foi encontrado e imprimindo suas informações
        if (endereco != null) {
            System.out.println("Endereço encontrado para o CPF " + cpf + ":");
            System.out.println("Rua: " + endereco.getRua());
            System.out.println("Bairro: " + endereco.getBairro());
            System.out.println("Cidade: " + endereco.getCidade());
            System.out.println("Estado: " + endereco.getEstado());
            System.out.println("CEP: " + endereco.getCep());
            System.out.println("Número: " + endereco.getNumero());
            System.out.println("CPF: " + endereco.getCpf());
        } else {
            System.out.println("Nenhum endereço encontrado para o CPF " + cpf);
        }
    }
}

