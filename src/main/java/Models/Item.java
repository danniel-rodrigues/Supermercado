package Models;

import java.util.Date;
import javafx.beans.property.*;

public class Item{
    protected Integer codigoProduto;
    protected String lote;
    protected Date dataVal;
    protected Date dataFab;
    protected float peso;
    protected Integer quantidade;
    public Item(Integer codigoProduto, String lote, Date dataVal, Date dataFab, float peso, Integer quantidade) {
        this.codigoProduto = codigoProduto;
        this.lote = lote;
        this.dataVal = dataVal;
        this.dataFab = dataFab;
        this.peso = peso;
        this.quantidade = quantidade;
    }

    public Integer getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Integer codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Date getDataVal() {
        return dataVal;
    }

    public void setDataVal(Date dataVal) {
        this.dataVal = dataVal;
    }

    public Date getDataFab() {
        return dataFab;
    }

    public void setDataFab(Date dataFab) {
        this.dataFab = dataFab;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public ObjectProperty<Integer> codigoProdutoProperty(){
        return new SimpleObjectProperty<>(codigoProduto);
    }

    public ObjectProperty<Date> dataFabProperty() {
        return new SimpleObjectProperty<>(dataFab);
    }

    public ObjectProperty<Date> dataValProperty() {
        return new SimpleObjectProperty<>(dataVal);
    }

    public ObjectProperty<Float> pesoProperty() {
        return new SimpleObjectProperty<>(peso);
    }

    public StringProperty loteProperty() {
        return new SimpleStringProperty(lote);
    }

    public ObjectProperty<Integer> quantidadeProperty() {
        return new SimpleObjectProperty<>(quantidade);
    }
}
