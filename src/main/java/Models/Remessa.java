package Models;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/*
 * Classe responsável pela lógica de negócios relacionada
 * à entidFornecedorade 'Remessa'.
 * */
public class Remessa {
    private final Integer id;
    private int idFornecedor;
    private String dataEnvio;
    private String dataRecebimento;
    private String status;

    public Remessa(Integer id,int idFornecedor,
                   String dataEnvio,
                   String dataRecebimento,
                   String status) {
        this.id = id;
        this.idFornecedor = idFornecedor;
        this.dataEnvio = dataEnvio;
        this.dataRecebimento = dataRecebimento;
        this.status = status;
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

    // Retorna o estado da remessa
    public String getStatus() {
        return status;
    }

    // Define o estado da remessa
    public void setEstado(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String dataEnvio() {
        return this.dataEnvio;
    }
    public String dataRecebimento() {
        return this.dataRecebimento;
    }

}
