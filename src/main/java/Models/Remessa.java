package Models;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



public class Remessa {
    private final Integer id;
    private int idFornecedor;
    private String dataEnvio;
    private String dataRecebimento;
    private String status;

    public Remessa(Integer id,int idFornecedor,
                   String dataEnvio,
                   String dataRecebimento) {
        this.id = id;
        this.idFornecedor = idFornecedor;
        this.dataEnvio = dataEnvio;
        this.dataRecebimento = dataRecebimento;
    }

    // Retorna o idFornecedor da remessa
    public int getFornecedorId() {
        return idFornecedor;
    }

    // Define o idFornecedor da remessa
    public void setFornecedorId(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    // Retorna a data de envio da remessa
    public String getDataEnvio() {
        return dataEnvio;
    }

    // Define a data de envio da remessa
    public void setDataEnvio(String dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    // Retorna a data de recebimento da remessa
    public String getDataRecebimento() {
        return dataRecebimento;
    }

    // Define a data de recebimento da remessa
    public void setDataRecebimento(String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public int getId() {
        return id;
    }


    public ObjectProperty<Integer> idFornecedorProperty() {
        return new SimpleObjectProperty<>(idFornecedor);
    }

    public StringProperty dataEnvioProperty() {
        return new SimpleStringProperty(dataEnvio);
    }

    public StringProperty dataRecebimentoProperty() {
        return new SimpleStringProperty(dataRecebimento);
    }



}
