package modulos.funcionarios.Models;

import java.util.Date;

/*
 * Classe responsável pela lógica de negócios relacionada
 * à entidade 'Remessa'.
 * */
public class Remessa {
    private int id;
    private Date dataEnvio;
    private Date dataRecebimento;
    private String estado;

    public Remessa(int id,
                   Date dataEnvio,
                   Date dataRecebimento,
                   String estado) {
        this.id = id;
        this.dataEnvio = dataEnvio;
        this.dataRecebimento = dataRecebimento;
        this.estado = estado;
    }

    // Retorna o id da remessa
    public int getId() {
        return id;
    }

    // Define o id da remessa
    public void setId(int id) {
        this.id = id;
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

    // Retorna o estado da remessa
    public String getEstado() {
        return estado;
    }

    // Define o estado da remessa
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
