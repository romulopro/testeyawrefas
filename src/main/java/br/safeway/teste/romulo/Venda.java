package br.safeway.teste.romulo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author romulo
 * executa venda, resumo de produtos, etc
 */

public class Venda {
    private final List<Produto> produtos;

    public Venda() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(ItemVenda itemVenda, int quantidade, BigDecimal precoUnitario) {
        Optional<Produto> produto = produtos.stream()
                .filter(p -> p.getItem().equals(itemVenda))
                .findFirst();
        if (produto.isPresent()) {
            produto.get().atualizaQuantidade(quantidade);
            produto.get().atualizaPrecoUnitario(precoUnitario);
            return;
        }
        produtos.add(new Produto(itemVenda, quantidade, precoUnitario));
    }

    public void removerProduto(ItemVenda itemVenda, int quantidade) {
        Optional<Produto> produto = produtos.stream()
                .filter(p -> p.getItem().equals(itemVenda))
                .findFirst();

        if (produto.isPresent()) {
            produto.get().atualizaQuantidade(quantidade * -1);
            if (produto.get().getQuantidade() <= 0) {
                produtos.remove(produto.get());
            }
        }
    }

    public BigDecimal getValorTotal() {
        BigDecimal valorTotal = BigDecimal.ZERO;
        for (Produto produto : produtos) {
            valorTotal = valorTotal.add(produto.getValorTotal());
        }
        return valorTotal;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void executarVenda(Usuario usuario) {
        imprimirResumoVenda();
        produtos.clear();
    }

    private void imprimirResumoVenda() {
        BigDecimal valorTotalVenda = BigDecimal.ZERO;
        System.out.println();
        System.out.println("Resumo da Venda");
        System.out.println("Produto\t\tQuantidade\tPreço Unitário\tPreço Total");

        for (Produto produto : produtos) {
            System.out.println(
                    produto.getItem().getCodigo() + "\t\t"
                            + produto.getItem().getDescricao() + "\t\t"
                            + produto.getQuantidade()
                            + "\t\t" + produto.getValorTotal());
            valorTotalVenda = valorTotalVenda.add(produto.getValorTotal());
        }
        System.out.println("Valor Total: " + valorTotalVenda);
    }

}
