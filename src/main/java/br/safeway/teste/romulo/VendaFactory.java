package br.safeway.teste.romulo;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendaFactory {

    Map<String, Venda> vendas;

    public VendaFactory() {
        vendas = new HashMap<>();
    }

    public Venda criar(String cpfCliente) {
        if (vendas.containsKey(cpfCliente)) {
            return vendas.get(cpfCliente);
        }
        Venda venda = new Venda();
        vendas.put(cpfCliente, venda);
        return venda;
    }

    private void imprimirResumoVenda(Usuario usuario) {

        BigDecimal valorTotalVenda = BigDecimal.ZERO;
        List<Produto> produtos = vendas.get(usuario.getCpf()).getProdutos();
        System.out.println("Cliente: " + usuario.getName() + " - " + usuario.getCpf() + " - " + usuario.getEmail());
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
