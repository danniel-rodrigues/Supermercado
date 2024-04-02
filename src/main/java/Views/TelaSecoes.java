package Views;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.List;
import java.util.ArrayList;

public class TelaSecoes {
    public void show(Stage stage) {
        HBox hbox = new HBox(); // Criando um HBox
        hbox.setSpacing(10); // Espaçamento entre os botões
        hbox.setAlignment(Pos.CENTER);

        // Adicionando botões ao HBox
        Button btnDefinirSecao = new Button("DEFINIR SEÇÃO");
        Button btnRemoverSecao = new Button("REMOVER SEÇÃO");
        Button btnVoltarInicio = new Button("VOLTAR AO INÍCIO");

        // Definindo ações dos botões
        btnDefinirSecao.setOnAction(e -> {
            TelaCadastroSecao telaCadastroSecao = new TelaCadastroSecao();
            telaCadastroSecao.show(stage);
        });

        btnRemoverSecao.setOnAction(e -> {
            TelaRemoverSecao telaRemoverSecao = new TelaRemoverSecao();
            telaRemoverSecao.show(stage);
        });

        btnVoltarInicio.setOnAction(e -> {
            TelaInicial telaInicial = new TelaInicial();
            telaInicial.show(stage);
        });

        // Definindo a largura mínima dos botões
        btnDefinirSecao.setMinWidth(150);
        btnDefinirSecao.setMinHeight(50);

        btnRemoverSecao.setMinWidth(150);
        btnRemoverSecao.setMinHeight(50);

        btnVoltarInicio.setMinWidth(450);
        btnVoltarInicio.setMinHeight(50);

        // Definindo o background dos botões
        btnDefinirSecao.setStyle("-fx-background-color: #F79516;");
        btnRemoverSecao.setStyle("-fx-background-color: #F79516;");
        btnVoltarInicio.setStyle("-fx-background-color: #F79516;");

        hbox.getChildren().addAll(btnDefinirSecao, btnRemoverSecao);

        // Criando uma lista de fornecedores
        List<Integer> listaSecao = new ArrayList<>();

        listaSecao.add(1);
        listaSecao.add(2);
        listaSecao.add(3);
        listaSecao.add(4);

        ObservableList<Integer> secoes = FXCollections.observableArrayList(
                listaSecao
        );

        // Criando a ListView e passando a lista de seções
        ListView<Integer> listView = new ListView<>(secoes);

        // Definindo a altura de cada item da ListView
        listView.setFixedCellSize(40);

        VBox vbox = new VBox();
        // Definindo o espaçamento interno
        Insets padding = new Insets(20);
        vbox.setPadding(padding);
        vbox.getChildren().addAll(hbox, listView, btnVoltarInicio);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 500);
        stage.setTitle("Supermercado - Seções");
        stage.setScene(scene);
        stage.show();
    }
}
