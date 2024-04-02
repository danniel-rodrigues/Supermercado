package Views;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
// Adicionar imagem
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TelaDesativarProduto {
    public void show(Stage stage) {
        // Texto informativo
        Label lblInfo = new Label("Informe o CÓDIGO referente ao produto que deseja realizar\na desativação.");
        lblInfo.setFont(Font.font("Arial", 14));
        lblInfo.setStyle("-fx-font-weight: bold;");

        Label lblAviso = new Label("PRODUTO NÃO ENCONTRADO!");
        lblAviso.setStyle("-fx-text-fill: white;");

        TextField txtCodigo = new TextField();
        txtCodigo.setPrefHeight(40);

        // Adicionar botoes
        Button btnDesativar = new Button("DESATIVAR");
        btnDesativar.setOnAction(e -> {

        });

        Button btnVoltar = new Button("VOLTAR");
        btnVoltar.setOnAction(e -> {
            TelaProdutos telaProdutos = new TelaProdutos();
            telaProdutos.show(stage);
        });

        // Adicionando ícone ao botão Desativar
        Image disableIcon = new Image("assets/images/icons/desativar.png");
        ImageView disableIconView = new ImageView(disableIcon);
        disableIconView.setFitWidth(30);
        disableIconView.setFitHeight(30);
        btnDesativar.setGraphic(disableIconView);
        // Definindo o background dos botões
        btnDesativar.setStyle("-fx-background-color: #F79516;");

        // Adicionando ícone ao botão Voltar
        Image arrowIcon = new Image("assets/images/icons/arrow.png");
        ImageView arrowIconView = new ImageView(arrowIcon);
        arrowIconView.setFitWidth(20);
        arrowIconView.setFitHeight(20);
        btnVoltar.setGraphic(arrowIconView);
        // Definindo o background dos botões
        btnVoltar.setStyle("-fx-background-color: #F79516;");

        btnDesativar.setMinWidth(235);
        btnDesativar.setMinHeight(40);
        btnVoltar.setMinWidth(235);
        btnVoltar.setMinHeight(40);

        HBox hbox1 = new HBox(10);
        hbox1.getChildren().addAll(btnDesativar, btnVoltar);
        hbox1.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(lblInfo, txtCodigo, hbox1, lblAviso);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Insets padding = new Insets(60);
        vbox.setPadding(padding);

        Scene scene = new Scene(vbox, 600, 350);
        stage.setTitle("Supermercado - Desativar Produto");
        stage.setScene(scene);
        stage.show();
    }
}
