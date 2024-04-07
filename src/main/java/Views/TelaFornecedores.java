package Views;

import DAO.FornecedorDAO;
import Models.Fornecedor;
import Models.Produto;
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
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

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
        List<Fornecedor> fornecedores = FornecedorDAO.listarFornecedores();

        ObservableList<Fornecedor> fornecedoresListados = FXCollections.observableArrayList(fornecedores);

        // Criando as colunas da TableView
        TableColumn<Fornecedor, String> nomeColumn = new TableColumn<>("Nome");
        nomeColumn.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());

        TableColumn<Fornecedor, String> CNPJColumn = new TableColumn<>("CNPJ");
        CNPJColumn.setCellValueFactory(cellData -> cellData.getValue().CNPJProperty());

        TableColumn<Fornecedor,String> emailColumn = new TableColumn<>("E-mail");
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        TableColumn<Fornecedor, String> telefoneColumn = new TableColumn<>("Telefone");
        telefoneColumn.setCellValueFactory(cellData -> cellData.getValue().telefoneProperty());

        // Adicionando as colunas à TableView
        TableView<Fornecedor> tableView = new TableView<>();
        tableView.getColumns().addAll(nomeColumn, CNPJColumn, emailColumn, telefoneColumn);


        // Redimensionando as colunas para preencher o espaço disponível igualmente
        double larguraColuna = 1.0 / tableView.getColumns().size();
        tableView.getColumns().forEach(coluna -> coluna.setPrefWidth(tableView.getWidth() * larguraColuna));

        // Adicionando listener para redimensionar as colunas quando a tabela for redimensionada
        tableView.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            tableView.getColumns().forEach(coluna -> coluna.setPrefWidth(newWidth.doubleValue() * larguraColuna));
        });

        // Definindo os itens da TableView
        tableView.setItems(fornecedoresListados);

        VBox vbox = new VBox();
        // Definindo o espaçamento interno
        Insets padding = new Insets(20);
        vbox.setPadding(padding);
        vbox.getChildren().addAll(hbox, tableView, btnVoltarInicio);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 500);
        stage.setTitle("Supermercado - Fornecedores");
        stage.setScene(scene);
        stage.show();
    }
}
