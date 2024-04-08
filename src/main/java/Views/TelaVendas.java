package Views;

import DAO.VendaDAO;
import Models.Venda;
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

import java.util.List;

public class TelaVendas {
    private  Label lblValorTotalValue;
    private static ObservableList<Venda> carrinho = FXCollections.observableArrayList();

    public void show(Stage stage) {
        HBox hbox = new HBox();
        hbox.setSpacing(30);
        hbox.setAlignment(Pos.CENTER);

        Button btnVender = new Button("FINALIZAR VENDA");
        Button btnAdicionar = new Button("ADICIONAR ITEM");
        Button btnVoltarInicio = new Button("VOLTAR AO INÍCIO");

        btnVender.setOnAction(e -> {
            VendaDAO.salvarVenda(); // Implementar função de salvar venda no banco
            carrinho.clear(); // Limpa o carrinho de compras
        });

        btnAdicionar.setOnAction(e -> {
            TelaVendaItem telaVendaItem = new TelaVendaItem();
            telaVendaItem.show(stage);
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
        lblValorTotalValue = new Label("0,00");
        this.setLblValorTotalValue(calcularSomaValorTotalCarrinho());
        lblValorTotal.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        lblValorTotalValue.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        HBox hbox2 = new HBox(1);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().addAll(lblValorTotal, lblValorTotalValue);

        hbox.getChildren().addAll(btnVender, hbox2, btnAdicionar);

        TableColumn<Venda, String> nomeColumn = new TableColumn<>("Nome");
        nomeColumn.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());

        TableColumn<Venda, String> marcaColumn = new TableColumn<>("Marca");
        marcaColumn.setCellValueFactory(cellData -> cellData.getValue().marcaProperty());

        TableColumn<Venda, Integer> codigoProdutoColumn = new TableColumn<>("Codigo do Produto");
        codigoProdutoColumn.setCellValueFactory(cellData -> cellData.getValue().codigoProdutoProperty());

        TableColumn<Venda, String> tipoColumn = new TableColumn<>("Tipo");
        tipoColumn.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());

        TableColumn<Venda, Integer> quantidadeColumn = new TableColumn<>("Quantidade");
        quantidadeColumn.setCellValueFactory(cellData -> cellData.getValue().quantidadeProperty());

        TableColumn<Venda, Float> precoColumn = new TableColumn<>("Preco");
        precoColumn.setCellValueFactory(cellData -> cellData.getValue().precoProperty());

        TableView<Venda> tableView = new TableView<>();
        tableView.getColumns().addAll(nomeColumn, marcaColumn, codigoProdutoColumn, tipoColumn, quantidadeColumn, precoColumn);

        double larguraColuna = 1.0 / tableView.getColumns().size();
        tableView.getColumns().forEach(coluna -> coluna.setPrefWidth(tableView.getWidth() * larguraColuna));

        tableView.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            tableView.getColumns().forEach(coluna -> coluna.setPrefWidth(newWidth.doubleValue() * larguraColuna));
        });

        //adicionarItemAoCarrinho(new Venda("Produto1", "Marca1", 123, "Tipo1", 5, 10.5f));

        // Exibir os itens do carrinho na tabela
        tableView.setItems(carrinho);

        VBox vbox = new VBox();
        Insets padding = new Insets(20);
        vbox.setPadding(padding);
        vbox.getChildren().addAll(hbox, tableView, btnVoltarInicio);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 500);
        stage.setTitle("Supermercado - Vendas");
        stage.setScene(scene);
        stage.show();
    }

    public static void adicionarItemAoCarrinho(Venda venda) {
        carrinho.add(venda);
    }

    public void setLblValorTotalValue(String lblValorTotalValue) {
        this.lblValorTotalValue = new Label(lblValorTotalValue);
    }

    private static String calcularSomaValorTotalCarrinho() {
        float soma = 0;
        for (Venda venda : carrinho) {
            soma += venda.getValorTotal();
        }
        return String.valueOf(soma);
    }
}
