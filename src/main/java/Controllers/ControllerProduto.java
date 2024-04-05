package Controllers;

import DAO.ProdutoDAO;
import Models.Produto;

import Views.TelaCadastroProduto;
import Views.TelaBuscarProduto;
import Views.TelaAlterarProduto;
public class ControllerProduto {
    private TelaCadastroProduto viewCadastroProduto;
    private TelaBuscarProduto viewBuscarProduto;
    private TelaAlterarProduto viewAlterarProduto;

    public ControllerProduto(TelaCadastroProduto viewCadastroProduto) {
        this.viewCadastroProduto = viewCadastroProduto;
        // Configura o botão para cadastro de produtos
        viewCadastroProduto.getBtnCadastrar().setOnAction(e -> {
            cadastrarProduto();
        });
    }

    public ControllerProduto(TelaBuscarProduto viewBuscarProduto) {
        this.viewBuscarProduto = viewBuscarProduto;
        // Configura o botão para realizar a busca do produto
        viewBuscarProduto.getBtnBuscar().setOnAction(e -> {
            alterarProduto();
        });
    }
    public ControllerProduto(TelaAlterarProduto viewAlterarProduto) {
        this.viewAlterarProduto = viewAlterarProduto;
        viewAlterarProduto.getBtnAlterarCadastro().setOnAction(e -> {
            alterarDadosProduto();
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

    public void alterarProduto() {
        String txtCodigo = viewBuscarProduto.getTxtCodigo().getText();

        if(!txtCodigo.isEmpty()) {
            Produto produto = ProdutoDAO.buscarProdutoPorCodigo(Integer.valueOf(txtCodigo));

            if(produto == null) {
                viewBuscarProduto.getLblAviso().setText("Produto não encontrado".toUpperCase());
                viewBuscarProduto.getLblAviso().setStyle("-fx-text-fill: red;");
            } else {
                TelaAlterarProduto telaAlterarProduto = new TelaAlterarProduto();
                telaAlterarProduto.show(viewBuscarProduto.getSt(), produto);
            }
        }
    }

    public void alterarDadosProduto() {
        String nome = viewAlterarProduto.getTxtNome().getText();
        String marca = viewAlterarProduto.getTxtMarca().getText();
        String txtCodigo = viewAlterarProduto.getTxtCodigo().getText();
        String tipo = viewAlterarProduto.getTxtTipo().getText();
        String txtPreco = viewAlterarProduto.getTxtPreco().getText();
        String status = viewAlterarProduto.getStatus().getValue();

        // Verifica se há campos não preenchidos
        if(nome.isEmpty() || marca.isEmpty() || txtCodigo.isEmpty() || tipo.isEmpty() ||
                txtPreco.isEmpty() || status.isEmpty() || status.equals("Selecione")) {

            // Se algum campo estiver vazio, exibe uma mensagem de erro
            viewAlterarProduto.getResposta().setText("Por favor, preencha todos os campos.");
            viewAlterarProduto.getResposta().setStyle("-fx-text-fill: red;");
        } else {
            try {
                Integer codigo = Integer.valueOf(txtCodigo);
                float preco = Float.parseFloat(txtPreco);

                // Se nenhum erro de conversão ocorrer, cria o produto
                Produto produto = new Produto(nome, marca, codigo, tipo, preco, status);
                adicionarProduto(produto);

                if(ProdutoDAO.atualizarProduto(produto)) {
                    viewAlterarProduto.getResposta().setText("Produto alterado com sucesso!".toUpperCase());
                    viewAlterarProduto.getResposta().setStyle("-fx-text-fill: green;");
                    // Limpa os campos após alteração do cadastro
                    viewAlterarProduto.limparCampos();
                }

            } catch (NumberFormatException e) {
                // Se houver erro de conversão, exibe uma mensagem de erro
                viewAlterarProduto.getResposta().setText("Por favor, insira um número válido para o código ou preço.");
                viewAlterarProduto.getResposta().setStyle("-fx-text-fill: red;");
            }
        }
    }

}
