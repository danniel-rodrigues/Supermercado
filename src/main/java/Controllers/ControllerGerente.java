package Controllers;

import Auxiliar.CPF;
import Auxiliar.Data;
import DAO.FuncionarioDAO;
import DAO.EnderecoDAO;
import Models.Endereco;

import Models.Funcionario;
import Views.TelaAlterarFuncionario;
import Views.TelaBuscarFuncionario;
import Views.TelaCadastroFuncionario;
import Views.TelaDemitirFuncionario;

import java.util.Objects;

public class ControllerGerente {
    private TelaCadastroFuncionario view;
    private TelaBuscarFuncionario viewB;
    private TelaAlterarFuncionario viewC;
    private TelaDemitirFuncionario viewD;

    public ControllerGerente(TelaCadastroFuncionario view) {
        this.view = view;

        // Configura btn para cadastrar funcionario
        view.getBtnCadastrar().setOnAction(e -> cadastrarFuncionario());

    }

    public ControllerGerente(TelaBuscarFuncionario view) {
        this.viewB = view;
        // buscar funcionario na Tabela
        view.getBtnBuscar().setOnAction(e -> alterarFuncionario());
    }

    public ControllerGerente(TelaAlterarFuncionario view) {
        viewC = view;

        view.getBtnCadastrar().setOnAction(e -> AlterarDados());
    }

    public ControllerGerente(TelaDemitirFuncionario view){
        viewD = view;

        viewD.getBtnBuscar().setOnAction(e -> demitirFuncionario());
    }

    // Método para cadastrar um novo funcionário
    private void cadastrarFuncionario() {
        // Obtenha os dados inseridos nos campos da tela
        // funcionario
        String nome = view.getNomeField().getText();
        String cpf = view.getCpfField().getText();
        String email = view.getEmailField().getText();
        String telefone = view.getTelefoneField().getText();
        String sexo = view.getSexoComboBox().getValue();
        String status = view.getStatusComboBox().getValue();
        String cargo = view.getCargoComboBox().getValue();
        String nascimento = view.getDataNascimentoField().getText();

        // endereco
        String rua = view.getRuaField().getText();
        String bairro = view.getBairroField().getText();
        String cidade = view.getMunicipioField().getText();
        String estado = view.getEstadoComboBox().getValue();
        String cep = view.getCepField().getText();
        String numero = view.getNumeroField().getText();

        String formato = "dd/MM/yyyy";

        // Verifique se algum campo está em branco
        if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || telefone.isEmpty() || Objects.equals(sexo, "Selecione") ||
                sexo == null || status == null || status.equals("Selecione") ||
                Objects.equals(estado, "Selecione") || Objects.equals(cargo, "Selecione") || cargo == null ||
                rua.isEmpty() || bairro.isEmpty() || cidade.isEmpty() || estado == null || cep.isEmpty()) {
            // Se algum campo estiver em branco, exiba uma mensagem de erro
            view.getRespostaLabel().setText("Por favor, preencha todos os campos.");
            view.getRespostaLabel().setStyle("-fx-text-fill: red;");
        } else {
            if (CPF.validarCPF(cpf) || Data.validarData(nascimento, formato)) {
                // Crie um novo objeto Funcionario com os dados fornecidos
                Endereco endereco = new Endereco(
                        rua,
                        bairro,
                        cidade,
                        estado,
                        cep,
                        numero,
                        cpf
                );
                Funcionario funcionario = new Funcionario(
                        nome,
                        cpf,
                        Data.converterStringParaDate(nascimento, formato),
                        email,
                        cep,
                        sexo,
                        "joao",
                        "senha123",
                        status,
                        endereco,
                        cargo
                );

                adicionaFuncionario(funcionario, endereco);
            }
        }


    }

    public void alterarFuncionario() {
        String cpf = viewB.getCpf().getText();

        if (CPF.validarCPF(cpf) || !cpf.isEmpty()) {
            Funcionario funcionario = FuncionarioDAO.buscarFuncionarioPorCPF(cpf);
            if (funcionario == null) {
                viewB.getLbAviso().setText("CPF não encontrado".toUpperCase());
                viewB.getLbAviso().setStyle("-fx-text-fill: red;");
            } else {
                TelaAlterarFuncionario telaAlterarFuncionario = new TelaAlterarFuncionario();
                telaAlterarFuncionario.show(viewB.getSt(), funcionario);
            }
        } else {
            viewB.getLbAviso().setText("CPF Inválido".toUpperCase());
            viewB.getLbAviso().setStyle("-fx-text-fill: red;");
        }

    }

    public void AlterarDados() {
        // Obtenha os dados inseridos nos campos da tela
        // funcionario
        String nome = viewC.getNomeField().getText();
        String cpf = viewC.getCpfField().getText();
        String email = viewC.getEmailField().getText();
        String telefone = viewC.getTelefoneField().getText();
        String sexo = viewC.getSexoComboBox().getValue();
        String status = viewC.getStatusComboBox().getValue();
        String cargo = viewC.getCargoComboBox().getValue();
        String nascimento = viewC.getDataNascimentoField().getText();

        // endereco
        String rua = viewC.getRuaField().getText();
        String bairro = viewC.getBairroField().getText();
        String cidade = viewC.getMunicipioField().getText();
        String estado = viewC.getEstadoComboBox().getValue();
        String cep = viewC.getCepField().getText();
        String numero = viewC.getNumeroField().getText();

        String formato = "dd/MM/yyyy";

        // Verifique se algum campo está em branco
        if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty() || telefone.isEmpty() || Objects.equals(sexo, "Selecione") ||
                sexo == null || status == null || status.equals("Selecione") ||
                Objects.equals(estado, "Selecione") || Objects.equals(cargo, "Selecione") || cargo == null ||
                rua.isEmpty() || bairro.isEmpty() || cidade.isEmpty() || estado == null || cep.isEmpty()) {
            // Se algum campo estiver em branco, exiba uma mensagem de erro
            viewC.getRespostaLabel().setText("Por favor, preencha todos os campos.");
            viewC.getRespostaLabel().setStyle("-fx-text-fill: red;");
        } else {
            if (CPF.validarCPF(cpf) || Data.validarData(nascimento, formato)) {
                // Crie um novo objeto Funcionario com os dados fornecidos
                Endereco endereco = new Endereco(
                        rua,
                        bairro,
                        cidade,
                        estado,
                        cep,
                        numero,
                        cpf
                );
                Funcionario funcionario = new Funcionario(
                        nome,
                        cpf,
                        Data.converterStringParaDate(nascimento, formato),
                        email,
                        cep,
                        sexo,
                        "joao",
                        "senha123",
                        status,
                        endereco,
                        cargo
                );

                if (FuncionarioDAO.atualizarFuncionario(funcionario)) {
                    EnderecoDAO.atualizarEndereco(endereco);

                    viewC.getRespostaLabel().setText("Funcionário alterado com sucesso!".toUpperCase());
                    viewC.getRespostaLabel().setStyle("-fx-text-fill: green;");
                    // Limpe os campos de entrada após o cadastro
                    viewC.limparCampos();
                } else {
                    viewC.getRespostaLabel().setText("Erro na inserção!".toUpperCase());
                    viewC.getRespostaLabel().setStyle("-fx-text-fill: red;");
                }
            }
        }
    }

    public void adicionaFuncionario(Funcionario funcionario, Endereco endereco){
        // Adiciona um funcionario ao banco e seu respectivo endereco
        if (EnderecoDAO.adicionarEndereco(endereco)) {
            FuncionarioDAO.adicionarFuncionario(funcionario);

            view.getRespostaLabel().setText("Funcionário cadastrado com sucesso!");
            view.getRespostaLabel().setStyle("-fx-text-fill: green;");
            // Limpe os campos de entrada após o cadastro
            view.limparCampos();
        } else {
            view.getRespostaLabel().setText("Erro na inserção!");
            view.getRespostaLabel().setStyle("-fx-text-fill: red;");
        }
    }

    public void demitirFuncionario(){
        String cpf = viewD.getCPF();

        if(FuncionarioDAO.demitirFuncionario(cpf)){
            viewD.getRespostaLabel().setText("Funcionário demitido com sucesso!");
            viewD.getRespostaLabel().setStyle("-fx-text-fill: green;");
            // Limpe os campos de entrada após o cadastro
            viewD.limparCampos();
        }else{
            viewD.getRespostaLabel().setText("Funcionário não encontrado!");
            viewD.getRespostaLabel().setStyle("-fx-text-fill: red;");
        }
    }

}
