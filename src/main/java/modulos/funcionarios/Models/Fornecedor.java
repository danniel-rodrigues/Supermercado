package modulos.funcionarios.Models;

public class Fornecedor {
    private int id;
    private String nome;
    private String cnpj;
    private String contato;
    private String email;

    public Fornecedor(String nome, String cnpj, String contato, String email) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.contato = contato;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj() {
        this.cnpj = cnpj;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Implementação do método consultarFornecedor()
    public void consultarFornecedor() {
        System.out.println("Nome: " + nome);
        System.out.println("Contato: " + contato);
        System.out.println("Email: " + email);
    }

    //implentação do método cadastrarFornecedor
    public void cadastrarFornecedor() {

         // lógica para cadastrar o fornecedor
        // 
       // 
      //
    }
}
