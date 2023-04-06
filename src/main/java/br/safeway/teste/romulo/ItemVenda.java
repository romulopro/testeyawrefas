package br.safeway.teste.romulo;

public class ItemVenda {

    private final Long codigo;
    private final String descricao;


    public ItemVenda(Long codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }


    public String getDescricao() {
        return descricao;
    }

    public Long getCodigo() {
        return codigo;
    }
}
