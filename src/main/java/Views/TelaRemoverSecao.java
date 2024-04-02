package Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
// Adicionar imagem


public class TelaRemoverSecao {
    public void show(Stage stage) {
        // Texto informativo
        Label lblInfo = new Label("Informe o NOME referente a seção que deseja realizar a remoção.");
        lblInfo.setFont(Font.font("Arial", 14));
        lblInfo.setStyle("-fx-font-weight: bold;");

        Label lblAviso = new Label("SEÇÃO NÃO ENCONTRADA!");
        lblAviso.setStyle("-fx-text-fill: white;");

        TextField txtNome = new TextField();
        txtNome.setPrefHeight(40);

        // Adicionar botoes
        Button btnRemoverSecao = new Button("DESATIVAR");

        Button btnVoltar = new Button("VOLTAR");
        btnVoltar.setOnAction(e -> {
            TelaSecoes telaSecoes = new TelaSecoes();
            telaSecoes.show(stage);
        });

        // Adicionando ícone ao botão Desativar
        Image disableIcon = new Image("assets/images/icons/desativar.png");
        ImageView disableIconView = new ImageView(disableIcon);
        disableIconView.setFitWidth(30);
        disableIconView.setFitHeight(30);
        btnRemoverSecao.setGraphic(disableIconView);
        // Definindo o background dos botões
        btnRemoverSecao.setStyle("-fx-background-color: #F79516;");

        // Adicionando ícone ao botão Voltar
        Image arrowIcon = new Image("assets/images/icons/arrow.png");
        ImageView arrowIconView = new ImageView(arrowIcon);
        arrowIconView.setFitWidth(20);
        arrowIconView.setFitHeight(20);
        btnVoltar.setGraphic(arrowIconView);
        // Definindo o background dos botões
        btnVoltar.setStyle("-fx-background-color: #F79516;");

        btnRemoverSecao.setMinWidth(235);
        btnRemoverSecao.setMinHeight(40);
        btnVoltar.setMinWidth(235);
        btnVoltar.setMinHeight(40);

        HBox hbox1 = new HBox(10);
        hbox1.getChildren().addAll(btnRemoverSecao, btnVoltar);
        hbox1.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(lblInfo, txtNome, hbox1, lblAviso);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Insets padding = new Insets(60);
        vbox.setPadding(padding);

        Scene scene = new Scene(vbox, 600, 350);
        stage.setTitle("Supermercado - Remover Seção");
        stage.setScene(scene);
        stage.show();
    }
}
