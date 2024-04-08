import javafx.application.Application;
import javafx.stage.Stage;

import Views.TelaInicial;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.show(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}