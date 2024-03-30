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

public class TelaDemitirFuncionario{
    public void show(Stage stage) {
        // texto informativo
        Label lblInfo = new Label("Informe o CPF do funcionário que deseja realizar\na demissão. (Exclusivo para uso do Gerente!)");
        lblInfo.setFont(Font.font("Arial", 14));
        lblInfo.setStyle("-fx-font-weight: bold;");

        Label lblAviso = new Label("FUNCIONÁRIO NÃO ENCONTRADO!");
        lblAviso.setStyle("-fx-text-fill: white;");

        TextField cpf = new TextField();
        cpf.setPrefHeight(40);

        // Adicionar botoes
        Button btnBuscar = new Button("BUSCAR");
        btnBuscar.setOnAction(e -> {
            lblAviso.setStyle("-fx-text-fill: red;");
        });

        // Adicionando ícones aos botões
        Image glassIcon = new Image("assets/images/icons/magnifying-glass.png");
        ImageView glassIconView = new ImageView(glassIcon);
        glassIconView.setFitWidth(20);
        glassIconView.setFitHeight(20);
        btnBuscar.setGraphic(glassIconView);
        // Definindo o background dos botões
        btnBuscar.setStyle("-fx-background-color: #F79516;");


        Button btnVoltar = new Button("VOLTAR");
        btnVoltar.setOnAction(e -> {
            TelaFuncionarios telaFuncionarios = new TelaFuncionarios();
            telaFuncionarios.show(stage);
        });

        // Adicionando ícones aos botões
        Image arrowIcon = new Image("assets/images/icons/arrow.png");
        ImageView arrowIConView = new ImageView(arrowIcon);
        arrowIConView.setFitWidth(20);
        arrowIConView.setFitHeight(20);
        btnVoltar.setGraphic(arrowIConView);
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
        vbox.getChildren().addAll(lblInfo, cpf, hbox1, lblAviso);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Insets padding = new Insets(60);
        vbox.setPadding(padding);

        Scene scene = new Scene(vbox, 600, 500);
        stage.setTitle("Supermercado - Demitir Funcionário");
        stage.setScene(scene);
        stage.show();
    }
}