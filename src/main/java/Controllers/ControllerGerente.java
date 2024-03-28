package Controllers;

import Models.Endereco;


import Models.Funcionario;
import Views.TelaCadastroFuncionario;

import java.util.Date;

public class ControllerGerente {
    private TelaCadastroFuncionario view;

    // Construtor que recebe a visualização (View)
    // Construtor que recebe a visualização (View)
    public ControllerGerente(TelaCadastroFuncionario view) {
        this.view = view;

        // Configura os botões para interagir com a lógica de controle
        view.getBtnCadastrar().setOnAction(e -> cadastrarFuncionario());
        // Adicione os outros eventos de botão aqui conforme necessário
    }

    // Método para cadastrar um novo funcionário
    private void cadastrarFuncionario() {
        // Obtenha os dados inseridos nos campos da tela
        // funcionario
        String nome = view.getNomeField().getText();
        String cpf = view.getCpfField().getText();
        String email = view.getBtnCadastrar().getText();
        String telefone = view.getTelefoneField().getText();
        String sexo = view.getSexoComboBox().getValue();
        String status = view.getStatusComboBox().getValue();

        // endereco
        String rua = view.getRuaField().getText();
        String bairro = view.getBairroField().getText();
        String cidade = view.getMunicipioField().getText();
        String estado = view.getEstadoComboBox().getValue();
        String cep = view.getCepField().getText();

        // Verifique se algum campo está em branco
        if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || telefone.isEmpty() || sexo == "Opções" ||
                sexo == null || status == null || status == "Opções" || estado == "Opções" ||
                rua.isEmpty() || bairro.isEmpty() || cidade.isEmpty() || estado == null || cep.isEmpty()) {
            // Se algum campo estiver em branco, exiba uma mensagem de erro
            view.getRespostaLabel().setText("Por favor, preencha todos os campos.");
            view.getRespostaLabel().setStyle("-fx-text-fill: red;");
        }
        else {
            // Crie um novo objeto Funcionario com os dados fornecidos
            Endereco endereco = new Endereco(
                    "Rua A",
                    "Bairro A",
                    "Cidade A",
                    "Estado A",
                    "CEP A",
                    123
            );
            Funcionario funcionario = new Funcionario(
                    "João",
                    "123.456.789-00",
                    new Date(),
                    "joao@example.com",
                    "1234-5678",
                    "Masculino",
                    "joao",
                    "senha123",
                    "Ativo",
                    endereco
            );
            // Aqui você pode chamar métodos para adicionar o novo funcionário ao banco de dados, por exemplo

            // Exiba uma mensagem de sucesso ou atualize a visualização conforme necessário
            view.getRespostaLabel().setText("Funcionário cadastrado com sucesso!");
            view.getRespostaLabel().setStyle("-fx-text-fill: green;");
            // Limpe os campos de entrada após o cadastro
            view.limparCampos();
        }


    }

}
