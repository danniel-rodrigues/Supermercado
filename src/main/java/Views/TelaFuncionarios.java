package Views;

import Auxiliar.CPF;
import DAO.FuncionarioDAO;
import Models.Funcionario;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import java.util.List;
import java.util.stream.Collectors;


public class TelaFuncionarios {

    public void show(Stage stage) {

        HBox hbox = new HBox(); // Criando um HBox
        hbox.setSpacing(10); // Espaçamento entre os botões
        hbox.setAlignment(Pos.CENTER);
        // Adicionando botões ao HBox
        Button btnCadastrar = new Button("CADASTRAR");
        Button btnAlterarCadastro = new Button("ALTERAR CADASTRO");
        Button btnDemitir = new Button("DEMITIR");
        Button btnVoltarInicio = new Button("VOLTAR AO INÍCIO");
        // Definindo a rota dos botões
        btnCadastrar.setOnAction(e -> {
            TelaCadastroFuncionario telaCadastroFuncionario = new TelaCadastroFuncionario();
            telaCadastroFuncionario.show(stage);
        });
        btnAlterarCadastro.setOnAction(e -> {
            TelaBuscaFuncionario telaBuscaFuncionario = new TelaBuscaFuncionario();
            telaBuscaFuncionario.show(stage);
        });

        btnDemitir.setOnAction(e -> {
            TelaDemitirFuncionario telaDemitirFuncionario = new TelaDemitirFuncionario();
            telaDemitirFuncionario.show(stage);
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

        btnDemitir.setMinWidth(150);
        btnDemitir.setMinHeight(50);

        btnVoltarInicio.setMinWidth(450);
        btnVoltarInicio.setMinHeight(50);

        // Definindo o background dos botões
        btnCadastrar.setStyle("-fx-background-color: #F79516;");
        btnAlterarCadastro.setStyle("-fx-background-color: #F79516;");
        btnDemitir.setStyle("-fx-background-color: #F79516;");
        btnVoltarInicio.setStyle("-fx-background-color: #F79516;");

        hbox.getChildren().addAll(btnCadastrar, btnAlterarCadastro, btnDemitir);

        List<Funcionario> funcionarios = FuncionarioDAO.listarFuncionarios();

        List<Funcionario> funcionariosFormatados = funcionarios.stream()
                .map(funcionario -> {
                    // Aplicar a formatação do CPF ao operador
                    funcionario.setCpf(CPF.formatarCPF(funcionario.getCpf()));
                    funcionario.setNome(funcionario.getNome());
                    return funcionario;
                })
                .collect(Collectors.toList());

        ObservableList<Funcionario> funcionariosListados = FXCollections.observableArrayList(
                funcionariosFormatados
        );

        // Criando as colunas da TableView
        TableColumn<Funcionario, String> nomeColumn = new TableColumn<>("Nome");
        nomeColumn.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());

        TableColumn<Funcionario, String> cpfColumn = new TableColumn<>("CPF");
        cpfColumn.setCellValueFactory(cellData -> cellData.getValue().cpfProperty());

        TableColumn<Funcionario, String> telefoneColumn = new TableColumn<>("Telefone");
        telefoneColumn.setCellValueFactory(cellData -> cellData.getValue().telefoneProperty());

        TableColumn<Funcionario, String> cargoColumn = new TableColumn<>("Cargo");
        cargoColumn.setCellValueFactory(cellData -> cellData.getValue().cargoProperty());

        TableColumn<Funcionario, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        TableColumn<Funcionario, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        TableView<Funcionario> tableView = null;


        // Adicionando as colunas à TableView
        tableView = new TableView<>();
        tableView.getColumns().addAll(nomeColumn, cpfColumn, telefoneColumn, cargoColumn, statusColumn, emailColumn);

        nomeColumn.prefWidthProperty().bind(tableView.widthProperty().divide(6)); // Coluna de nome ocupará  do espaço
        cpfColumn.prefWidthProperty().bind(tableView.widthProperty().divide(6));
        telefoneColumn.prefWidthProperty().bind(tableView.widthProperty().divide(6));
        cargoColumn.prefWidthProperty().bind(tableView.widthProperty().divide(6));
        statusColumn.prefWidthProperty().bind(tableView.widthProperty().divide(6));
        emailColumn.prefWidthProperty().bind(tableView.widthProperty().divide(6));

        // Definindo os itens da TableView
        tableView.setItems(funcionariosListados);

        VBox vbox = new VBox();
        // Definindo o espaçamento interno
        Insets padding = new Insets(20);
        vbox.setPadding(padding);
        vbox.getChildren().addAll(hbox, tableView, btnVoltarInicio);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 500);
        stage.setTitle("Supermercado - Funcionários");
        stage.setScene(scene);
        stage.show();
    }
}
