package Models;

import Auxiliar.CPF;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Date;

public class OperadorCaixa extends Funcionario{
    private final StringProperty nome_a;
    private final StringProperty cpf_a;
    private final StringProperty status_a;
    private final StringProperty telefone_a;
    private final StringProperty cargo_a;
    private final StringProperty emailPropety;

    public OperadorCaixa(String nome, String cpf, Date dataNasc, String email,
                         String telefone, String sexo, String login, String senha, String status, Endereco endereco, String cargo){
        super(nome, cpf, dataNasc, email, telefone, sexo, login, senha, status, endereco, cargo);

        nome_a = new SimpleStringProperty(nome);
        cpf_a = new SimpleStringProperty(CPF.formatarCPF(cpf));
        status_a = new SimpleStringProperty(status);
        telefone_a = new SimpleStringProperty(telefone);
        cargo_a = new SimpleStringProperty(cargo);
        emailPropety = new SimpleStringProperty(email);


    }

    public StringProperty nomeProperty() {
        return nome_a;
    }

    public StringProperty cpfProperty() {
        return cpf_a;
    }

    public StringProperty statusProperty(){
        return status_a;
    }

    public StringProperty telefoneProperty(){return telefone_a;}

    public StringProperty cargoProperty(){return cargo_a;}

    public StringProperty emailPropetyProperty(){return emailPropety;}

    @Override
    public String toString(){
        return "Nome: " + nome + " / CPF: " + cpf  + " / Telefone: " + telefone +  " / Status: " + status + " / Cargo: Operador Caixa";
    }
}