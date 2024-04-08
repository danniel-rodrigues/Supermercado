package Controllers;

import Auxiliar.Data;
import DAO.ItemDAO;
import Models.Item;
import Models.Produto;
import Models.Venda;
import Views.TelaVendaItem;

import static DAO.ItemDAO.buscarIdPeloCodigo;
import static DAO.ItemDAO.buscarItemPeloIdProduto;
import static DAO.ProdutoDAO.buscarProdutoPorCodigo;
import static Views.TelaVendas.adicionarItemAoCarrinho;

public class ControllerVenda {
    private TelaVendaItem viewAdicionarItem;

    public ControllerVenda(TelaVendaItem viewVendaItem) {
        this.viewAdicionarItem = viewVendaItem;
        // Configura o botão para cadastro de itens
        viewVendaItem.getbtnAdicionar().setOnAction(e -> {
            adicionarItem();
        });
    }

    private void adicionarItem() {
        String txtCodigoProduto = viewAdicionarItem.getTxtCodigoProduto().getText();
        String txtQuantidade = viewAdicionarItem.getTxtQuantidade().getText();

        String formato = "dd/MM/yyyy";

        // Verifica se há campos não preenchidos no formulário
        if(txtCodigoProduto.isEmpty() || txtQuantidade.isEmpty()) {
            // Se algum campo estiver vazio, exibe uma mensagem de erro
            viewAdicionarItem.getResposta().setText("Por favor, preencha todos os campos.");
            viewAdicionarItem.getResposta().setStyle("-fx-text-fill: red;");
        } else {
            try {
                Integer codigoProduto = Integer.valueOf(txtCodigoProduto);
                Integer quantidade = Integer.valueOf(txtQuantidade);
                Integer id_produto = buscarIdPeloCodigo(codigoProduto);
                //Item item = buscarItemPeloIdProduto(id_produto);
                Produto produto = buscarProdutoPorCodigo(codigoProduto);

                // Se nenhum erro de conversão ocorrer, cria o item
                Venda venda = new Venda(produto.getNome(), produto.getMarca(), codigoProduto, produto.getTipo(), quantidade, produto.getPreco(), (quantidade * produto.getPreco()));
                adicionarItemAoCarrinho(venda);


            } catch (NumberFormatException e) {
                // Se houver erro de conversão, exibe uma mensagem de erro
                viewAdicionarItem.getResposta().setText("Por favor, corrija os dados e tente novamente.");
                viewAdicionarItem.getResposta().setStyle("-fx-text-fill: red;");
            }
        }
    }


}
