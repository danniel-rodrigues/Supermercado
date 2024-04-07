package Controllers;

import Auxiliar.CPF;
import Auxiliar.Data;
import DAO.RemessaDAO;
import Models.Endereco;
import Models.Funcionario;
import Models.Remessa;
import Views.TelaCadastroFuncionario;
import Views.TelaCadastroRemessa;
import Views.TelaDemitirFuncionario;

import java.util.Objects;

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
        String nome = view.getTxtFornecedor().getText();
        String envio = view.getTxtDataEnvio().getText();
        String recebimento = view.getTxtDataRecebimento().getText();
        String status = view.getTxtStatus().getText();
        String formato = "dd/MM/yyyy";

        if (nome.isEmpty() || envio.isEmpty() || recebimento.isEmpty() || status.isEmpty()  ||
                nome == null || envio == null || recebimento == null || status == null)  {
            // Se algum campo estiver em branco, exiba uma mensagem de erro
            view.getResposta().setText("Por favor, preencha todos os campos.");
            view.getResposta().setStyle("-fx-text-fill: red;");
        } else {
            if (Data.validarData(recebimento, formato) && Data.validarData(envio, formato)) {
                // Crie um novo objeto Funcionario com os dados fornecidos
                int id = Integer.valueOf(nome);
                Remessa remessa = new Remessa(
                        null,
                        id,
                        envio ,
                        recebimento,
                        status
                );
              if(RemessaDAO.adicionarRemessa(remessa)){
                  view.getResposta().setText("Remessa adicionada com sucesso!");

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
}
