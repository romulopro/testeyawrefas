package br.safeway.teste.romulo;

import java.math.BigDecimal;

public class Produto {
    private final ItemVenda item;
    private int quantidade;
    private BigDecimal precoUnitario;

    public Produto(ItemVenda item, int quantidade, BigDecimal precoUnitario) {
        this.item = item;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public BigDecimal getValorTotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    public void atualizaQuantidade(int quantidade) {
        this.quantidade = +quantidade;
    }

    public void atualizaPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public ItemVenda getItem() {
        return item;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
