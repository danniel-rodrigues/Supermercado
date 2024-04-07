package Views;

import Controllers.ControllerFornecedor;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
// Adicionar imagem
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TelaCadastroFornecedor {
    private TextField txtNome;
    private TextField txtCNPJ;
    private TextField txtEmail;
    private TextField txtTelefone;
    private Button btnCadastrar;
    private Label resposta;
    private ControllerFornecedor controllerFornecedor;

    public void show(Stage stage) {

        HBox hbox1 = new HBox(10);
        HBox hbox2 = new HBox(10);
        HBox hbox3 = new HBox(10);
        HBox hbox4 = new HBox(10);
        HBox hbox5 = new HBox(10);

        // H1
        // Nome
        Label lblNome = new Label("NOME:");
        txtNome = new TextField();
        txtNome.setMaxWidth(250);
        hbox1.getChildren().addAll(lblNome, txtNome);
        hbox1.setMinHeight(20);
        hbox1.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblNome, Priority.NEVER);
        HBox.setHgrow(txtNome, Priority.ALWAYS);

        // H2
        // cnpj
        Label lblCNPJ = new Label("CNPJ:");
        txtCNPJ = new TextField();
        txtCNPJ.setMaxWidth(250);
        txtCNPJ.setPromptText("Apenas números");
        hbox2.getChildren().addAll(lblCNPJ, txtCNPJ);
        hbox2.setMinHeight(20);
        hbox2.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblCNPJ, Priority.NEVER);
        HBox.setHgrow(txtCNPJ, Priority.ALWAYS);

        // H3
        // email
        Label lblEmail = new Label("E-MAIL:");
        txtEmail = new TextField();
        txtEmail.setMaxWidth(250);
        hbox3.getChildren().addAll(lblEmail, txtEmail);
        hbox3.setMinHeight(20);
        hbox3.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblEmail, Priority.NEVER);
        HBox.setHgrow(txtEmail, Priority.ALWAYS);

        // H4
        // telefone
        Label lblTelefone = new Label("TELEFONE:");
        txtTelefone = new TextField();
        txtTelefone.setMaxWidth(250);
        hbox4.getChildren().addAll(lblTelefone, txtTelefone);
        hbox4.setMinHeight(20);
        hbox4.setPadding(new Insets(0, 0, 50,0));
        hbox4.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblTelefone, Priority.NEVER);
        HBox.setHgrow(txtTelefone, Priority.ALWAYS);


        // Adicionando botões
        btnCadastrar = new Button("CADASTRAR");
        Button btnVoltar = new Button("VOLTAR");

        controllerFornecedor = new ControllerFornecedor(this);

        // Adicionando ícone e cor de fundo ao botão Cadastrar
        Image plusIcon = new Image("assets/images/icons/plus.png");
        ImageView plusIconView = new ImageView(plusIcon);
        plusIconView.setFitWidth(20);
        plusIconView.setFitHeight(20);
        btnCadastrar.setGraphic(plusIconView);
        btnCadastrar.setStyle("-fx-background-color: #F79516;");

        // Adicionando ícone e cor de fundo ao botão Voltar
        Image arrowIcon = new Image("assets/images/icons/arrow.png");
        ImageView arrowIconView = new ImageView(arrowIcon);
        arrowIconView.setFitWidth(20);
        arrowIconView.setFitHeight(20);
        btnVoltar.setGraphic(arrowIconView);
        btnVoltar.setStyle("-fx-background-color: #F79516;");

        // Ajustando tamanho dos botões
        btnCadastrar.setMinWidth(250);
        btnCadastrar.setMinHeight(50);
        btnVoltar.setMinWidth(250);
        btnVoltar.setMinHeight(50);

        // H5
        hbox5.getChildren().addAll(btnCadastrar, btnVoltar);
        hbox5.setMinHeight(50);
        hbox5.setAlignment(Pos.CENTER);

        resposta = new Label("");

        btnVoltar.setOnAction(e -> {
            TelaFornecedores telaFornecedores = new TelaFornecedores();
            telaFornecedores.show(stage);
        });

        VBox vbox = new VBox();

        // Adicionando padding
        Insets padding = new Insets(20);
        vbox.setPadding(padding);

        vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5, resposta);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);


        Scene scene = new Scene(vbox, 600, 400);
        stage.setTitle("Supermercado - Cadastro de Fornecedor");
        stage.setScene(scene);
        stage.show();
    }

    public TextField getTxtNome() {
        return txtNome;
    }

    public TextField getTxtCNPJ() {
        return txtCNPJ;
    }

    public TextField getTxtEmail() {
        return txtEmail;
    }

    public TextField getTxtTelefone() {
        return txtTelefone;
    }

    public Button getBtnCadastrar() {
        return btnCadastrar;
    }

    public Label getResposta() {
        return resposta;
    }

    public void limparCampos() {
        txtNome.clear();
        txtCNPJ.clear();
        txtEmail.clear();
        txtTelefone.clear();
    }
}