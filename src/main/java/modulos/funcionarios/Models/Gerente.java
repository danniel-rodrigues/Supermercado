package modulos.funcionarios.Models;

import javafx.beans.property.StringProperty;

import java.util.Date;

public class Gerente extends Funcionario {


    public Gerente(String nome, StringProperty cpf, Date dataNasc, String email, String telefone, String sexo, String login, String senha, String status, Endereco endereco){
        super(nome, String.valueOf(cpf), dataNasc, email, telefone, sexo, login, senha, status, endereco);

    }


    @Override
    public String toString(){
        return "Nome: " + nome + " | CPF: " + cpf  + " | Telefone: " + telefone +  " | Status: " + status + " | Cargo: Gerente";
    }
}