package modulos.funcionarios.Views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TelaFornecedores {
    public void show(Stage stage) {
        HBox hbox = new HBox(); // Criando um HBox
        hbox.setSpacing(10); // Espaçamento entre os botões
        hbox.setAlignment(Pos.CENTER);

        // Adicionando botões ao HBox
        Button btnCadastrar = new Button("CADASTRAR");
        Button btnAlterarCadastro = new Button("ALTERAR CADASTRO");
        Button btnVoltarInicio = new Button("VOLTAR AO INÍCIO");

        // Definindo ações dos botões
        btnCadastrar.setOnAction(e -> {
            TelaCadastroFornecedor telaCadastroFornecedor = new TelaCadastroFornecedor();
            telaCadastroFornecedor.show(stage);
        });

        btnAlterarCadastro.setOnAction(e -> {
            //TO DO
        });

        btnVoltarInicio.setOnAction(e -> {
            TelaInicial telaInicial = new TelaInicial();
            telaInicial.show(stage);
        });


        // Definindo a largura mínima dos botões
        btnCadastrar.setMinWidth(150);
        btnCadastrar.setMinHeight(50);

        btnAlterarCadastro.setMinWidth(150);
        btnAlterarCadastro.setMinHeight(50);

        btnVoltarInicio.setMinWidth(450);
        btnVoltarInicio.setMinHeight(50);

        // Definindo o background dos botões
        btnCadastrar.setStyle("-fx-background-color: #F79516;");
        btnAlterarCadastro.setStyle("-fx-background-color: #F79516;");
        btnVoltarInicio.setStyle("-fx-background-color: #F79516;");

        hbox.getChildren().addAll(btnCadastrar, btnAlterarCadastro);

        // Criando uma lista de fornecedores
        List<Integer> listaFornecedores = new ArrayList<>();

        listaFornecedores.add(1);
        listaFornecedores.add(2);
        listaFornecedores.add(3);
        listaFornecedores.add(4);

        ObservableList<Integer> fornecedores = FXCollections.observableArrayList(
                listaFornecedores
        );

        // Criando a ListView e passando a lista de fornecedores
        ListView<Integer> listView = new ListView<>(fornecedores);

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
        stage.setTitle("Supermercado - Fornecedores");
        stage.setScene(scene);
        stage.show();
    }
}
