package com.wearit.projeto.dto;

import com.wearit.projeto.entity.ItemCarrinhoEntity;

public class ItemCarrinhoDTO {

    private Long id;
    private ProdutoDTO produto;
    private int quantidade;

    public ItemCarrinhoDTO(ItemCarrinhoEntity item) {
        this.id = item.getId();
        this.produto = new ProdutoDTO(item.getProduto());
        this.quantidade = item.getQuantidade();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
