package Models;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

// Classe responsável pela lógica de negócios relacionada à entidade funcionário
public class Funcionario {
    protected int id;
    protected String nome;
    protected String cpf;
    protected Date dataNasc;
    protected String email;
    protected String telefone;
    protected String sexo;
    protected String login;
    protected String senha;
    protected String status;
    protected Endereco endereco;
    protected String cargo;

    public Funcionario(String nome, String cpf, Date dataNasc, String email, String telefone, String sexo, String login,
                       String senha, String status, Endereco endereco, String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.login = login;
        this.senha = senha;
        this.status = status;
        this.endereco = endereco;
        this.cargo = cargo;
    }

    // Retorna o id do funcionário
    public int getId() {return id;}

    // Define o id do funcionário
    public void setId(int id) {this.id = id;}

    // Retorna o nome do funcionário
    public String getNome() {
        return nome;
    }

    // Define o nome do funcionário
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna a data de nascimento do funcionário
    public Date getDataNasc() {
        return dataNasc;
    }

    // Define a data de nascimento do funcionário
    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    // Retorna o CPF do funcionário
    public String getCpf() {
        return cpf;
    }

    // Define o CPF do funcionário
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Retorna o e-mail do funcionário
    public String getEmail() {
        return email;
    }

    // Define o e-mail do funcionário
    public void setEmail(String email) {
        this.email = email;
    }

    // Retorna o telefone do funcionário
    public String getTelefone() {
        return telefone;
    }

    // Define o telefone do funcionário
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // Retorna o sexo do funcionário
    public String getSexo() {
        return sexo;
    }

    // Define o sexo do funcionário
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    // Retorna o login do funcionário
    public String getLogin() {
        return login;
    }

    // Define o login do funcionário
    public void setLogin(String login) {
        this.login = login;
    }

    // Retorna a senha do funcionário
    public String getSenha() {
        return senha;
    }

    // Define a senha do funcionário
    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Retorna o status do funcionário
    public String getStatus() {
        return status;
    }

    // Define o status do funcionário
    public void setStatus(String status) {
        this.status = status;
    }

    // Retorna o endereço do funcionário
    public Endereco getEndereco() {
        return endereco;
    }

    // Define o endereço do funcionário
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    // Retorna o cargo do funcionario
    public String getCargo() { return cargo; }

    // Define o cargo do funcionario
    public void setCargo(String cargo) { this.cargo = cargo; }

    public StringProperty nomeProperty(){
        return new SimpleStringProperty(nome);
    }

    public StringProperty cpfProperty(){
        return new SimpleStringProperty(cpf);
    }

    public StringProperty telefoneProperty(){
        return new SimpleStringProperty(telefone);
    }

    public StringProperty cargoProperty(){
        return new SimpleStringProperty(cargo);
    }

    public StringProperty statusProperty(){
        return new SimpleStringProperty(status);
    }

    public StringProperty emailProperty(){
        return new SimpleStringProperty(email);
    }

    @Override
    public String toString(){
        return "Nome: " + nome + " / CPF: " + cpf  + " / Telefone: " + telefone +  " / Status: " + status + " / Cargo: " + cargo;
    }
}