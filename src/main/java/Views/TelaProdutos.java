package Views;

import Auxiliar.CPF;
import DAO.ProdutoDAO;
import Models.Funcionario;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Models.Produto;

public class TelaProdutos {
    public void show(Stage stage) {
        HBox hbox = new HBox(); // Criando um HBox
        hbox.setSpacing(10); // Espaçamento entre os botões
        hbox.setAlignment(Pos.CENTER);
        // Adicionando botões ao HBox
        Button btnCadastrar = new Button("CADASTRAR");
        Button btnAlterarCadastro = new Button("ALTERAR CADASTRO");
        Button btnDesativar = new Button("DESATIVAR");
        Button btnVoltarInicio = new Button("VOLTAR AO INÍCIO");

        // Definindo a rota dos botões
        btnCadastrar.setOnAction(e -> {
            TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto();
            telaCadastroProduto.show(stage);
        });
        btnAlterarCadastro.setOnAction(e -> {
            TelaBuscarProduto telaBuscarProduto = new TelaBuscarProduto();
            telaBuscarProduto.show(stage);
        });

        btnDesativar.setOnAction(e -> {
            TelaDesativarProduto telaDesativarProduto = new TelaDesativarProduto();
            telaDesativarProduto.show(stage);
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

        btnDesativar.setMinWidth(150);
        btnDesativar.setMinHeight(50);

        btnVoltarInicio.setMinWidth(450);
        btnVoltarInicio.setMinHeight(50);

        // Definindo o background dos botões
        btnCadastrar.setStyle("-fx-background-color: #F79516;");
        btnAlterarCadastro.setStyle("-fx-background-color: #F79516;");
        btnDesativar.setStyle("-fx-background-color: #F79516;");
        btnVoltarInicio.setStyle("-fx-background-color: #F79516;");

        hbox.getChildren().addAll(btnCadastrar, btnAlterarCadastro, btnDesativar);

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

        TableView<Produto> tableView = null;


        // Adicionando as colunas à TableView
        tableView = new TableView<>();
        tableView.getColumns().addAll(nomeColumn, marcaColumn, codigoColumn, tipoColumn, precoColumn);

        nomeColumn.prefWidthProperty().bind(tableView.widthProperty().divide(5)); // Coluna de nome ocupará do espaço
        marcaColumn.prefWidthProperty().bind(tableView.widthProperty().divide(5));
        codigoColumn.prefWidthProperty().bind(tableView.widthProperty().divide(5));
        tipoColumn.prefWidthProperty().bind(tableView.widthProperty().divide(5));
        precoColumn.prefWidthProperty().bind(tableView.widthProperty().divide(5));

        // Definindo os itens da TableView
        tableView.setItems(produtosListados);

        VBox vbox = new VBox();
        // Definindo o espaçamento interno
        Insets padding = new Insets(20);
        vbox.setPadding(padding);
        vbox.getChildren().addAll(hbox, tableView, btnVoltarInicio);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 500);
        stage.setTitle("Supermercado - Produtos");
        stage.setScene(scene);
        stage.show();
    }
}
