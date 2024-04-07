package Auxiliar;

import Models.Produto;
import Models.Item;
import DAO.ProdutoDAO;
import DAO.ItemDAO;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ExibirEstoque {
    private String nomeItem;
    private String marcaItem;
    private Integer codigoItem;
    private Integer qtdItem;
    private Float valorTotal;
    private Float valorItem;

    public List<ExibirEstoque> MontarEstoque() {
        List<Produto> produtos = ProdutoDAO.listarProdutos();
        List<ExibirEstoque> estoque = new java.util.ArrayList<>(List.of());

        produtos.forEach(produto -> {
            ExibirEstoque exibirEstoque = new ExibirEstoque();
            exibirEstoque.nomeItem = produto.getNome();
            exibirEstoque.marcaItem = produto.getMarca();
            exibirEstoque.codigoItem = produto.getCodigo();
            exibirEstoque.valorItem = produto.getPreco();

            // pegar a quantidade de items
            Integer itemId = ItemDAO.buscarIdPeloCodigo(codigoItem);
            Item item = ItemDAO.buscarItemPeloIdProduto(itemId);
            exibirEstoque.qtdItem = item.getQuantidade();

            estoque.add(exibirEstoque);
        });

        return estoque;
    }


    public StringProperty nomeItem() {
        return new SimpleStringProperty(nomeItem);
    }

    public StringProperty marcaItem() {
        return new SimpleStringProperty(marcaItem);
    }

    public StringProperty codigoItem() {
        return new SimpleStringProperty(marcaItem);
    }

    public StringProperty qtdItem() {
        return new SimpleStringProperty(Integer.toString(qtdItem));
    }

    public StringProperty valorTotal(){
        return new SimpleStringProperty(Float.toString(qtdItem * valorItem));
    }

}
