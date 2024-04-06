package Views;

import Controllers.ControllerItem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaCadastroItem {
    private TextField txtCodigoProduto;
    private TextField txtDataFab;
    private TextField txtDataVal;
    private TextField txtLote;
    private TextField txtPeso;
    private TextField txtQuantidade;
    private Button btnCadastrar;
    private Label resposta;
    private ControllerItem controllerItem;
    public void show(Stage stage) {
        HBox hbox1 = new HBox(10);
        HBox hbox2 = new HBox(10);
        HBox hbox3 = new HBox(10);
        HBox hbox4 = new HBox(10);
        HBox hbox5 = new HBox(10);
        HBox hbox6 = new HBox(10);
        HBox hbox7 = new HBox(10);

        // Codigo do Produto
        Label lblCodigoProduto = new Label("CODIGO DO PRODUTO:");
        txtCodigoProduto = new TextField();
        txtCodigoProduto.setMaxWidth(250);
        hbox1.getChildren().addAll(lblCodigoProduto, txtCodigoProduto);
        hbox1.setMinHeight(20);
        hbox1.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblCodigoProduto, Priority.NEVER);
        HBox.setHgrow(txtCodigoProduto, Priority.ALWAYS);

        // Data de Fabricação
        Label lblDataFab = new Label("DATA DE FABRICAÇÃO:");
        txtDataFab = new TextField();
        txtDataFab.setMaxWidth(250);
        txtDataFab.setPromptText("DD/MM/AAAA");
        hbox2.getChildren().addAll(lblDataFab, txtDataFab);
        hbox2.setMinHeight(20);
        hbox2.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblDataFab, Priority.NEVER);
        HBox.setHgrow(txtDataFab, Priority.ALWAYS);

        // Data de Validade
        Label lblDataVal = new Label("DATA DE VALIDADE:");
        txtDataVal = new TextField();
        txtDataVal.setMaxWidth(250);
        txtDataVal.setPromptText("DD/MM/AAAA");
        hbox3.getChildren().addAll(lblDataVal, txtDataVal);
        hbox3.setMinHeight(20);
        hbox3.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblDataVal, Priority.NEVER);
        HBox.setHgrow(txtDataVal, Priority.ALWAYS);

        // Lote
        Label lblLote = new Label("LOTE:");
        txtLote = new TextField();
        txtLote.setMaxWidth(250);
        hbox4.getChildren().addAll(lblLote, txtLote);
        hbox4.setMinHeight(20);
        hbox4.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblLote, Priority.NEVER);
        HBox.setHgrow(txtLote, Priority.ALWAYS);

        // Peso
        Label lblPeso = new Label("PESO:");
        txtPeso = new TextField();
        txtPeso.setMaxWidth(250);
        hbox5.getChildren().addAll(lblPeso, txtPeso);
        hbox5.setMinHeight(20);
        hbox5.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblPeso, Priority.NEVER);
        HBox.setHgrow(txtPeso, Priority.ALWAYS);

        // Quantidade
        Label lblQuantidade = new Label("QUANTIDADE:");
        txtQuantidade = new TextField();
        txtQuantidade.setMaxWidth(250);
        hbox6.getChildren().addAll(lblQuantidade, txtQuantidade);
        hbox6.setMinHeight(20);
        hbox6.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblQuantidade, Priority.NEVER);
        HBox.setHgrow(txtQuantidade, Priority.ALWAYS);

        // Adicionando botões
        btnCadastrar = new Button("CADASTRAR");
        Button btnVoltar = new Button("VOLTAR");

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

        // H6
        hbox7.getChildren().addAll(btnCadastrar, btnVoltar);
        hbox7.setMinHeight(50);
        hbox7.setAlignment(Pos.CENTER);

        controllerItem = new ControllerItem(this);

        resposta = new Label("");

        btnVoltar.setOnAction(e -> {
            TelaItens telaItens = new TelaItens();
            telaItens.show(stage);
        });

        VBox vbox = new VBox();

        // Adicionando padding
        Insets padding = new Insets(20);
        vbox.setPadding(padding);

        vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5, hbox6, hbox7, resposta);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 400);
        stage.setTitle("Supermercado - Cadastro de Itens");
        stage.setScene(scene);
        stage.show();
    }

    public TextField getTxtCodigoProduto() {
        return txtCodigoProduto;
    }

    public TextField getTxtDataFab() {
        return txtDataFab;
    }

    public TextField getTxtDataVal() {
        return txtDataVal;
    }

    public TextField getTxtLote() {
        return txtLote;
    }

    public TextField getTxtPeso() {
        return txtPeso;
    }

    public TextField getTxtQuantidade() {
        return txtQuantidade;
    }

    public Button getBtnCadastrar() {
        return btnCadastrar;
    }

    public Label getResposta() {
        return resposta;
    }

    public void limparCampos() {
        txtCodigoProduto.clear();
        txtDataFab.clear();
        txtDataVal.clear();
        txtLote.clear();
        txtPeso.clear();
        txtQuantidade.clear();
    }
}
