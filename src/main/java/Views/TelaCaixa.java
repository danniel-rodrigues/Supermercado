package Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Models.Item;


public class TelaCaixa {
    public void show(Stage stage) {

        HBox hbox = new HBox(); // Criando um HBox
        hbox.setSpacing(8); // Espaçamento entre os botões
        hbox.setAlignment(Pos.CENTER);

        // Criando botões
        Button btnRegistrarItem = new Button("Registrar Item");
        Button btnReportarPreco = new Button("Reportar Preço");
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
        btnConcluirCompra.setOnAction(e -> {
            // Implemente a lógica para reportar o preço aqui
        });

        btnVoltarInicio.setOnAction(e -> {
            TelaInicial telaInicial = new TelaInicial();
            telaInicial.show(stage);
        });


        // Definindo a largura mínima dos botões
        btnCancelarItem.setMinWidth(130);
        btnCancelarItem.setMinHeight(50);

        btnRegistrarItem.setMinWidth(130);
        btnRegistrarItem.setMinHeight(50);

        btnConcluirCompra.setMinWidth(130);
        btnConcluirCompra.setMinHeight(50);

        btnReportarPreco.setMinWidth(130);
        btnReportarPreco.setMinHeight(50);

        btnVoltarInicio.setMinWidth(450);
        btnVoltarInicio.setMinHeight(50);

        //definindo os estilo dos botões
        btnRegistrarItem.setStyle("-fx-background-color: #F79516;");
        btnCancelarItem.setStyle("-fx-background-color: #F79516;");
        btnConcluirCompra.setStyle("-fx-background-color: #F79516;");
        btnVoltarInicio.setStyle("-fx-background-color: #F79516;");
        btnReportarPreco.setStyle("-fx-background-color: #F79516;");

        hbox.getChildren().addAll(btnRegistrarItem, btnCancelarItem, btnConcluirCompra, btnReportarPreco);


        //Criando TableView para exibir os itens registrados
        TableView<Item> tableView = new TableView<>();
        TableColumn<Item, String> nomeColumn = new TableColumn<>("Nome");
        TableColumn<Item, Float> precoColumn = new TableColumn<>("Preço");
        //ObservableList<String> items = FXCollections.observableArrayList( );
        //tableView.setItems(items);
        tableView.getColumns().addAll(nomeColumn, precoColumn);

        // Redimensionando as colunas para preencher o espaço disponível igualmente
        double larguraColuna = 1.0 / tableView.getColumns().size();
        tableView.getColumns().forEach(coluna -> coluna.setPrefWidth(tableView.getWidth() * larguraColuna));

        // Adicionando listener para redimensionar as colunas quando a tabela for redimensionada
        tableView.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            tableView.getColumns().forEach(coluna -> coluna.setPrefWidth(newWidth.doubleValue() * larguraColuna));
        });


        // Criando VBox para organizar os elementos
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(hbox, tableView, btnVoltarInicio);

        // Criando a cena e exibindo no palco
        Scene scene = new Scene(vbox, 600, 400);
        stage.setTitle("Supermercado - Caixa");
        stage.setScene(scene);
        stage.show();
    }
}
