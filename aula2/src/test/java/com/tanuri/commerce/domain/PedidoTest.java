package com.tanuri.commerce.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;

// Assumimos que Produto é a única classe que já existe e é válida.

public class PedidoTest {
    
    private Produto produtoValido;

    @BeforeEach
    void setup() {
        // Usamos um produto com dados válidos para isolar o teste do Pedido
        this.produtoValido = new Produto("Teclado Mecânico", "Teclado RGB", 150.0, 10);
    }

    // --- TESTE 1 (Regra de Negócio: Cálculo) ---
    // Este teste deve falhar pois ItemPedido.getSubtotal() e Pedido.getTotal() não existem.
    @Test
    void deveCalcularCorretamenteOValorTotal_comMultiplosItens() {
        // ARRANGE
        // A classe ItemPedido ainda não existe, resultando em erro de compilação.
        ItemPedido item1 = new ItemPedido(produtoValido, 2); 
        ItemPedido item2 = new ItemPedido(new Produto("Mousepad", "Grande", 50.0, 5), 1);
        
        // ACT
        // A classe Pedido ainda não existe, resultando em erro de compilação.
        Pedido pedido = new Pedido(item1, item2); 
        
        // ASSERT
        double totalEsperado = 300.0 + 50.0;
        assertEquals(totalEsperado, pedido.getTotal(), 0.001, "O total deve ser a soma dos subtotais.");
    }
    
    // --- TESTE 2 (Regra de Negócio: Invariante de Criação) ---
    // Este teste falharia com erro de compilação e, depois, com erro de lógica.
    @Test
    void deveLancarExcecao_quandoCriadoSemItens() {
        // ACT & ASSERT
        assertThrows(IllegalArgumentException.class, () -> {
            // Tentativa de criar o Pedido com lista vazia
            new Pedido(Collections.emptyList()); 
        }, "Um pedido não pode ser criado sem itens.");
    }
}