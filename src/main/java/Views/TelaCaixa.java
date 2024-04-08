package Views;

import Models.Produto;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Models.Item;

import static Views.TelaVendas.calcularSomaValorTotalCarrinho;


public class TelaCaixa {
    public void show() {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Tela de Caixa");

        Label lblValorTotal = new Label("O VALOR TOTAL ACUMULADO É DE R$: ");
        Label lblValorTotalValue = new Label(calcularSomaValorTotalCarrinho());
        lblValorTotal.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        lblValorTotalValue.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");

        HBox hbox2 = new HBox(1);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().addAll(lblValorTotal, lblValorTotalValue);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox2);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 400);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
