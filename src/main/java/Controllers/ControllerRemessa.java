package Controllers;

import Auxiliar.Data;
import DAO.FornecedorDAO;
import DAO.RemessaDAO;
import Models.Remessa;
import Views.TelaCadastroRemessa;


public class ControllerRemessa {
    private TelaCadastroRemessa view;

    public ControllerRemessa(TelaCadastroRemessa view) {
        this.view = view;

        // Configura btn para cadastrar funcionario
        view.getBtnCadastrar().setOnAction(e -> cadastrarRemessa());

    }

    private void cadastrarRemessa() {
        // Obtenha os dados inseridos nos campos da tela
        // funcionario
        String fornecedorId = view.getTxtFornecedor().getText();
        String envio = view.getTxtDataEnvio().getText();
        String recebimento = view.getTxtDataRecebimento().getText();
        String formato = "dd/MM/yyyy";

        if (fornecedorId.isEmpty() || envio.isEmpty() || recebimento.isEmpty())  {
            // Se algum campo estiver em branco, exiba uma mensagem de erro.
            view.getResposta().setText("Por favor, preencha todos os campos.");
            view.getResposta().setStyle("-fx-text-fill: red;");
            return;
        }
            if (Data.validarData(recebimento, formato) && Data.validarData(envio, formato)) {
                int id = Integer.parseInt(fornecedorId);
                if(FornecedorDAO.buscarFornecedorPorId(id)==null){
                    view.getResposta().setText("Fornecedor inválido");
                    view.getResposta().setStyle("-fx-text-fill: red;");
                    return;
                }

                Remessa remessa = new Remessa(
                        null,
                        id,
                        envio ,
                        recebimento
                );
              if(RemessaDAO.adicionarRemessa(remessa)){
                  view.getResposta().setText("Remessa adicionada com sucesso!");
                  view.getResposta().setStyle("-fx-text-fill: green;");
                    

              } else {
                  view.getResposta().setText("Erro ao cadastrar remessa");
                  view.getResposta().setStyle("-fx-text-fill: red;");
              }
            } else {
                view.getResposta().setText("Por favor, informe uma data válida");
                view.getResposta().setStyle("-fx-text-fill: red;");
            }
        }

}
