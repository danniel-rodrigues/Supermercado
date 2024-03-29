package Models;


/*
 * Classe responsável pela lógica de negócios relacionada
 * à entidFornecedorade 'Remessa'.
 * */
public class Remessa {
    private final Integer id;
    private int idFornecedor;
    private String dataEnvio;
    private String dataRecebimento;
    private String estado;

    public Remessa(Integer id,int idFornecedor,
                   String dataEnvio,
                   String dataRecebimento,
                   String estado) {
        this.id = id;
        this.idFornecedor = idFornecedor;
        this.dataEnvio = dataEnvio;
        this.dataRecebimento = dataRecebimento;
        this.estado = estado;
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
    public String getEstado() {
        return estado;
    }

    // Define o estado da remessa
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

}
