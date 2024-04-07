package Auxiliar;

import DAO.ItemDAO;
import DAO.ProdutoDAO;
import Models.Item;
import Models.Produto;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class ExibirEstoque {
    private String nomeItem;
    private String marcaItem;
    private Integer codigoItem;
    private Integer qtdItem;
    private Float valorItem;

    public List<ExibirEstoque> MontarEstoque() {
        List<Produto> produtos = ProdutoDAO.listarProdutos();
        List<ExibirEstoque> estoque = new ArrayList<>();

        for(Produto produto : produtos){
            ExibirEstoque exibirEstoque = new ExibirEstoque();
            exibirEstoque.setNomeItem(produto.getNome());
            exibirEstoque.setMarcaItem(produto.getMarca());
            exibirEstoque.setCodigoItem(produto.getCodigo());
            Integer id = ItemDAO.buscarIdPeloCodigo(exibirEstoque.getCodigoItem());
            Item item = ItemDAO.buscarItemPeloIdProduto(id);
            exibirEstoque.setQtdItem(item.getQuantidade());
            exibirEstoque.setValorItem(produto.getPreco());

            estoque.add(exibirEstoque);
        }

        return estoque;
    }

    // Getters e setters para os atributos
    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getMarcaItem() {
        return marcaItem;
    }

    public void setMarcaItem(String marcaItem) {
        this.marcaItem = marcaItem;
    }

    public Integer getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(Integer codigoItem) {
        this.codigoItem = codigoItem;
    }

    public Integer getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(Integer qtdItem) {
        this.qtdItem = qtdItem;
    }

    public Float getValorItem() {
        return valorItem;
    }

    public void setValorItem(Float valorItem) {
        this.valorItem = valorItem;
    }

    // Getters para propriedades observáveis
    public StringProperty nomeItemProperty() {
        return new SimpleStringProperty(nomeItem);
    }

    public StringProperty marcaItemProperty() {
        return new SimpleStringProperty(marcaItem);
    }

    public StringProperty codigoItemProperty() {
        return new SimpleStringProperty(Integer.toString(codigoItem));
    }

    public StringProperty qtdItemProperty() {
        return new SimpleStringProperty(Integer.toString(qtdItem));
    }

    public StringProperty valorTotalProperty() {
        return new SimpleStringProperty("R$ " + Float.toString(qtdItem * valorItem));
    }
}
