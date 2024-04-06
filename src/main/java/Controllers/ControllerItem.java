package Controllers;

import DAO.ItemDAO;
import Models.Item;
import Views.TelaCadastroItem;
import Views.TelaRemoverItem;

public class ControllerItem {
    private TelaCadastroItem viewCadastroItem;
    private TelaRemoverItem viewRemoverItem;

    public ControllerItem(TelaCadastroItem viewCadastroItem) {
        this.viewCadastroItem = viewCadastroItem;
    }
    public ControllerItem(TelaRemoverItem viewRemoverItem) {
        this.viewRemoverItem = viewRemoverItem;
    }
}
