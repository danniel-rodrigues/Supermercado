package Controllers;

import DAO.FornecedorDAO;
import Models.Fornecedor;
import Views.TelaCadastroFornecedor;

public class ControllerFornecedor {
    private final TelaCadastroFornecedor viewCadastroFornecedor;

    public ControllerFornecedor(TelaCadastroFornecedor viewCadastroFornecedor) {
        this.viewCadastroFornecedor = viewCadastroFornecedor;
        viewCadastroFornecedor.getBtnCadastrar().setOnAction(e -> cadastrarFornecedor());
    }

    // Método para realizar cadastro de um novo fornecedor
    private void cadastrarFornecedor() {
        String nome = viewCadastroFornecedor.getTxtNome().getText();
        String cnpj = viewCadastroFornecedor.getTxtCNPJ().getText();
        String email = viewCadastroFornecedor.getTxtEmail().getText();
        String telefone = viewCadastroFornecedor.getTxtTelefone().getText();

        // Verificar se há campos não preenchidos no formulário
        if(nome.isEmpty() || cnpj.isEmpty() || email.isEmpty() || telefone.isEmpty()) {
            // Se algum campo estiver vazio, exibe uma mensagem de erro
            viewCadastroFornecedor.getResposta().setText("Por favor, preencha todos os campos.");
            viewCadastroFornecedor.getResposta().setStyle("-fx-text-fill: red;");
        } else {
            Fornecedor fornecedor = new Fornecedor(nome, cnpj,email, telefone);
            adicionarFornecedor(fornecedor);
        }
    }

    private void adicionarFornecedor(Fornecedor fornecedor) {
        if(FornecedorDAO.adicionarFornecedor(fornecedor)) {
            viewCadastroFornecedor.getResposta().setText("Produto cadastrado com sucesso!");
            viewCadastroFornecedor.getResposta().setStyle("-fx-text-fill: green;");

            // Limpa os campos de entrada após o cadastro
            viewCadastroFornecedor.limparCampos();
        } else {
            viewCadastroFornecedor.getResposta().setText("Erro na inserção!");
            viewCadastroFornecedor.getResposta().setStyle("-fx-text-fill: red;");
        }
    }
}
