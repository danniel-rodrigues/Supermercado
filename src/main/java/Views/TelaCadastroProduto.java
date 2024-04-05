package Views;

import Controllers.ControllerProduto;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaCadastroProduto {
    private TextField txtNome;
    private TextField txtMarca;
    private TextField txtCodigo;
    private TextField txtTipo;
    private TextField txtPreco;
    private ComboBox<String> status;
    private Button btnCadastrar;
    private Button btnVoltar;
    private Label resposta;
    private ControllerProduto controllerProduto;


    public void show(Stage stage) {
        HBox hbox1 = new HBox(10);
        HBox hbox2 = new HBox(10);
        HBox hbox3 = new HBox(10);
        HBox hbox4 = new HBox(10);
        HBox hbox5 = new HBox(10);
        HBox hbox6 = new HBox(10);
        HBox hbox7 = new HBox(10);

        // H1
        // Nome
        Label lblNome = new Label("NOME:");
        txtNome = new TextField();
        txtNome.setMaxWidth(250);
        hbox1.getChildren().addAll(lblNome, txtNome);
        hbox1.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblNome, Priority.NEVER);
        HBox.setHgrow(txtNome, Priority.ALWAYS);

        // H2
        // marca
        Label lblMarca = new Label("MARCA:");
        txtMarca = new TextField();
        txtMarca.setMaxWidth(250);
        hbox2.getChildren().addAll(lblMarca, txtMarca);
        hbox2.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblMarca, Priority.NEVER);
        HBox.setHgrow(txtMarca, Priority.ALWAYS);

        // H3
        // código
        Label lblCodigo = new Label("CÓDIGO:");
        txtCodigo = new TextField();
        txtCodigo.setMaxWidth(250);
        hbox3.getChildren().addAll(lblCodigo, txtCodigo);
        hbox3.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblCodigo, Priority.NEVER);
        HBox.setHgrow(txtCodigo, Priority.ALWAYS);

        // H4
        // tipo
        Label lblTipo = new Label("TIPO:");
        txtTipo = new TextField();
        txtTipo.setMaxWidth(250);
        hbox4.getChildren().addAll(lblTipo, txtTipo);
        hbox4.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblTipo, Priority.NEVER);
        HBox.setHgrow(txtTipo, Priority.ALWAYS);

        // H5
        // preço
        Label lblPreco = new Label("PREÇO:");
        txtPreco = new TextField();
        txtPreco.setMaxWidth(250);
        hbox5.getChildren().addAll(lblPreco, txtPreco);
        hbox5.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblPreco, Priority.NEVER);
        HBox.setHgrow(txtPreco, Priority.ALWAYS);

        // H6
        // Status
        Label lblStatus = new Label("STATUS:");
        status = new ComboBox<>();
        status.setMaxWidth(200);
        lblStatus.setPadding(new Insets(0, 0, 0, -40));
        status.getItems().addAll("Ativo", "Inativo");
        // Aplicando estilos CSS personalizados
        status.setStyle(
                "-fx-background-color: white;" + // Background branco
                        "-fx-border-color: #a9a9a9;" +    // Cor da borda igual ao TextField
                        "-fx-border-radius: 5;"           // Arredondamento da borda
        );
        // Configurando uma opção padrão
        status.setValue("Selecione");

        hbox6.getChildren().addAll(lblStatus, status);
        hbox6.setPadding(new Insets(0, 0, 20, 0));
        hbox6.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblStatus, Priority.NEVER);
        HBox.setHgrow(status, Priority.ALWAYS);

        // Adicionando botões
        btnCadastrar = new Button("CADASTRAR");
        btnVoltar = new Button("VOLTAR");

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

        // H7
        hbox7.getChildren().addAll(btnCadastrar, btnVoltar);
        hbox7.setAlignment(Pos.CENTER);

        controllerProduto = new ControllerProduto(this);

        resposta = new Label("");

        btnVoltar.setOnAction(e -> {
            TelaProdutos telaProdutos = new TelaProdutos();
            telaProdutos.show(stage);
        });

        VBox vbox = new VBox();

        // Adicionando padding
        Insets padding = new Insets(20);
        vbox.setPadding(padding);

        vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5, hbox6, hbox7, resposta);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 400);
        stage.setTitle("Supermercado - Cadastro de Produto");
        stage.setScene(scene);
        stage.show();
    }

    // Métodos para recuperar os elementos da interface
    public TextField getTxtNome() {return txtNome;}
    public TextField getTxtMarca() {return txtMarca;}
    public TextField getTxtCodigo() {return txtCodigo;}
    public TextField getTxtTipo() {return txtTipo;}
    public TextField getTxtPreco() {return txtPreco;}
    public ComboBox<String> getStatus() {return status;}
    public Button getBtnCadastrar() {return this.btnCadastrar;}
    public Label getResposta() {return resposta;}

    public void limparCampos() {
        txtNome.clear();
        txtMarca.clear();
        txtCodigo.clear();
        txtTipo.clear();
        txtPreco.clear();
        status.getSelectionModel().clearSelection();
    }
}
