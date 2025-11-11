package com.tanuri.commerce.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pedido {

    private final List<ItemPedido> itens;

    // Construtor varargs — permite criar com new Pedido(item1, item2, ...)
    public Pedido(ItemPedido... itens) {
        this(Arrays.asList(itens));
    }

    // Construtor com lista
    public Pedido(List<ItemPedido> itens) {
        if (itens == null || itens.isEmpty()) {
            throw new IllegalArgumentException("Um pedido deve conter pelo menos um item.");
        }
        this.itens = new ArrayList<>(itens);
    }

    // Retorna uma cópia imutável da lista de itens
    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }

    // Soma todos os subtotais
    public double getTotal() {
        return itens.stream()
                    .mapToDouble(ItemPedido::getSubtotal)
                    .sum();
    }

    // Adicionar novo item dinamicamente (opcional, útil em TDD posterior)
    public void adicionarItem(ItemPedido item) {
        if (item == null) {
            throw new IllegalArgumentException("Item não pode ser nulo.");
        }
        this.itens.add(item);
    }
}


