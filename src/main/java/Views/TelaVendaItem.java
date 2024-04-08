package Views;

import Controllers.ControllerVenda;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TelaVendaItem {
    private TextField txtCodigoProduto;
    private TextField txtQuantidade;
    private Button btnAdicionar;
    private Label resposta;

    private ControllerVenda controllerVenda;

    public void show(Stage stage) {
        HBox hbox1 = new HBox(10);
        HBox hbox2 = new HBox(10);

        // Texto informativo
        Label lblInfo = new Label("Informe o código e a quantidade referente ao produto que \ndeseja adicionar à venda.");
        lblInfo.setFont(Font.font("Arial", 14));
        lblInfo.setStyle("-fx-font-weight: bold;");

        // Codigo do Produto
        Label lblCodigoProduto = new Label("CODIGO DO PRODUTO:");
        txtCodigoProduto  = new TextField();
        txtCodigoProduto.setPrefHeight(40);
        txtCodigoProduto.setMaxWidth(250);
        hbox1.getChildren().addAll(lblCodigoProduto, txtCodigoProduto);
        hbox1.setMinHeight(20);
        hbox1.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblCodigoProduto, Priority.NEVER);
        HBox.setHgrow(txtCodigoProduto, Priority.ALWAYS);

        // Quantidade
        Label lblQuantidade = new Label("QUANTIDADE:");
        txtQuantidade = new TextField();
        txtQuantidade.setPrefHeight(40);
        txtQuantidade.setMaxWidth(250);
        hbox2.getChildren().addAll(lblQuantidade, txtQuantidade);
        hbox2.setMinHeight(20);
        hbox2.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblQuantidade, Priority.NEVER);
        HBox.setHgrow(txtQuantidade, Priority.ALWAYS);

        resposta = new Label("");

        // Adicionar botoes
        btnAdicionar = new Button("ADICIONAR");

        controllerVenda = new ControllerVenda(this);

        Button btnListar = new Button("LISTAR PRODUTOS");
        btnListar.setOnAction(e -> {
            ModalProdutos modalProdutos = new ModalProdutos();
            modalProdutos.abrirModal();
        });

        Button btnVoltar = new Button("VOLTAR");
        btnVoltar.setOnAction(e -> {
            TelaVendas telaVendas = new TelaVendas();
            telaVendas.show(stage);
        });

        // Adicionando ícone ao botão Adicionar
        Image plusIcon = new Image("assets/images/icons/plus.png");
        ImageView plusIconView = new ImageView(plusIcon);
        plusIconView.setFitWidth(20);
        plusIconView.setFitHeight(20);
        btnAdicionar.setGraphic(plusIconView);
        btnAdicionar.setStyle("-fx-background-color: #F79516;");

        // Adicionando ícone ao botão Listar
        Image glassIcon = new Image("assets/images/icons/magnifying-glass.png");
        ImageView glassIconView = new ImageView(glassIcon);
        glassIconView.setFitWidth(20);
        glassIconView.setFitHeight(20);
        btnListar.setGraphic(glassIconView);
        btnListar.setStyle("-fx-background-color: #F79516;");

        // Adicionando ícone ao botão Voltar
        Image arrowIcon = new Image("assets/images/icons/arrow.png");
        ImageView arrowIconView = new ImageView(arrowIcon);
        arrowIconView.setFitWidth(20);
        arrowIconView.setFitHeight(20);
        btnVoltar.setGraphic(arrowIconView);
        btnVoltar.setStyle("-fx-background-color: #F79516;");

        btnAdicionar.setMinWidth(170);
        btnAdicionar.setMinHeight(40);
        btnListar.setMinWidth(170);
        btnListar.setMinHeight(40);
        btnVoltar.setMinWidth(170);
        btnVoltar.setMinHeight(40);

        HBox hbox3 = new HBox(10);
        hbox3.getChildren().addAll(btnAdicionar, btnListar, btnVoltar);
        hbox3.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(lblInfo, hbox1, hbox2, hbox3, resposta);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Insets padding = new Insets(50);
        vbox.setPadding(padding);

        Scene scene = new Scene(vbox, 600, 350);
        stage.setTitle("Supermercado - Adicionar Itens a Venda");
        stage.setScene(scene);
        stage.show();
    }

    public TextField getTxtCodigoProduto() {
        return txtCodigoProduto;
    }

    public TextField getTxtQuantidade() {
        return txtQuantidade;
    }

    public Button getbtnAdicionar() {
        return btnAdicionar;
    }

    public Label getResposta() {
        return resposta;
    }

    public void limparCampos() {
        txtCodigoProduto.clear();
        txtQuantidade.clear();
    }
}
