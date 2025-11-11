package com.tanuri.commerce.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    private Produto produtoValido;

    @BeforeEach
    void setup() {
        // Produto válido para isolar o comportamento do Pedido
        produtoValido = new Produto("Teclado Mecânico", "Teclado RGB", 150.0, 10);
    }

    @Test
    void deveCalcularCorretamenteOValorTotal_comMultiplosItens() {
        ItemPedido item1 = new ItemPedido(produtoValido, 2);
        ItemPedido item2 = new ItemPedido(new Produto("Mousepad", "Grande", 50.0, 5), 1);

        Pedido pedido = new Pedido(item1, item2);

        double totalEsperado = 300.0 + 50.0;
        assertEquals(totalEsperado, pedido.getTotal(), 0.001, "O total deve ser a soma dos subtotais.");
    }

    @Test
    void deveLancarExcecao_quandoCriadoSemItens() {
        assertThrows(IllegalArgumentException.class,
                () -> new Pedido(Collections.emptyList()),
                "Um pedido não pode ser criado sem itens.");
    }
}


