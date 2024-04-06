package Views;

import DAO.ItemDAO;
import Models.Item;
import Models.Produto;
import Views.TelaCadastroItem;
import Views.TelaInicial;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.text.SimpleDateFormat;
import java.util.List;

public class TelaItens {
    public void show(Stage stage) {
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        Button btnCadastrar = new Button("CADASTRAR");
        Button btnRemover = new Button("REMOVER");
        Button btnVoltarInicio = new Button("VOLTAR AO INÍCIO");

        btnCadastrar.setOnAction(e -> {
            TelaCadastroItem telaCadastroItem = new TelaCadastroItem();
            telaCadastroItem.show(stage);
        });

        btnVoltarInicio.setOnAction(e -> {
            TelaInicial telaInicial = new TelaInicial();
            telaInicial.show(stage);
        });

        btnRemover.setOnAction(e -> {
            TelaRemoverItem TelaRemoverItem = new TelaRemoverItem();
            TelaRemoverItem.show(stage);
        });

        btnCadastrar.setMinWidth(150);
        btnCadastrar.setMinHeight(50);

        btnRemover.setMinWidth(150);
        btnRemover.setMinHeight(50);

        btnVoltarInicio.setMinWidth(450);
        btnVoltarInicio.setMinHeight(50);

        btnCadastrar.setStyle("-fx-background-color: #F79516;");
        btnRemover.setStyle("-fx-background-color: #F79516;");
        btnVoltarInicio.setStyle("-fx-background-color: #F79516;");

        hbox.getChildren().addAll(btnCadastrar, btnRemover);

        List<Item> itens = ItemDAO.listarItens();
        ObservableList<Item> itensListados = FXCollections.observableArrayList(itens);

        TableColumn<Item, Integer> codigoProdutoColumn = new TableColumn<>("Codigo do Produto");
        codigoProdutoColumn.setCellValueFactory(cellData -> cellData.getValue().codigoProdutoProperty());

        TableColumn<Item, String> dataFabColumn = new TableColumn<>("Data de Fabricação");
        dataFabColumn.setCellValueFactory(cellData -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return cellData.getValue().dataFabProperty().asString(dateFormat.toPattern());
        });

        TableColumn<Item, String> dataValColumn = new TableColumn<>("Data de Validade");
        dataValColumn.setCellValueFactory(cellData -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return cellData.getValue().dataValProperty().asString(dateFormat.toPattern());
        });

        TableColumn<Item, Float> pesoColumn = new TableColumn<>("Peso");
        pesoColumn.setCellValueFactory(cellData -> cellData.getValue().pesoProperty());

        TableColumn<Item, String> loteColumn = new TableColumn<>("Lote");
        loteColumn.setCellValueFactory(cellData -> cellData.getValue().loteProperty());

        TableColumn<Item, Integer> quantidadeColumn = new TableColumn<>("Quantidade");
        quantidadeColumn.setCellValueFactory(cellData -> cellData.getValue().quantidadeProperty());

        //TableView<Item> tableView = null;

        TableView<Item> tableView = new TableView<>();
        tableView.getColumns().addAll(codigoProdutoColumn, dataFabColumn, dataValColumn, pesoColumn, loteColumn, quantidadeColumn);

        //loteColumn.prefWidthProperty().bind(tableView.widthProperty().divide(5));
        //dataValColumn.prefWidthProperty().bind(tableView.widthProperty().divide(5));
        //dataFabColumn.prefWidthProperty().bind(tableView.widthProperty().divide(5));
        //pesoColumn.prefWidthProperty().bind(tableView.widthProperty().divide(5));
        //quantidadeColumn.prefWidthProperty().bind(tableView.widthProperty().divide(5));

        double larguraColuna = 1.0 / tableView.getColumns().size();
        tableView.getColumns().forEach(coluna -> coluna.setPrefWidth(tableView.getWidth() * larguraColuna));

        tableView.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            tableView.getColumns().forEach(coluna -> coluna.setPrefWidth(newWidth.doubleValue() * larguraColuna));
        });

        tableView.setItems(itensListados);

        VBox vbox = new VBox();
        Insets padding = new Insets(20);
        vbox.setPadding(padding);
        vbox.getChildren().addAll(hbox, tableView, btnVoltarInicio);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 500);
        stage.setTitle("Supermercado - Itens");
        stage.setScene(scene);
        stage.show();
    }
}
