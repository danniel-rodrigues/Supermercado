package Views;

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
        TextField txtCodigoProduto = new TextField();
        txtCodigoProduto.setMaxWidth(250);
        hbox1.getChildren().addAll(lblCodigoProduto, txtCodigoProduto);
        hbox1.setMinHeight(20);
        hbox1.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblCodigoProduto, Priority.NEVER);
        HBox.setHgrow(txtCodigoProduto, Priority.ALWAYS);

        // Data de Fabricação
        Label lblDataFab = new Label("DATA DE FABRICAÇÃO:");
        TextField txtDataFab = new TextField();
        txtDataFab.setMaxWidth(250);
        hbox2.getChildren().addAll(lblDataFab, txtDataFab);
        hbox2.setMinHeight(20);
        hbox2.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblDataFab, Priority.NEVER);
        HBox.setHgrow(txtDataFab, Priority.ALWAYS);

        // Data de Validade
        Label lblDataVal = new Label("DATA DE VALIDADE:");
        TextField txtDataVal = new TextField();
        txtDataVal.setMaxWidth(250);
        hbox3.getChildren().addAll(lblDataVal, txtDataVal);
        hbox3.setMinHeight(20);
        hbox3.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblDataVal, Priority.NEVER);
        HBox.setHgrow(txtDataVal, Priority.ALWAYS);

        // Lote
        Label lblLote = new Label("LOTE:");
        TextField txtLote = new TextField();
        txtLote.setMaxWidth(250);
        hbox4.getChildren().addAll(lblLote, txtLote);
        hbox4.setMinHeight(20);
        hbox4.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblLote, Priority.NEVER);
        HBox.setHgrow(txtLote, Priority.ALWAYS);

        // Peso
        Label lblPeso = new Label("PESO:");
        TextField txtPeso = new TextField();
        txtPeso.setMaxWidth(250);
        hbox5.getChildren().addAll(lblPeso, txtPeso);
        hbox5.setMinHeight(20);
        hbox5.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblPeso, Priority.NEVER);
        HBox.setHgrow(txtPeso, Priority.ALWAYS);

        // Quantidade
        Label lblQuantidade = new Label("QUANTIDADE:");
        TextField txtQuantidade = new TextField();
        txtQuantidade.setMaxWidth(250);
        hbox6.getChildren().addAll(lblQuantidade, txtQuantidade);
        hbox6.setMinHeight(20);
        hbox6.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblQuantidade, Priority.NEVER);
        HBox.setHgrow(txtQuantidade, Priority.ALWAYS);

        // Adicionando botões
        Button btnCadastrar = new Button("CADASTRAR");
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

        Label resposta = new Label("");
        btnCadastrar.setOnAction(e -> {
            resposta.setText("Existem campos inválidos ou não preenchidos!".toUpperCase());
            resposta.setStyle("-fx-text-fill: purple;");
        });

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
}
