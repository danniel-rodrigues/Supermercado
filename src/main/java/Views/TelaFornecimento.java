package Views;

import DAO.RemessaDAO;
import Models.Remessa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import java.util.List;

public class TelaFornecimento {
    public void show(Stage stage) {
        HBox hbox = new HBox(); // Criando um HBox
        hbox.setSpacing(10); // Espaçamento entre os botões
        hbox.setAlignment(Pos.CENTER);
        // Adicionando botões ao HBox
        Button btnCadastrar = new Button("CADASTRAR");
//        Button btnAlterarRemessa = new Button("ALTERAR REMESSA");
        Button btnVoltarInicio = new Button("VOLTAR AO INÍCIO");

        // Definindo a ação dos botões
        btnCadastrar.setOnAction(e -> {
            TelaCadastroRemessa telaCadastroRemessa = new TelaCadastroRemessa();
            telaCadastroRemessa.show(stage);
        });

        btnVoltarInicio.setOnAction(e -> {
            TelaInicial telaInicial = new TelaInicial();
            telaInicial.show(stage);
        });

        // Definindo a largura mínima dos botões
        btnCadastrar.setMinWidth(150);
        btnCadastrar.setMinHeight(50);

        btnVoltarInicio.setMinWidth(450);
        btnVoltarInicio.setMinHeight(50);

        // Definindo o background dos botões
        btnCadastrar.setStyle("-fx-background-color: #F79516;");
        btnVoltarInicio.setStyle("-fx-background-color: #F79516;");

        hbox.getChildren().addAll(btnCadastrar);

        // Criando uma lista de remessas
        List<Remessa> remessas = RemessaDAO.listarRemessas();

        ObservableList<Remessa> remessasListadas = FXCollections.observableArrayList(remessas);

        // Criando as colunas da TableView
        TableColumn<Remessa, String> dataEnvioColumn = new TableColumn<>("Data de Envio");
        dataEnvioColumn.setCellValueFactory(cellData -> cellData.getValue().dataEnvio());

        TableColumn<Remessa, String> dataRecebimentoColumn = new TableColumn<>("Data de Recebimento");
        dataRecebimentoColumn.setCellValueFactory(cellData -> cellData.getValue().dataRecebimento());

        TableView<Remessa> tableView = new TableView<>();
        tableView.getColumns().addAll(dataEnvioColumn, dataRecebimentoColumn);

        // Redimensionando as colunas para preencher o espaço disponível igualmente
        double larguraColuna = 1.0 / tableView.getColumns().size();
        tableView.getColumns().forEach(coluna -> coluna.setPrefWidth(tableView.getWidth() * larguraColuna));

        // Adicionando listener para redimensionar as colunas quando a tabela for redimensionada
        tableView.widthProperty().addListener((obs, oldWidth, newWidth) -> tableView.getColumns().forEach(coluna -> coluna.setPrefWidth(newWidth.doubleValue() * larguraColuna)));

        // Definindo os itens da TableView
        tableView.setItems(remessasListadas);

        VBox vbox = new VBox();
        // Definindo o espaçamento interno
        Insets padding = new Insets(20);
        vbox.setPadding(padding);
        vbox.getChildren().addAll(hbox, tableView, btnVoltarInicio);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 500);
        stage.setTitle("Supermercado - Remessas");
        stage.setScene(scene);
        stage.show();
    }
}
