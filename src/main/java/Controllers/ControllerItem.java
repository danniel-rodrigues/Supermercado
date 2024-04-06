package Controllers;

import Auxiliar.Data;
import DAO.ItemDAO;
import DAO.ProdutoDAO;
import Models.Item;
import Models.Produto;
import Views.TelaCadastroItem;
import Views.TelaRemoverItem;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ControllerItem {
    private TelaCadastroItem viewCadastroItem;
    private TelaRemoverItem viewRemoverItem;

    public ControllerItem(TelaCadastroItem viewCadastroItem) {
        this.viewCadastroItem = viewCadastroItem;
        // Configura o botão para cadastro de itens
        viewCadastroItem.getBtnCadastrar().setOnAction(e -> {
            cadastrarItem();
        });
    }
    public ControllerItem(TelaRemoverItem viewRemoverItem) {
        this.viewRemoverItem = viewRemoverItem;
    }


    private void cadastrarItem() {
        String txtCodigoProduto = viewCadastroItem.getTxtCodigoProduto().getText();
        String lote = viewCadastroItem.getTxtLote().getText();
        String dataValidade = viewCadastroItem.getTxtDataVal().getText();
        String dataFabricacao = viewCadastroItem.getTxtDataFab().getText();
        String txtPeso = viewCadastroItem.getTxtPeso().getText();
        String txtQuantidade = viewCadastroItem.getTxtQuantidade().getText();

        String formato = "dd/MM/yyyy";

        // Verifica se há campos não preenchidos no formulário
        if(txtCodigoProduto.isEmpty() || lote.isEmpty() || dataValidade.isEmpty() || dataFabricacao.isEmpty() || txtPeso.isEmpty() || txtQuantidade.isEmpty()) {
            // Se algum campo estiver vazio, exibe uma mensagem de erro
            viewCadastroItem.getResposta().setText("Por favor, preencha todos os campos.");
            viewCadastroItem.getResposta().setStyle("-fx-text-fill: red;");
        } else {
            try {
                Integer codigoProduto = Integer.valueOf(txtCodigoProduto);
                Integer quantidade = Integer.valueOf(txtQuantidade);
                float peso = Float.parseFloat(txtPeso);

                // Se nenhum erro de conversão ocorrer, cria o item
                Item item = new Item(codigoProduto, lote, Data.converterStringParaDate(dataValidade, formato), Data.converterStringParaDate(dataFabricacao, formato), peso, quantidade);
                adicionarItem(item);
            } catch (NumberFormatException e) {
                // Se houver erro de conversão, exibe uma mensagem de erro
                viewCadastroItem.getResposta().setText("Por favor, corrija os dados e tente novamente.");
                viewCadastroItem.getResposta().setStyle("-fx-text-fill: red;");
            }
        }
    }

    public void adicionarItem(Item item) {
        if(ItemDAO.adicionarItem(item)) {
            viewCadastroItem.getResposta().setText("Item cadastrado com sucesso!");
            viewCadastroItem.getResposta().setStyle("-fx-text-fill: green;");

            // Limpa os campos de entrada após o cadastro
            viewCadastroItem.limparCampos();
        } else {
            viewCadastroItem.getResposta().setText("Erro na inserção!");
            viewCadastroItem.getResposta().setStyle("-fx-text-fill: red;");
        }
    }
}
