package Controllers;

import DAO.ProdutoDAO;
import Models.Produto;

import Views.TelaCadastroProduto;
import Views.TelaBuscarProduto;
import Views.TelaAlterarProduto;
public class ControllerProduto {
    private final TelaCadastroProduto viewCadastroProduto;
    private TelaBuscarProduto viewBuscarProduto;
    private TelaAlterarProduto viewAlterarProduto;

    public ControllerProduto(TelaCadastroProduto viewCadastroProduto) {
        this.viewCadastroProduto = viewCadastroProduto;
        // Configura o botão para cadastro de produtos
        viewCadastroProduto.getBtnCadastrar().setOnAction(e -> {
            cadastrarProduto();
        });
    }

    // Método para realizar cadastro de um novo produto
    private void cadastrarProduto() {
        String nome = viewCadastroProduto.getTxtNome().getText();
        String marca = viewCadastroProduto.getTxtMarca().getText();
        String txtCodigo = viewCadastroProduto.getTxtCodigo().getText();
        String tipo = viewCadastroProduto.getTxtTipo().getText();
        String txtPreco = viewCadastroProduto.getTxtPreco().getText();
        String status = viewCadastroProduto.getStatus().getValue();

        // Verifica se há campos não preenchidos
        if(nome.isEmpty() || marca.isEmpty() || txtCodigo.isEmpty() || tipo.isEmpty() ||
                txtPreco.isEmpty() || status.isEmpty() || status.equals("Selecione")) {

            // Se algum campo estiver vazio, exibe uma mensagem de erro
            viewCadastroProduto.getResposta().setText("Por favor, preencha todos os campos.");
            viewCadastroProduto.getResposta().setStyle("-fx-text-fill: red;");
        } else {
            try {
                Integer codigo = Integer.valueOf(txtCodigo);
                float preco = Float.parseFloat(txtPreco);

                // Se nenhum erro de conversão ocorrer, cria o produto
                Produto produto = new Produto(nome, marca, codigo, tipo, preco, status);
                adicionarProduto(produto);
            } catch (NumberFormatException e) {
                // Se houver erro de conversão, exibe uma mensagem de erro
                viewCadastroProduto.getResposta().setText("Por favor, insira um número válido para o código ou preço.");
                viewCadastroProduto.getResposta().setStyle("-fx-text-fill: red;");
            }
        }
    }

    // Método para realizar a inserção do produto no banco de dados
    public void adicionarProduto(Produto produto) {
        if(ProdutoDAO.adicionarProduto(produto)) {
            viewCadastroProduto.getResposta().setText("Produto cadastrado com sucesso!");
            viewCadastroProduto.getResposta().setStyle("-fx-text-fill: green;");

            // Limpa os campos de entrada após o cadastro
            viewCadastroProduto.limparCampos();
        } else {
            viewCadastroProduto.getResposta().setText("Erro na inserção!");
            viewCadastroProduto.getResposta().setStyle("-fx-text-fill: red;");
        }
    }




}
