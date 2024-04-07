package Views;

import DAO.ItemDAO;
import DAO.ProdutoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Models.Item;
import Models.Produto;

import java.util.List;

public class TelaVendas {

    public void show(Stage stage) {
        HBox hbox = new HBox();
        hbox.setSpacing(30);
        hbox.setAlignment(Pos.CENTER);

        Button btnVender = new Button("FINALIZAR VENDA");
        Button btnAdicionar = new Button("ADICIONAR ITEM");
        Button btnVoltarInicio = new Button("VOLTAR AO INÍCIO");

        btnVender.setOnAction(e -> {

        });

        btnAdicionar.setOnAction(e -> {
            TelaVendaItem telaVendaItem = new TelaVendaItem();
            //telaVendaItem.show(stage);
        });

        btnVoltarInicio.setOnAction(e -> {
            TelaInicial telaInicial = new TelaInicial();
            telaInicial.show(stage);
        });

        btnVender.setMinWidth(150);
        btnVender.setMinHeight(50);

        btnAdicionar.setMinWidth(150);
        btnAdicionar.setMinHeight(50);

        btnVoltarInicio.setMinWidth(450);
        btnVoltarInicio.setMinHeight(50);

        btnVender.setStyle("-fx-background-color: #F79516;");
        btnAdicionar.setStyle("-fx-background-color: #F79516;");
        btnVoltarInicio.setStyle("-fx-background-color: #F79516;");

        Label lblValorTotal = new Label("VALOR TOTAL R$: ");
        Label lblValorTotalValue = new Label("0,00");
        lblValorTotal.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        lblValorTotalValue.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        HBox hbox2 = new HBox(1);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().addAll(lblValorTotal, lblValorTotalValue);

        hbox.getChildren().addAll(btnVender, hbox2, btnAdicionar);

        List<Produto> produtos = ProdutoDAO.listarProdutos();
        ObservableList<Produto> produtosListados = FXCollections.observableArrayList(produtos);

        List<Item> itens = ItemDAO.listarItens();
        ObservableList<Item> itensListados = FXCollections.observableArrayList(itens);

        TableColumn<Produto, String> nomeColumn = new TableColumn<>("Nome");
        nomeColumn.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());

        TableColumn<Produto, String> marcaColumn = new TableColumn<>("Marca");
        marcaColumn.setCellValueFactory(cellData -> cellData.getValue().marcaProperty());

        TableColumn<Item, Integer> codigoProdutoColumn = new TableColumn<>("Codigo do Produto");
        codigoProdutoColumn.setCellValueFactory(cellData -> cellData.getValue().codigoProdutoProperty());

        TableColumn<Produto, String> tipoColumn = new TableColumn<>("Tipo");
        tipoColumn.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());

        TableColumn<Item, Integer> quantidadeColumn = new TableColumn<>("Quantidade");
        quantidadeColumn.setCellValueFactory(cellData -> cellData.getValue().quantidadeProperty());

        TableColumn<Produto, Float> precoColumn = new TableColumn<>("Preco");
        precoColumn.setCellValueFactory(cellData -> cellData.getValue().precoProperty());

        TableView<Produto> produtosTableView = new TableView<>();
        produtosTableView.getColumns().addAll(nomeColumn, marcaColumn, tipoColumn, precoColumn);

        TableView<Item> itensTableView = new TableView<>();
        itensTableView.getColumns().addAll(codigoProdutoColumn, quantidadeColumn);;

        /*double larguraColuna = 1.0 / tableView.getColumns().size();
        tableView.getColumns().forEach(coluna -> coluna.setPrefWidth(tableView.getWidth() * larguraColuna));

        tableView.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            tableView.getColumns().forEach(coluna -> coluna.setPrefWidth(newWidth.doubleValue() * larguraColuna));
        });*/

        produtosTableView.setItems(produtosListados);
        itensTableView.setItems(itensListados);

        VBox vbox = new VBox();
        Insets padding = new Insets(20);
        vbox.setPadding(padding);
        vbox.getChildren().addAll(hbox, produtosTableView, itensTableView, btnVoltarInicio);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 500);
        stage.setTitle("Supermercado - Vendas");
        stage.setScene(scene);
        stage.show();
    }
}
