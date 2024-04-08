package Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * Classe responsável pela lógica de negócios relacionada
 * à entidade 'Venda'.
 * */
public class Venda {
    private int id;
    private String nomeProduto;
    private String marcaProduto;
    private Integer codigoProdutoItem;
    private String tipoProduto;
    private Integer quantidadeItens;
    private float precoProduto;
    private float valorTotal;

    public Venda(
                 String nomeProduto,
                 String marcaProduto,
                 Integer codigoProdutoItem,
                 String tipoProduto,
                 Integer quantidadeItens,
                 float precoProduto,
                 float valorTotal
                 ) {
        //this.id = id;
        this.nomeProduto = nomeProduto;
        this.marcaProduto = marcaProduto;
        this.codigoProdutoItem = codigoProdutoItem;
        this.tipoProduto = tipoProduto;
        this.quantidadeItens = quantidadeItens;
        this.precoProduto = precoProduto;
        this.valorTotal = quantidadeItens * precoProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getMarcaProduto() {
        return marcaProduto;
    }

    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public Integer getCodigoProdutoItem() {
        return codigoProdutoItem;
    }

    public void setCodigoProdutoItem(Integer codigoProdutoItem) {
        this.codigoProdutoItem = codigoProdutoItem;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Integer getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(Integer quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public float getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(float precoProduto) {
        this.precoProduto = precoProduto;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ObjectProperty<Integer> idProperty(){
        return new SimpleObjectProperty<>(id);
    }

    public StringProperty nomeProperty(){
        return new SimpleStringProperty(nomeProduto);
    }

    public StringProperty marcaProperty(){
        return new SimpleStringProperty(marcaProduto);
    }

    public ObjectProperty<Integer> codigoProdutoProperty(){
        return new SimpleObjectProperty<>(codigoProdutoItem);
    }

    public StringProperty tipoProperty(){
        return new SimpleStringProperty(tipoProduto);
    }

    public ObjectProperty<Integer> quantidadeProperty() {
        return new SimpleObjectProperty<>(quantidadeItens);
    }

    public ObjectProperty<Float> precoProperty(){
        return new SimpleObjectProperty<>(precoProduto);
    }

    public ObjectProperty<Float> valorTotalProperty(){
        return new SimpleObjectProperty<>(valorTotal);
    }
}
