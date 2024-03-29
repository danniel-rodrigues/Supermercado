package Models;

/*
 * Classe responsável pela lógica de negócios relacionada
 * à entidade 'Venda'.
 * */
public class Venda {
    private int id;
    private float valor;

    public Venda(int id, float valor) {
        this.id = id;
        this.valor = valor;
    }

    // Retorna o id da venda
    public int getId() {
        return id;
    }

    // Define o id da venda
    public void setId(int id) {
        this.id = id;
    }

    // Retorna o valor da venda
    public float getValor() {
        return valor;
    }

    // Define o valor da venda
    public void setValor(float valor) {
        this.valor = valor;
    }
}
