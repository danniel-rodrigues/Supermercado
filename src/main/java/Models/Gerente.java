package Models;

import java.util.Date;

public class Gerente extends Funcionario{

    public Gerente(String nome, String cpf, Date dataNasc, String email, String telefone, String sexo, String login, String senha, String status, Endereco endereco){
        super(nome, cpf, dataNasc, email, telefone, sexo, login, senha, status, endereco);
    }
}