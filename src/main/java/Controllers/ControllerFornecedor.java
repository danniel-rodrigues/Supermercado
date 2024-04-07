package Controllers;

import DAO.FornecedorDAO;
import Models.Fornecedor;
import Views.TelaCadastroFornecedor;

public class ControllerFornecedor {
    private TelaCadastroFornecedor viewCadastroFornecedor;

    public ControllerFornecedor(TelaCadastroFornecedor viewCadastroFornecedor) {
        this.viewCadastroFornecedor = viewCadastroFornecedor;
        viewCadastroFornecedor.getBtnCadastrar().setOnAction(e -> {

        });
    }
}
