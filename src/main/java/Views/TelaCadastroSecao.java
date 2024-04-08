package Views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class TelaCadastroSecao {
    public void show(Stage stage) {
        HBox hbox1 = new HBox(10);
        HBox hbox2 = new HBox(10);
        HBox hbox3 = new HBox(10);
        HBox hbox4 = new HBox(10);


        // H1
        // Nome
        Label lblNome = new Label("NOME:");
        TextField txtNome = new TextField();
        txtNome.setMaxWidth(250);
        hbox1.getChildren().addAll(lblNome, txtNome);
        hbox1.setMinHeight(20);
        hbox1.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblNome, Priority.NEVER);
        HBox.setHgrow(txtNome, Priority.ALWAYS);

        // H2
        // código
        Label lblCodigo = new Label("CÓDIGO:");
        TextField txtCodigo = new TextField();
        txtCodigo.setMaxWidth(250);
        hbox2.getChildren().addAll(lblCodigo, txtCodigo);
        hbox2.setMinHeight(20);
        hbox2.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblCodigo, Priority.NEVER);
        HBox.setHgrow(txtCodigo, Priority.ALWAYS);

        // H3
        // Código do produto
        Label lblCodProduto = new Label("CÓD. PRODUTO:");
        TextField txtCodProduto = new TextField();
        txtCodProduto.setMaxWidth(230);
        hbox3.getChildren().addAll(lblCodProduto, txtCodProduto);
        hbox3.setMinHeight(20);
        hbox3.setAlignment(Pos.CENTER);
        hbox3.setPadding(new Insets(0, 0, 80,0));

        HBox.setHgrow(lblCodProduto, Priority.NEVER);
        HBox.setHgrow(txtCodProduto, Priority.ALWAYS);

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

        // H4
        hbox4.getChildren().addAll(btnCadastrar, btnVoltar);
        hbox4.setMinHeight(50);
        hbox4.setAlignment(Pos.CENTER);

        Label resposta = new Label("");
        btnCadastrar.setOnAction(e -> {
            resposta.setText("Existem campos inválidos ou não preenchidos!".toUpperCase());
            resposta.setStyle("-fx-text-fill: purple;");
        });

        btnVoltar.setOnAction(e -> {
            TelaSecoes telaSecoes = new TelaSecoes();
            telaSecoes.show(stage);
        });

        VBox vbox = new VBox();

        // Adicionando padding
        Insets padding = new Insets(20);
        vbox.setPadding(padding);

        vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, resposta);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 400);
        stage.setTitle("Supermercado - Cadastro de Seção");
        stage.setScene(scene);
        stage.show();
    }
}
