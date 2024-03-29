package Models;

import java.util.Date;

/*
 * Classe responsável pela lógica de negócios relacionada
 * à entidade 'Item'.
 * */
public class Item extends Produto {
    private Date dataValidade;
    private Date dataFabricacao;
    private float peso;
    private String lote;
    public Item(String nome,
                String marca,
                Integer codigo,
                String tipo,
                float preco,
                String status,
                Funcionario funcionario,
                Date dataValidade,
                Date dataFabricacao,
                float peso,
                String lote) {
        super(nome, marca, codigo, tipo, preco, status, funcionario);
        this.dataValidade = dataValidade;
        this.dataFabricacao = dataFabricacao;
        this.peso = peso;
        this.lote = lote;
    }

    // Retorna a data de validade do item
    public Date getDataValidade() {
        return dataValidade;
    }

    // Define a data de validade do item
    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    // Retorna a data de fabricação do item
    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    // Define a data de fabricação do item
    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    // Retorna o peso do item
    public float getPeso() {
        return peso;
    }

    // Define o peso do item
    public void setPeso(float peso) {
        this.peso = peso;
    }

    // Retorna o lote do item
    public String getLote() {
        return lote;
    }

    // Define o lote do item
    public void setLote(String lote) {
        this.lote = lote;
    }
}
