package Views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class TelaFornecimento {
    public void show(Stage stage) {
        HBox hbox = new HBox(); // Criando um HBox
        hbox.setSpacing(10); // Espaçamento entre os botões
        hbox.setAlignment(Pos.CENTER);
        // Adicionando botões ao HBox
        Button btnCadastrar = new Button("CADASTRAR");
//        Button btnAlterarRemessa = new Button("ALTERAR REMESSA");
        Button btnVoltarInicio = new Button("VOLTAR AO INÍCIO");

        // Definindo a ação dos botões
        btnCadastrar.setOnAction(e -> {
            TelaCadastroRemessa telaCadastroRemessa = new TelaCadastroRemessa();
            telaCadastroRemessa.show(stage);
        });

        btnVoltarInicio.setOnAction(e -> {
            TelaInicial telaInicial = new TelaInicial();
            telaInicial.show(stage);
        });

        // Definindo a largura mínima dos botões
        btnCadastrar.setMinWidth(150);
        btnCadastrar.setMinHeight(50);

        btnVoltarInicio.setMinWidth(450);
        btnVoltarInicio.setMinHeight(50);

        // Definindo o background dos botões
        btnCadastrar.setStyle("-fx-background-color: #F79516;");
        btnVoltarInicio.setStyle("-fx-background-color: #F79516;");

        hbox.getChildren().addAll(btnCadastrar);

        // Criando uma lista de funcionários
        List<Integer> listaExemplo = new ArrayList<>();
        listaExemplo.add(1);
        listaExemplo.add(2);
        listaExemplo.add(3);
        listaExemplo.add(4);

        ObservableList<Integer> exemplo = FXCollections.observableArrayList(
                listaExemplo
        );

        // Criando a ListView e passando a lista de produtos
        ListView<Integer> listView = new ListView<>(exemplo);

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
        stage.setTitle("Supermercado - Remessas");
        stage.setScene(scene);
        stage.show();
    }
}