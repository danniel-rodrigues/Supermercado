package Views;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;

public class TelaCadastroRemessa {
    public void show(Stage stage) {
        HBox hbox1 = new HBox(10);
        HBox hbox2 = new HBox(10);
        HBox hbox3 = new HBox(10);
        HBox hbox4 = new HBox(10);
        HBox hbox5 = new HBox(10);

        // H1
        // Fornecedor
        Label lblFornecedor = new Label("FORNECEDOR:");
        TextField txtFornecedor = new TextField();
        txtFornecedor.setMaxWidth(250);
        hbox1.getChildren().addAll(lblFornecedor, txtFornecedor);
        hbox1.setMinHeight(20);
        hbox1.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblFornecedor, Priority.NEVER);
        HBox.setHgrow(txtFornecedor, Priority.ALWAYS);

        // H2
        // Data de envio
        Label lblDataEnvio = new Label("DATA DE ENVIO:");
        TextField txtDataEnvio = new TextField();
        txtDataEnvio.setMaxWidth(250);
        hbox2.getChildren().addAll(lblDataEnvio, txtDataEnvio);
        hbox2.setMinHeight(20);
        hbox2.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblDataEnvio, Priority.NEVER);
        HBox.setHgrow(txtDataEnvio, Priority.ALWAYS);

        // H3
        // Data de recebimento
        Label lblDataRecebimento = new Label("DATA DE RECEBIMENTO:");
        TextField txtDataRecebimento = new TextField();
        txtDataRecebimento.setMaxWidth(200);
        hbox3.getChildren().addAll(lblDataRecebimento, txtDataRecebimento);
        hbox3.setMinHeight(20);
        hbox3.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblDataRecebimento, Priority.NEVER);
        HBox.setHgrow(txtDataRecebimento, Priority.ALWAYS);

        // H4
        // Status
        Label lblStatus = new Label("STATUS:");
        TextField txtStatus = new TextField();
        txtStatus.setMaxWidth(250);
        lblStatus.setPadding(new Insets(0, 0, 0, -40));
        hbox4.getChildren().addAll(lblStatus, txtStatus);
        hbox4.setMinHeight(20);
        hbox4.setPadding(new Insets(0, 0, 50, 0));
        hbox4.setAlignment(Pos.CENTER);

        HBox.setHgrow(lblStatus, Priority.NEVER);
        HBox.setHgrow(txtStatus, Priority.ALWAYS);

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

        // H5
        hbox5.getChildren().addAll(btnCadastrar, btnVoltar);
        hbox5.setMinHeight(50);
        hbox5.setAlignment(Pos.CENTER);

        Label resposta = new Label("");
        btnCadastrar.setOnAction(e -> {
            resposta.setText("Existem campos inválidos ou não preenchidos!".toUpperCase());
            resposta.setStyle("-fx-text-fill: purple;");
        });

        btnVoltar.setOnAction(e -> {
            TelaRemessaFornecimento telaRemessaFornecimento = new TelaRemessaFornecimento();
            telaRemessaFornecimento.show(stage);
        });

        VBox vbox = new VBox();

        // Adicionando padding
        Insets padding = new Insets(20);
        vbox.setPadding(padding);

        vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4, hbox5, resposta);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 400);
        stage.setTitle("Supermercado - Cadastro de Remessa");
        stage.setScene(scene);
        stage.show();
    }
}