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

public class TelaAlterarProduto {
    public void show(Stage stage) {
        HBox hbox1 = new HBox(10);
        HBox hbox2 = new HBox(10);
        HBox hbox3 = new HBox(10);
        HBox hbox4 = new HBox(10);
        HBox hbox5 = new HBox(10);
        HBox hbox6 = new HBox(10);

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
        // marca
        Label lblMarca = new Label("MARCA:");
        TextField txtMarca = new TextField();
        txtMarca.setMaxWidth(250);
        hbox2.getChildren().addAll(lblMarca, txtMarca);
        hbox2.setMinHeight(20);
        hbox2.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblMarca, Priority.NEVER);
        HBox.setHgrow(txtMarca, Priority.ALWAYS);

        // H3
        // código
        Label lblCodigo = new Label("CÓDIGO:");
        TextField txtCodigo = new TextField();
        txtCodigo.setMaxWidth(250);
        hbox3.getChildren().addAll(lblCodigo, txtCodigo);
        hbox3.setMinHeight(20);
        hbox3.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblCodigo, Priority.NEVER);
        HBox.setHgrow(txtCodigo, Priority.ALWAYS);

        // H4
        // tipo
        Label lblTipo = new Label("TIPO:");
        TextField txtTipo = new TextField();
        txtTipo.setMaxWidth(250);
        hbox4.getChildren().addAll(lblTipo, txtTipo);
        hbox4.setMinHeight(20);
        hbox4.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblTipo, Priority.NEVER);
        HBox.setHgrow(txtTipo, Priority.ALWAYS);

        // H5
        // preço
        Label lblPreco = new Label("PREÇO:");
        TextField txtPreco = new TextField();
        txtPreco.setMaxWidth(250);
        hbox5.getChildren().addAll(lblPreco, txtPreco);
        hbox5.setMinHeight(20);
        hbox5.setPadding(new Insets(0, 0, 50,0));
        hbox5.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblPreco, Priority.NEVER);
        HBox.setHgrow(txtPreco, Priority.ALWAYS);

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
        hbox6.getChildren().addAll(btnCadastrar, btnVoltar);
        hbox6.setMinHeight(50);
        hbox6.setAlignment(Pos.CENTER);

        Label resposta = new Label("");
        btnCadastrar.setOnAction(e -> {
            resposta.setText("Existem campos inválidos ou não preenchidos!".toUpperCase());
            resposta.setStyle("-fx-text-fill: purple;");
        });

        btnVoltar.setOnAction(e -> {
            TelaProdutos telaProdutos = new TelaProdutos();
            telaProdutos.show(stage);
        });

        VBox vbox = new VBox();

        // Adicionando padding
        Insets padding = new Insets(20);
        vbox.setPadding(padding);

        vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5, hbox6, resposta);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 400);
        stage.setTitle("Supermercado - Alterar dados do Produto");
        stage.setScene(scene);
        stage.show();
    }
}
