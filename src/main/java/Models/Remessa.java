package Models;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Remessa {
    private final Integer id;
    private int idFornecedor;
    private Date dataEnvio;
    private Date dataRecebimento;

    public Remessa(Integer id,int idFornecedor,
                   Date dataEnvio,
                   Date dataRecebimento) {
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
    public Date getDataEnvio() {
        return dataEnvio;
    }

    // Define a data de envio da remessa
    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    // Retorna a data de recebimento da remessa
    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    // Define a data de recebimento da remessa
    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public int getId() {
        return id;
    }

    public StringProperty dataEnvio() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataDeEnvio = sdf.format(dataEnvio);
        return new SimpleStringProperty(dataDeEnvio);
    }
    public StringProperty dataRecebimento() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataDeRecebimento = sdf.format(dataRecebimento);
        return new SimpleStringProperty(dataDeRecebimento);
    }

}
