package Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaEstoque {
    public void show(Stage stage) {
        // Criando botão para voltar ao menu inicial
        Button btnVoltarInicio = new Button("VOLTAR AO INÍCIO");

        // Definindo a ação de click do botão
        btnVoltarInicio.setOnAction(e -> {
            TelaInicial telaInicial = new TelaInicial();
            telaInicial.show(stage);
        });

        // Definindo a largura mínima dos botões
        btnVoltarInicio.setMinWidth(450);
        btnVoltarInicio.setMinHeight(50);

        // Definindo o background do botão
        btnVoltarInicio.setStyle("-fx-background-color: #F79516;");

        TableView<String> tableView = new TableView<>();

        TableColumn<String, String> columnNome = new TableColumn<>("Nome");
        TableColumn<String, String> columnMarca = new TableColumn<>("Marca");
        TableColumn<String, String> columnCodigo = new TableColumn<>("Código");
        TableColumn<String, String> columnQtdItens = new TableColumn<>("Qtd. de Itens");
        TableColumn<String, String> columnValorTotal = new TableColumn<>("Valor Total");

        // Adicionando as colunas à TableView
        tableView.getColumns().addAll(columnNome, columnMarca, columnCodigo, columnQtdItens, columnValorTotal);

        // Adicionando itens de exemplo à TableView
        tableView.getItems().addAll(
                "Item1, Marca1, 123, 10, 100",
                "Item2, Marca2, 456, 20, 200",
                "Item3, Marca3, 789, 30, 300"
        );

        // Redimensionando as colunas para preencher o espaço disponível igualmente
        double larguraColuna = 1.0 / tableView.getColumns().size();
        tableView.getColumns().forEach(coluna -> coluna.setPrefWidth(tableView.getWidth() * larguraColuna));

        // Adicionando listener para redimensionar as colunas quando a tabela for redimensionada
        tableView.widthProperty().addListener((obs, oldWidth, newWidth) -> {
            tableView.getColumns().forEach(coluna -> coluna.setPrefWidth(newWidth.doubleValue() * larguraColuna));
        });

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(tableView, btnVoltarInicio);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 500);
        stage.setTitle("Supermercado - Estoque");
        stage.setScene(scene);
        stage.show();
    }
}
