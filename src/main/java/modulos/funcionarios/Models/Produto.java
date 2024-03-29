package modulos.funcionarios.Models;

/*
* Classe responsável pela lógica de negócios relacionada
* à entidade 'Produto'.
* */
public class Produto {
    protected int id;
    protected String nome;
    protected String marca;
    protected Integer codigo;
    protected String tipo;
    protected float preco;

    public Produto(int id,
                   String nome,
                   String marca,
                   Integer codigo,
                   String tipo,
                   float preco) {
            this.id = id;
            this.nome = nome;
            this.marca = marca;
            this.codigo = codigo;
            this.tipo = tipo;
            this.preco = preco;
    }

    // Retorna o id do produto
    public int getId() {
        return id;
    }

    // Define o id do produto
    public void setId(int id) {
        this.id = id;
    }

    // Retorna o nome do produto
    public String getNome() {
        return nome;
    }

    // Define o nome do produto
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna a marca do produto
    public String getMarca() {
        return marca;
    }

    // Define a marca do produto
    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Retorna o código do produto
    public Integer getCodigo() {
        return codigo;
    }

    // Define o código do produto
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    // Retorna o tipo do produto
    public String getTipo() {
        return tipo;
    }

    // Define o tipo do produto
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Retorna o preço do produto
    public float getPreco() {
        return preco;
    }

    // Define o preço do produto
    public void setPreco(float preco) {
        this.preco = preco;
    }
}
