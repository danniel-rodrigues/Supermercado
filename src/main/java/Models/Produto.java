package Models;

import javafx.beans.property.*;

/*
 * Classe responsável pela lógica de negócios relacionada
 * à entidade 'Produto'.
 * */
public class Produto {
    protected String nome;
    protected String marca;
    protected Integer codigo;
    protected String tipo;
    protected float preco;
    protected String status;
//    protected Funcionario funcionario;
    public Produto(String nome,
                   String marca,
                   Integer codigo,
                   String tipo,
                   float preco,
                   String status) {
        this.nome = nome;
        this.marca = marca;
        this.codigo = codigo;
        this.tipo = tipo;
        this.preco = preco;
        this.status = status;
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

    // Retorna o status do produto
    public String getStatus() {
        return status;
    }

    // Define o status do produto
    public void setStatus(String status) {
        this.status = status;
    }

    // Retorna o funcionario que cadastrou o produto
//    public Funcionario getFuncionario() {return funcionario;}

    // Define o funcionário que cadastrou o produto
//    public void setFuncionario(Funcionario funcionario) {this.funcionario = funcionario;}

    public StringProperty nomeProperty(){
        return new SimpleStringProperty(nome);
    }

    public StringProperty marcaProperty(){
        return new SimpleStringProperty(marca);
    }

    public ObjectProperty<Integer> codigoProperty(){
        return new SimpleObjectProperty<>(codigo);
    }

    public StringProperty tipoProperty(){
        return new SimpleStringProperty(tipo);
    }

    public ObjectProperty<Float> precoProperty(){
        return new SimpleObjectProperty<>(preco);
    }
}
