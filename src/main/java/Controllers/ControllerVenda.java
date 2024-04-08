package Controllers;

import DAO.ItemDAO;
import Models.Item;
import Views.TelaVendaItem;

public class ControllerVenda {
    private TelaVendaItem viewAdicionarItem;

    public ControllerVenda(TelaVendaItem viewVendaItem) {
        this.viewAdicionarItem = viewVendaItem;
        // Configura o botão para cadastro de itens
        viewVendaItem.getbtnAdicionar().setOnAction(e -> {
            //adicionarItem();
        });
    }

    /*public void adicionarItem(Item item) {
        try {
            if(ItemDAO.adicionarItem(item)) {
                viewCadastroItem.getResposta().setText("Item cadastrado com sucesso!");
                viewCadastroItem.getResposta().setStyle("-fx-text-fill: green;");

                // Limpa os campos de entrada após o cadastro
                viewCadastroItem.limparCampos();
            } else {
                viewCadastroItem.getResposta().setText("Erro na inserção!");
                viewCadastroItem.getResposta().setStyle("-fx-text-fill: red;");
            }
        } catch (NullPointerException e) {
            viewCadastroItem.getResposta().setText("Erro: Código do produto não existe!");
            viewCadastroItem.getResposta().setStyle("-fx-text-fill: red;");
        }
    }*/
}
