import javafx.application.Application;
import javafx.stage.Stage;

import Views.TelaInicial;
import Views.TelaFuncionarios;
import Views.TelaCadastroFuncionario;
import Views.TelaBuscaFuncionario;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        TelaInicial telaInicial = new TelaInicial();
        telaInicial.show(primaryStage);


        //TelaFuncionarios telaFuncionarios = new TelaFuncionarios();
        //telaFuncionarios.show(primaryStage);

        //TelaCadastroFuncionario telaCadasFuncionario = new TelaCadastroFuncionario();
        //telaCadasFuncionario.show(primaryStage);

        //TelaBuscaFuncionario telaBuscaFuncionario = new TelaBuscaFuncionario();
        //telaBuscaFuncionario.show(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}