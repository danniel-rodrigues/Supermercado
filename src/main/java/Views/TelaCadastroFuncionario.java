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


public class TelaCadastroFuncionario{
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
        TextField nome = new TextField();
        nome.setPrefWidth(250);
        // cpf
        Label lblCPF = new Label("CPF: ");
        TextField cpf = new TextField();
        nome.setPrefWidth(250);
        hbox1.getChildren().addAll(lblNome,nome, lblCPF, cpf);
        hbox1.setMinHeight(20);
        hbox1.setAlignment(Pos.CENTER_LEFT);


        //h2
        // data nascimeneto
        Label lblData = new Label("DATA DE NASCIMENTO: ");
        TextField dataNascimento = new TextField();
        dataNascimento.setPrefWidth(100);
        // email
        Label lblEmail = new Label("EMAIL: ");
        TextField email = new TextField();
        email.setPrefWidth(200);
        hbox2.getChildren().addAll(lblData, dataNascimento, lblEmail, email);
        hbox2.setMinHeight(20);
        hbox2.setAlignment(Pos.CENTER_LEFT);

        //h3
        // telefone
        Label lblTelefone = new Label("TELEFONE: ");
        TextField telefone = new TextField();
        telefone.setPrefWidth(150);
        // sexo
        Label lblSexo = new Label("SEXO: ");
        ComboBox<String> sexo = new ComboBox<>();
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
        ComboBox<String> cargo = new ComboBox<>();
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
        ComboBox<String> status = new ComboBox<>();
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
        TextField rua = new TextField();
        rua.setPrefWidth(200);
        // bairro
        Label lblBairro = new Label("BAIRRO: ");
        TextField bairro = new TextField();
        bairro.setPrefWidth(200);
        hbox5.getChildren().addAll(lblRua, rua, lblBairro, bairro);
        hbox5.setAlignment(Pos.CENTER_LEFT);

        // h6
        // numero
        Label lblNumero = new Label("NUMERO: ");
        TextField numero = new TextField();
        numero.setPrefWidth(100);
        // municipio
        Label lblMunicipio = new Label("MUNICIPIO: ");
        TextField municipio = new TextField();
        municipio.setPrefWidth(200);
        hbox6.getChildren().addAll(lblNumero, numero, lblMunicipio, municipio);
        hbox6.setAlignment(Pos.CENTER_LEFT);

        // h7
        // estado
        Label lblEstado = new Label("ESTADO: ");
        ComboBox<String> estado = new ComboBox<>();
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
        TextField cep = new TextField();
        cep.setPrefWidth(200);
        hbox7.getChildren().addAll(lblEstado, estado, lblCEP, cep);
        hbox7.setAlignment(Pos.CENTER_LEFT);


        // Adicionar botoes
        Button btnCadastrar = new Button("CADASTRAR");



        // Adicionando ícones aos botões
        Image plusICon = new Image("assets/images/icons/plus.png");
        ImageView plusIconView = new ImageView(plusICon);
        plusIconView.setFitWidth(20);
        plusIconView.setFitHeight(20);
        btnCadastrar.setGraphic(plusIconView);
        // Definindo o background dos botões
        btnCadastrar.setStyle("-fx-background-color: #F79516;");


        Button btnVoltar = new Button("VOLTAR");

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

        Label resposta = new Label("");

        btnCadastrar.setOnAction(e -> {
            resposta.setText("Existem Campos invalidos/Brancos!".toUpperCase());
            resposta.setStyle("-fx-text-fill: purple;");
        });

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
}