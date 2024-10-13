package com.wearit.projeto.dto;

import com.wearit.projeto.entity.CarrinhoEntity;
import java.util.List;
import java.util.stream.Collectors;

public class CarrinhoDTO {

    private Long id;
    private List<ItemCarrinhoDTO> itens;
    private double total;

    public CarrinhoDTO(CarrinhoEntity carrinho) {
        this.id = carrinho.getId();
        this.itens = carrinho.getItens().stream()
                              .map(ItemCarrinhoDTO::new)
                              .collect(Collectors.toList());
        this.total = carrinho.getTotal();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemCarrinhoDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinhoDTO> itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
