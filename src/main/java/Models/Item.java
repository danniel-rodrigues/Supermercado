package Models;

import java.util.Date;
import javafx.beans.property.*;

public class Item extends Produto{
    protected String lote;
    protected Date dataVal;
    protected Date dataFab;
    protected float peso;
    protected float quantidade;
    public Item(String nome, String marca, Integer codigo, String tipo, float preco, String status, Funcionario funcionario, String lote, Date dataVal, Date dataFab, float peso, float quantidade) {
        super(nome, marca, codigo, tipo, preco, status);

        this.lote = lote;
        this.dataVal = dataVal;
        this.dataFab = dataFab;
        this.preco = preco;
        this.peso = peso;
        this.quantidade = quantidade;
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

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public StringProperty loteProperty() {
        return new SimpleStringProperty(lote);
    }

    public ObjectProperty<Date> dataValProperty() {
        return new SimpleObjectProperty<>(dataVal);
    }

    public ObjectProperty<Date> dataFabProperty() {
        return new SimpleObjectProperty<>(dataFab);
    }

    public ObjectProperty<Float> pesoProperty() {
        return new SimpleObjectProperty<>(peso);
    }

    public ObjectProperty<Float> quantidadeProperty() {
        return new SimpleObjectProperty<>(quantidade);
    }
}
