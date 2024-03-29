package modulos.funcionarios.Models;

/*
 * Classe responsável pela lógica de negócios relacionada
 * à entidade 'Secao'.
 * */
public class Secao {
    private int id;
    private String nome;

    public Secao(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Retorna o id da seção
    public int getId() {
        return id;
    }

    // Define o id da seção
    public void setId(int id) {
        this.id = id;
    }

    // Retorna o nome da seção
    public String getNome() {
        return nome;
    }

    // Define o nome da seção
    public void setNome(String nome) {
        this.nome = nome;
    }
}
