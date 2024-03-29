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

public class TelaBuscarProduto {

    public void show(Stage stage) {
        // Texto informativo
        Label lblInfo = new Label("Informe o CÓDIGO referente ao produto que deseja realizar\na alteração de informações.");
        lblInfo.setFont(Font.font("Arial", 14));
        lblInfo.setStyle("-fx-font-weight: bold;");

        Label lblAviso = new Label("PRODUTO NÃO ENCONTRADO!");
        lblAviso.setStyle("-fx-text-fill: white;");

        TextField txtCodigo = new TextField();
        txtCodigo.setPrefHeight(40);

        // Adicionar botoes
        Button btnBuscar = new Button("BUSCAR");
        btnBuscar.setOnAction(e -> {

        });

        Button btnVoltar = new Button("VOLTAR");
        btnVoltar.setOnAction(e -> {
            TelaProdutos telaProdutos = new TelaProdutos();
            telaProdutos.show(stage);
        });

        // Adicionando ícone ao botão Buscar
        Image glassICon = new Image("assets/images/icons/magnifying-glass.png");
        ImageView glassIConView = new ImageView(glassICon);
        glassIConView.setFitWidth(20);
        glassIConView.setFitHeight(20);
        btnBuscar.setGraphic(glassIConView);
        // Definindo o background dos botões
        btnBuscar.setStyle("-fx-background-color: #F79516;");

        // Adicionando ícone ao botão Voltar
        Image arrowIcon = new Image("assets/images/icons/arrow.png");
        ImageView arrowIconView = new ImageView(arrowIcon);
        arrowIconView.setFitWidth(20);
        arrowIconView.setFitHeight(20);
        btnVoltar.setGraphic(arrowIconView);
        // Definindo o background dos botões
        btnVoltar.setStyle("-fx-background-color: #F79516;");

        btnBuscar.setMinWidth(235);
        btnBuscar.setMinHeight(40);
        btnVoltar.setMinWidth(235);
        btnVoltar.setMinHeight(40);

        HBox hbox1 = new HBox(10);
        hbox1.getChildren().addAll(btnBuscar, btnVoltar);
        hbox1.setAlignment(Pos.CENTER);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(lblInfo, txtCodigo, hbox1, lblAviso);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Insets padding = new Insets(60);
        vbox.setPadding(padding);

        Scene scene = new Scene(vbox, 600, 500);
        stage.setTitle("Supermercado - Buscar Produto");
        stage.setScene(scene);
        stage.show();
    }
}
