package Views;

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

import Controllers.ControllerGerente;


public class TelaCadastroFuncionario{

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
    private ControllerGerente controller;

    public void show(Stage stage) {



        HBox hbox1 = new HBox(10);
        HBox hbox2 = new HBox(10);
        HBox hbox3 = new HBox(10);
        HBox hbox4 = new HBox(10);
        HBox hbox5 = new HBox(10);
        HBox hbox6 = new HBox(10);
        HBox hbox7 = new HBox(10);
        // h1
        // nome
        Label lblNome = new Label("NOME: ");
        nome = new TextField();
        nome.setPrefWidth(250);
        // cpf
        Label lblCPF = new Label("CPF: ");
         cpf = new TextField();
        nome.setPrefWidth(250);
        hbox1.getChildren().addAll(lblNome,nome, lblCPF, cpf);
        hbox1.setMinHeight(20);
        hbox1.setAlignment(Pos.CENTER_LEFT);


        //h2
        // data nascimeneto
        Label lblData = new Label("DATA DE NASCIMENTO: ");
        dataNascimento = new TextField();
        dataNascimento.setPrefWidth(100);
        // email
        Label lblEmail = new Label("EMAIL: ");
         email = new TextField();
        email.setPrefWidth(200);
        hbox2.getChildren().addAll(lblData, dataNascimento, lblEmail, email);
        hbox2.setMinHeight(20);
        hbox2.setAlignment(Pos.CENTER_LEFT);

        //h3
        // telefone
        Label lblTelefone = new Label("TELEFONE: ");
        telefone = new TextField();
        telefone.setPrefWidth(150);
        // sexo
        Label lblSexo = new Label("SEXO: ");
        sexo = new ComboBox<String>();
        sexo.setPrefWidth(200);
        sexo.getItems().addAll("Masculino", "Feminino", "Outros");
        // Aplicando estilos CSS personalizados
        sexo.setStyle(
                "-fx-background-color: white;" + // Background branco
                        "-fx-border-color: #a9a9a9;" +    // Cor da borda igual ao TextField
                        "-fx-border-radius: 5;"           // Arredondamento da borda
        );
        // Configurando uma opção padrão
        sexo.setValue("Opções");
        hbox3.getChildren().addAll(lblTelefone, telefone, lblSexo, sexo);
        hbox3.setAlignment(Pos.CENTER_LEFT);

        // h4
        // cargo
        Label lblCargo = new Label("CARGO: ");
        cargo = new ComboBox<String>();
        cargo.setPrefWidth(200);
        cargo.getItems().addAll("Gerente", "OperadorCaixa");
        // Aplicando estilos CSS personalizados
        cargo.setStyle(
                "-fx-background-color: white;" + // Background branco
                        "-fx-border-color: #a9a9a9;" +    // Cor da borda igual ao TextField
                        "-fx-border-radius: 5;"           // Arredondamento da borda
        );
        // Configurando uma opção padrão
        cargo.setValue("Opções");
        // status
        Label lblStatus = new Label("STATUS: ");
         status = new ComboBox<String>();
        status.setPrefWidth(200);
        status.getItems().addAll("Ativo", "Inativo", "Desligado");
        // Aplicando estilos CSS personalizados
        status.setStyle(
                "-fx-background-color: white;" + // Background branco
                        "-fx-border-color: #a9a9a9;" +    // Cor da borda igual ao TextField
                        "-fx-border-radius: 5;"           // Arredondamento da borda
        );
        // Configurando uma opção padrão
        status.setValue("Opções");
        hbox4.getChildren().addAll(lblCargo, cargo, lblStatus, status);
        hbox4.setAlignment(Pos.CENTER_LEFT);

        // h5
        // rua
        Label lblRua = new Label("RUA: ");
         rua = new TextField();
        rua.setPrefWidth(200);
        // bairro
        Label lblBairro = new Label("BAIRRO: ");
         bairro = new TextField();
        bairro.setPrefWidth(200);
        hbox5.getChildren().addAll(lblRua, rua, lblBairro, bairro);
        hbox5.setAlignment(Pos.CENTER_LEFT);

        // h6
        // numero
        Label lblNumero = new Label("NUMERO: ");
         numero = new TextField();
        numero.setPrefWidth(100);
        // municipio
        Label lblMunicipio = new Label("MUNICIPIO: ");
         municipio = new TextField();
        municipio.setPrefWidth(200);
        hbox6.getChildren().addAll(lblNumero, numero, lblMunicipio, municipio);
        hbox6.setAlignment(Pos.CENTER_LEFT);

        // h7
        // estado
        Label lblEstado = new Label("ESTADO: ");
         estado = new ComboBox<String>();
        estado.setPrefWidth(200);
        estado.getItems().addAll("AC", "AL", "AP", "AM", "BA", "CE","DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA","PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO");
        // Aplicando estilos CSS personalizados
        estado.setStyle(
                "-fx-background-color: white;" + // Background branco
                        "-fx-border-color: #a9a9a9;" +    // Cor da borda igual ao TextField
                        "-fx-border-radius: 5;"           // Arredondamento da borda
        );
        // Configurando uma opção padrão
        estado.setValue("Opções");
        // cep
        Label lblCEP = new Label("CEP: ");
         cep = new TextField();
        cep.setPrefWidth(200);
        hbox7.getChildren().addAll(lblEstado, estado, lblCEP, cep);
        hbox7.setAlignment(Pos.CENTER_LEFT);


        // Adicionar botoes
        // Adicionar o botão btnCadastrar
        btnCadastrar = new Button("CADASTRAR");

// Adicionando ícones aos botões
        Image plusICon = new Image("assets/images/icons/plus.png");
        ImageView plusIconView = new ImageView(plusICon);
        plusIconView.setFitWidth(20);
        plusIconView.setFitHeight(20);
        btnCadastrar.setGraphic(plusIconView);
// Definindo o background dos botões
        btnCadastrar.setStyle("-fx-background-color: #F79516;");

// Configurando a ação do botão
        btnCadastrar.setOnAction(e -> {
            // Coloque aqui o código para lidar com o evento de clique no botão cadastrar
        });
        controller = new ControllerGerente(this);



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
        stage.setTitle("SuperMercado - Cadastro de Funcionários");
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