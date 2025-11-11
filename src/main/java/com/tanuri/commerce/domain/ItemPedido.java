package com.tanuri.commerce.domain;

public class ItemPedido {

    private final Produto produto;
    private final int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto no item do pedido não pode ser nulo.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade do item deve ser positiva.");
        }

        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Calcula o subtotal deste item: Preço unitário * Quantidade.
     */
    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }
}
