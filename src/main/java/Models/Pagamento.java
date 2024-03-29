package Models;

/*
 * Classe responsável pela lógica de negócios relacionada
 * à entidade 'Pagamento'.
 * */
public class Pagamento {
    private boolean realizado;
    private String tipo;

    public Pagamento(boolean realizado, String tipo) {
        this.realizado = realizado;
        this.tipo = tipo;
    }

    // Retorna se o pagamento foi realizado ou não
    public boolean getRealizado() {
        return realizado;
    }

    // Define se o pagamento foi realizado ou não
    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    // Retorna o tipo do pagamento
    public String getTipo() {
        return tipo;
    }

    // Define o tipo do pagamento
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
