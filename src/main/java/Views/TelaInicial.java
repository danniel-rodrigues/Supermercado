package Views;


import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
// Adicionar imagem
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TelaInicial {
    public void show(Stage primaryStage) {
        VBox vbox;
        Scene scene;

        // Adicionando uma imagem
        Image imgCarrinho = new Image("assets/images/carrinho.png");
        ImageView logo = new ImageView(imgCarrinho);
        logo.setFitWidth(200);
        logo.setFitHeight(200);
        logo.setPreserveRatio(true); // Manter proporção da imagem

        // Criando botões
        Button btnEstoque = new Button("ESTOQUE");
        Button btnProduto = new Button("PRODUTO");
        Button btnVenda = new Button("VENDA");
        Button btnItem = new Button("ITEM");
        Button btnFornecimento = new Button("FORNECIMENTO");

        Button btnFuncionarios = new Button("FUNCIONÁRIOS");
        Button btnCaixa = new Button("CAIXA");
        Button btnFornecedor = new Button("FORNECEDOR");

        btnFuncionarios.setOnAction(e -> {
            TelaFuncionarios telaFuncionarios = new TelaFuncionarios();
            telaFuncionarios.show(primaryStage);
        });

        btnFornecedor.setOnAction(e -> {
            TelaFornecedores telaFornecedores = new TelaFornecedores();
            telaFornecedores.show(primaryStage);
        });

        btnProduto.setOnAction(e -> {
            TelaProdutos telaProdutos = new TelaProdutos();
            telaProdutos.show(primaryStage);
        });

        btnFornecimento.setOnAction(e -> {
            TelaFornecimento telaFornecimento = new TelaFornecimento();
            telaFornecimento.show(primaryStage);
        });

        btnEstoque.setOnAction(e -> {
            TelaEstoque telaEstoque = new TelaEstoque();
            telaEstoque.show(primaryStage);
        });

	    btnCaixa.setOnAction(e -> {
            TelaCaixa telaCaixa = new TelaCaixa();
            telaCaixa.show();
        });

        btnItem.setOnAction(e -> {
            TelaItens telaItens = new TelaItens();
            telaItens.show(primaryStage);
        });

        btnVenda.setOnAction(e -> {
            TelaVendas telaVendas = new TelaVendas();
            telaVendas.show(primaryStage);
        });




        // Adicionando ícones aos botões
        Image estoqueIcon = new Image("assets/images/icons/estoque.png");
        ImageView estoqueIconView = new ImageView(estoqueIcon);
        estoqueIconView.setFitWidth(20);
        estoqueIconView.setFitHeight(20);
        btnEstoque.setGraphic(estoqueIconView);

        Image produtoIcon = new Image("assets/images/icons/produto.png");
        ImageView produtoIconView = new ImageView(produtoIcon);
        produtoIconView.setFitWidth(20);
        produtoIconView.setFitHeight(20);
        btnProduto.setGraphic(produtoIconView);

        Image vendaIcon = new Image("assets/images/icons/venda.png");
        ImageView VendaIconView = new ImageView(vendaIcon);
        VendaIconView.setFitWidth(20);
        VendaIconView.setFitHeight(20);
        btnVenda.setGraphic(VendaIconView);

        Image itemIcon = new Image("assets/images/icons/item.png");
        ImageView itemIconView = new ImageView(itemIcon);
        itemIconView.setFitWidth(20);
        itemIconView.setFitHeight(20);
        btnItem.setGraphic(itemIconView);

        Image fornecimentoIcon = new Image("assets/images/icons/fornecimento.png");
        ImageView fornecimentoIconView = new ImageView(fornecimentoIcon);
        fornecimentoIconView.setFitWidth(20);
        fornecimentoIconView.setFitHeight(20);
        btnFornecimento.setGraphic(fornecimentoIconView);

        Image funcionariosIcon = new Image("assets/images/icons/funcionarios.png");
        ImageView funcionariosIconView = new ImageView(funcionariosIcon);
        funcionariosIconView.setFitWidth(20);
        funcionariosIconView.setFitHeight(20);
        btnFuncionarios.setGraphic(funcionariosIconView);

        Image caixaIcon = new Image("assets/images/icons/caixa.png");
        ImageView caixaIconView = new ImageView(caixaIcon);
        caixaIconView.setFitWidth(20);
        caixaIconView.setFitHeight(20);
        btnCaixa.setGraphic(caixaIconView);

        Image fornecedorIcon = new Image("assets/images/icons/fornecedor.png");
        ImageView fornecedorIconView = new ImageView(fornecedorIcon);
        fornecedorIconView.setFitWidth(20);
        fornecedorIconView.setFitHeight(20);
        btnFornecedor.setGraphic(fornecedorIconView);




        // Definindo a largura mínima dos botões
        btnEstoque.setMinWidth(250);
        btnEstoque.setMinHeight(50);
        btnProduto.setMinWidth(250);
        btnProduto.setMinHeight(50);

        btnVenda.setMinWidth(250);
        btnVenda.setMinHeight(50);
        btnItem.setMinWidth(250);
        btnItem.setMinHeight(50);


        btnFornecimento.setMinWidth(250);
        btnFornecimento.setMinHeight(50);


        btnFuncionarios.setMinWidth(250);
        btnFuncionarios.setMinHeight(50);
        btnCaixa.setMinWidth(250);
        btnCaixa.setMinHeight(50);

        btnFornecedor.setMinWidth(250);
        btnFornecedor.setMinHeight(50);

        // Definindo o background dos botões
        btnEstoque.setStyle("-fx-background-color: #F79516;");
        btnProduto.setStyle("-fx-background-color: #F79516;");

        btnVenda.setStyle("-fx-background-color: #F79516;");
        btnItem.setStyle("-fx-background-color: #F79516;");

        btnFornecimento.setStyle("-fx-background-color: #F79516;");

        btnFuncionarios.setStyle("-fx-background-color: #F79516;");
        btnCaixa.setStyle("-fx-background-color: #F79516;");

        btnFornecedor.setStyle("-fx-background-color: #F79516;");

        // Configurando o layout da grid de botões
        GridPane buttonGrid = new GridPane();
        buttonGrid.add(btnEstoque, 0, 0);
        buttonGrid.add(btnVenda, 0, 1);
        buttonGrid.add(btnFornecimento, 0, 2);
        buttonGrid.add(btnFuncionarios, 0, 3);
        buttonGrid.add(btnProduto, 1, 0); // Segunda coluna
        buttonGrid.add(btnItem, 1, 1);
        buttonGrid.add(btnFornecedor, 1, 2);
        buttonGrid.add(btnCaixa, 1, 3);

        buttonGrid.setAlignment(Pos.CENTER);
        buttonGrid.setHgap(10);
        buttonGrid.setVgap(10);



        // Configurando o layout da VBox para conter a imagem e a grid de botões
        vbox = new VBox(logo, buttonGrid);
        vbox.setSpacing(20);
        vbox.setAlignment(Pos.CENTER);

        // Definindo o background color para branco
        vbox.setStyle("-fx-background-color: white;");

        scene = new Scene(vbox, 600, 500);

        primaryStage.setTitle("Supermercado - Tela Inicial");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}




