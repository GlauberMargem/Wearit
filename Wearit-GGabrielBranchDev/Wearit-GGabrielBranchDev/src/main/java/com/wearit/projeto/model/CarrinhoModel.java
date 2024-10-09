package com.wearit.projeto.model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> itens = new ArrayList<>();
    private double total;
    // para calcular o total
    public void calcularTotal() {
        total = itens.stream().mapToDouble(p -> p.getPreco() * p.getQuantidade()).sum();
    }

}