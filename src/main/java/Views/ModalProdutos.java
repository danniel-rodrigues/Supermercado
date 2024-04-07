package Views;

import DAO.ProdutoDAO;
import Models.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.List;

public class ModalProdutos {
    public void abrirModal() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Modal Exemplo");

        TableView<Produto> tabelaProdutos = criarTabelaProdutos();

        VBox vbox = new VBox();
        vbox.getChildren().add(tabelaProdutos);

        Scene scene = new Scene(vbox, 600, 400);
        stage.setScene(scene);
        stage.showAndWait();
    }

    private TableView<Produto> criarTabelaProdutos() {
        List<Produto> produtos = ProdutoDAO.listarProdutos();
        ObservableList<Produto> produtosListados = FXCollections.observableArrayList(produtos);

        // Criando as colunas da TableView
        TableColumn<Produto, String> nomeColumn = new TableColumn<>("Nome");
        nomeColumn.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());

        TableColumn<Produto, String> marcaColumn = new TableColumn<>("Marca");
        marcaColumn.setCellValueFactory(cellData -> cellData.getValue().marcaProperty());

        TableColumn<Produto, Integer> codigoColumn = new TableColumn<>("Codigo");
        codigoColumn.setCellValueFactory(cellData -> cellData.getValue().codigoProperty());

        TableColumn<Produto, String> tipoColumn = new TableColumn<>("Tipo");
        tipoColumn.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());

        TableColumn<Produto, Float> precoColumn = new TableColumn<>("Preco");
        precoColumn.setCellValueFactory(cellData -> cellData.getValue().precoProperty());

        TableColumn<Produto, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        // Adicionando as colunas à TableView
        TableView<Produto> tableView = new TableView<>();
        tableView.getColumns().addAll(nomeColumn, marcaColumn, codigoColumn, tipoColumn, precoColumn, statusColumn);

        // Definindo os itens da TableView
        tableView.setItems(produtosListados);

        return tableView;
    }
}