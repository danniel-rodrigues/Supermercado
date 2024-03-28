package Views;

import Models.OperadorCaixa;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
// Adicionar imagem
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

import Controllers.ControllerGerente;

public class TelaAlteraOperadorCaixa {
    private TextField nome;
    private TextField cpf;
    private TextField dataNascimento;
    private TextField email;
    private TextField telefone;
    private ComboBox<String> sexo;
    private ComboBox<String> cargo;
    private ComboBox<String> status;
    private TextField rua;
    private TextField bairro;
    private TextField numero;
    private TextField municipio;
    private ComboBox<String> estado;
    private TextField cep;
    private Button btnCadastrar;
    private Button btnVoltar;
    private Label resposta;

    private ControllerGerente controllerGerente;

    public void show(Stage stage, OperadorCaixa operadorCaixa) {


        HBox hbox1 = new HBox(10);
        HBox hbox2 = new HBox(10);
        HBox hbox3 = new HBox(10);
        HBox hbox4 = new HBox(10);
        HBox hbox5 = new HBox(10);
        HBox hbox6 = new HBox(10);
        HBox hbox7 = new HBox(10);
        // h1
        // nome
        Label lblNome = new Label("NOME:");
        nome = new TextField();
        nome.setText(operadorCaixa.getNome());
        nome.setMaxWidth(250);

        HBox.setHgrow(lblNome, Priority.NEVER);
        HBox.setHgrow(nome, Priority.ALWAYS);

        // cpf
        Label lblCPF = new Label("CPF:");
        cpf = new TextField();
        cpf.setText(operadorCaixa.getCpf());
        cpf.setMaxWidth(250);
        lblCPF.setPadding(new Insets(0, 0, 0, 20));

        HBox.setHgrow(lblCPF, Priority.NEVER);
        HBox.setHgrow(cpf, Priority.ALWAYS);

        hbox1.getChildren().addAll(lblNome, nome, lblCPF, cpf);
        hbox1.setMinHeight(20);
        hbox1.setAlignment(Pos.CENTER_LEFT);


        //h2
        // data nascimento
        Label lblData = new Label("DATA DE NASCIMENTO:");
        dataNascimento = new TextField();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = sdf.format(operadorCaixa.getDataNasc());
        dataNascimento.setText(dataFormatada);
        dataNascimento.setMaxWidth(100);

        HBox.setHgrow(lblData, Priority.NEVER);
        HBox.setHgrow(dataNascimento, Priority.ALWAYS);

        // email
        Label lblEmail = new Label("EMAIL:");
        email = new TextField();
        email.setText(operadorCaixa.getEmail());
        email.setMaxWidth(200);
        lblEmail.setPadding(new Insets(0, 0, 0, 50));

        HBox.setHgrow(lblEmail, Priority.NEVER);
        HBox.setHgrow(email, Priority.ALWAYS);

        hbox2.getChildren().addAll(lblData, dataNascimento, lblEmail, email);
        hbox2.setMinHeight(20);
        hbox2.setAlignment(Pos.CENTER_LEFT);

        //h3
        // telefone
        Label lblTelefone = new Label("TELEFONE:");
        telefone = new TextField();
        telefone.setText(operadorCaixa.getTelefone());
        telefone.setMaxWidth(150);

        HBox.setHgrow(lblTelefone, Priority.NEVER);
        HBox.setHgrow(telefone, Priority.ALWAYS);

        // sexo
        Label lblSexo = new Label("SEXO:");
        sexo = new ComboBox<>();
        sexo.setMaxWidth(200);
        lblSexo.setPadding(new Insets(0, 0, 0, 70));
        sexo.getItems().addAll("Masculino", "Feminino", "Outros");
        // Aplicando estilos CSS personalizados
        sexo.setStyle(
                "-fx-background-color: white;" + // Background branco
                        "-fx-border-color: #a9a9a9;" +    // Cor da borda igual ao TextField
                        "-fx-border-radius: 5;"           // Arredondamento da borda
        );
        // Configurando uma opção padrão
        sexo.setValue(operadorCaixa.getSexo());

        HBox.setHgrow(lblSexo, Priority.NEVER);
        HBox.setHgrow(sexo, Priority.ALWAYS);

        hbox3.getChildren().addAll(lblTelefone, telefone, lblSexo, sexo);
        hbox3.setAlignment(Pos.CENTER_LEFT);

        // h4
        // cargo
        Label lblCargo = new Label("CARGO:");
        cargo = new ComboBox<>();
        cargo.setMaxWidth(200);
        cargo.getItems().addAll("Gerente", "OperadorCaixa");
        // Aplicando estilos CSS personalizados
        cargo.setStyle(
                "-fx-background-color: white;" + // Background branco
                        "-fx-border-color: #a9a9a9;" +    // Cor da borda igual ao TextField
                        "-fx-border-radius: 5;"           // Arredondamento da borda
        );
        // Configurando uma opção padrão
        cargo.setValue("OperadorCaixa");

        HBox.setHgrow(lblCargo, Priority.NEVER);
        HBox.setHgrow(cargo, Priority.ALWAYS);

        // status
        Label lblStatus = new Label("STATUS:");
        status = new ComboBox<>();
        status.setMaxWidth(200);
        lblStatus.setPadding(new Insets(0, 0, 0, 35));
        status.getItems().addAll("Ativo", "Inativo", "Desligado");
        // Aplicando estilos CSS personalizados
        status.setStyle(
                "-fx-background-color: white;" + // Background branco
                        "-fx-border-color: #a9a9a9;" +    // Cor da borda igual ao TextField
                        "-fx-border-radius: 5;"           // Arredondamento da borda
        );
        // Configurando uma opção padrão
        status.setValue(operadorCaixa.getStatus());

        HBox.setHgrow(lblStatus, Priority.NEVER);
        HBox.setHgrow(status, Priority.ALWAYS);

        hbox4.getChildren().addAll(lblCargo, cargo, lblStatus, status);
        hbox4.setAlignment(Pos.CENTER_LEFT);

        // h5
        // rua
        Label lblRua = new Label("RUA:");
        rua = new TextField();
        rua.setText(operadorCaixa.getEndereco().getRua());
        rua.setMaxWidth(200);

        HBox.setHgrow(lblRua, Priority.NEVER);
        HBox.setHgrow(rua, Priority.ALWAYS);

        // bairro
        Label lblBairro = new Label("BAIRRO:");
        bairro = new TextField();
        bairro.setText(operadorCaixa.getEndereco().getBairro());
        bairro.setMaxWidth(200);
        lblBairro.setPadding(new Insets(0, 0, 0, 50));

        HBox.setHgrow(lblBairro, Priority.NEVER);
        HBox.setHgrow(bairro, Priority.ALWAYS);

        hbox5.getChildren().addAll(lblRua, rua, lblBairro, bairro);
        hbox5.setAlignment(Pos.CENTER_LEFT);

        // h6
        // numero
        Label lblNumero = new Label("NÚMERO:");
        numero = new TextField();
        numero.setText(operadorCaixa.getEndereco().getNumero());
        numero.setMaxWidth(100);

        HBox.setHgrow(lblNumero, Priority.NEVER);
        HBox.setHgrow(numero, Priority.ALWAYS);

        // municipio
        Label lblMunicipio = new Label("MUNICÍPIO:");
        municipio = new TextField();
        municipio.setText(operadorCaixa.getEndereco().getCidade());
        municipio.setMaxWidth(200);
        lblMunicipio.setPadding(new Insets(0, 0, 0, 125));

        HBox.setHgrow(lblMunicipio, Priority.NEVER);
        HBox.setHgrow(municipio, Priority.ALWAYS);

        hbox6.getChildren().addAll(lblNumero, numero, lblMunicipio, municipio);
        hbox6.setAlignment(Pos.CENTER_LEFT);

        // h7
        // estado
        Label lblEstado = new Label("ESTADO:");
        estado = new ComboBox<>();
        estado.setMaxWidth(200);
        estado.getItems().addAll("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO");
        // Aplicando estilos CSS personalizados
        estado.setStyle(
                "-fx-background-color: white;" + // Background branco
                        "-fx-border-color: #a9a9a9;" +    // Cor da borda igual ao TextField
                        "-fx-border-radius: 5;"           // Arredondamento da borda
        );
        // Configurando uma opção padrão
        estado.setValue(operadorCaixa.getEndereco().getEstado());

        HBox.setHgrow(lblEstado, Priority.NEVER);
        HBox.setHgrow(estado, Priority.ALWAYS);

        // cep
        Label lblCEP = new Label("CEP:");
        cep = new TextField();
        cep.setText(operadorCaixa.getEndereco().getCep());
        cep.setMaxWidth(200);
        lblCEP.setPadding(new Insets(0, 0, 0, 30));

        HBox.setHgrow(lblCEP, Priority.NEVER);
        HBox.setHgrow(cep, Priority.ALWAYS);

        hbox7.getChildren().addAll(lblEstado, estado, lblCEP, cep);
        hbox7.setPadding(new Insets(0, 0, 50, 0));
        hbox7.setAlignment(Pos.CENTER_LEFT);


        // Adicionar botoes
        // Adicionar o botão btnCadastrar
        btnCadastrar = new Button("ALTERAR");

// Adicionando ícones aos botões
        Image plusICon = new Image("assets/images/icons/plus.png");
        ImageView plusIconView = new ImageView(plusICon);
        plusIconView.setFitWidth(20);
        plusIconView.setFitHeight(20);
        btnCadastrar.setGraphic(plusIconView);
// Definindo o background dos botões
        btnCadastrar.setStyle("-fx-background-color: #F79516;");

// Configurando a ação do botão
        controllerGerente = new ControllerGerente(this);

        btnVoltar = new Button("VOLTAR");

        // Adicionando ícones aos botões
        Image arrowIcon = new Image("assets/images/icons/arrow.png");
        ImageView arrowIconView = new ImageView(arrowIcon);
        arrowIconView.setFitWidth(20);
        arrowIconView.setFitHeight(20);
        btnVoltar.setGraphic(arrowIconView);
        // Definindo o background dos botões
        btnVoltar.setStyle("-fx-background-color: #F79516;");

        btnVoltar.setOnAction(e -> {
            TelaFuncionarios telaFuncionarios = new TelaFuncionarios();
            telaFuncionarios.show(stage);
        });


        btnCadastrar.setMinWidth(250);
        btnCadastrar.setMinHeight(50);
        btnVoltar.setMinWidth(250);
        btnVoltar.setMinHeight(50);

        HBox hbox8 = new HBox(10);
        hbox8.getChildren().addAll(btnCadastrar, btnVoltar);
        hbox8.setMinHeight(50);
        hbox8.setAlignment(Pos.CENTER);

        resposta = new Label("");


        VBox vbox = new VBox();

        // padding
        Insets padding = new Insets(20);
        vbox.setPadding(padding);

        vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5, hbox6, hbox7, hbox8, resposta);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 500);
        stage.setTitle("Supermercado - Alterar dados de Funcionários");
        stage.setScene(scene);
        stage.show();
    }

    // Métodos para recuperar os elementos da interface

    public TextField getNomeField() {
        return nome;
    }

    public TextField getCpfField() {
        return cpf;
    }

    public TextField getDataNascimentoField() {
        return dataNascimento;
    }

    public TextField getEmailField() {
        return email;
    }

    public TextField getTelefoneField() {
        return telefone;
    }

    public ComboBox<String> getSexoComboBox() {
        return sexo;
    }

    public ComboBox<String> getCargoComboBox() {
        return cargo;
    }

    public ComboBox<String> getStatusComboBox() {
        return status;
    }

    public TextField getRuaField() {
        return rua;
    }

    public TextField getBairroField() {
        return bairro;
    }

    public TextField getNumeroField() {
        return numero;
    }

    public TextField getMunicipioField() {
        return municipio;
    }

    public ComboBox<String> getEstadoComboBox() {
        return estado;
    }

    public TextField getCepField() {
        return cep;
    }

    public Button getBtnCadastrar() {
        return this.btnCadastrar;
    }

    public Label getRespostaLabel() {
        return resposta;
    }

    public void limparCampos() {
        nome.clear();
        cpf.clear();
        dataNascimento.clear();
        email.clear();
        telefone.clear();
        sexo.getSelectionModel().clearSelection();
        cargo.getSelectionModel().clearSelection();
        status.getSelectionModel().clearSelection();
        rua.clear();
        bairro.clear();
        numero.clear();
        municipio.clear();
        estado.getSelectionModel().clearSelection();
        cep.clear();
    }
}
