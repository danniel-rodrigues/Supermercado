package Views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modulos.funcionarios.Models.Item;


public class TelaCaixa {
    public void show(Stage stage) {
        // Criando botões
        Button btnRegistrarItem = new Button("Registrar Item");
        Button btnCancelarItem = new Button("Cancelar Item");
        Button btnConcluirCompra = new Button("Concluir Compra");
        Button btnVoltarInicio = new Button("VOLTAR AO INÍCIO");

        // Definindo a ação dos botões
        btnRegistrarItem.setOnAction(e -> {
            // Implemente a lógica para registrar um item aqui
        });

        btnCancelarItem.setOnAction(e -> {
            // Implemente a lógica para cancelar um item aqui
        });

        btnConcluirCompra.setOnAction(e -> {
            // Implemente a lógica para concluir a compra aqui
        });

        btnVoltarInicio.setOnAction(e -> {
            TelaInicial telaInicial = new TelaInicial();
            telaInicial.show(stage);
        });

        
        // Criando TableView para exibir os itens registrados
        TableView<Item> tableView = new TableView<>();
        TableColumn<Item, String> nomeColumn = new TableColumn<>("Nome");
        TableColumn<Item, Float> precoColumn = new TableColumn<>("Preço");
        tableView.getColumns().addAll(nomeColumn, precoColumn);

        // Criando VBox para organizar os elementos
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(btnRegistrarItem, btnCancelarItem, btnConcluirCompra, tableView);

        // Criando a cena e exibindo no palco
        Scene scene = new Scene(vbox, 600, 400);
        stage.setTitle("Supermercado - Caixa");
        stage.setScene(scene);
        stage.show();
    }
}
