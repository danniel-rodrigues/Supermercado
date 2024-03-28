package Views;

import Auxiliar.CPF;
import DAO.OperadorCaixaDAO;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import Models.OperadorCaixa;

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

        List<OperadorCaixa> operadorCaixas = OperadorCaixaDAO.listarOperadores();

        List<OperadorCaixa> operadoresFormatados = operadorCaixas.stream()
                .map(operador -> {
                    // Aplicar a formatação do CPF ao operador
                    operador.setCpf(CPF.formatarCPF(operador.getCpf()));
                    return operador;
                })
                .collect(Collectors.toList());



        ObservableList<OperadorCaixa> funcionarios = FXCollections.observableArrayList(
                operadorCaixas
        );

        // Criando a ListView e passando a lista de funcionários
        ListView<OperadorCaixa> listView = new ListView<>(funcionarios);

        // Definindo a altura de cada item da ListView
        listView.setFixedCellSize(40);


        VBox vbox = new VBox();
        // Definindo o espaçamento interno
        Insets padding = new Insets(20);
        vbox.setPadding(padding);
        vbox.getChildren().addAll(hbox, listView, btnVoltarInicio);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 600, 500);
        stage.setTitle("SuperMercado - Funcionários");
        stage.setScene(scene);
        stage.show();
    }
}



