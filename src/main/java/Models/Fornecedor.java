package Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Fornecedor {
    private int id;
    private String nome;
    private String cnpj;
    private String email;
    private String telefone;

    public Fornecedor(String nome, String cnpj, String email, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj() {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String contato) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Implementação do método consultarFornecedor()
    public void consultarFornecedor() {
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Telefone: " + telefone);
    }

    //implentação do método cadastrarFornecedor
    public void cadastrarFornecedor() {

         // lógica para cadastrar o fornecedor
        // 
       // 
      //
    }
    public StringProperty nomeProperty() {
        return new SimpleStringProperty(nome);
    }
    public StringProperty CNPJProperty() {
        return new SimpleStringProperty(cnpj);
    }
    public StringProperty emailProperty() {
        return new SimpleStringProperty(email);
    }
    public StringProperty telefoneProperty() {
        return new SimpleStringProperty(telefone);
    }
}
