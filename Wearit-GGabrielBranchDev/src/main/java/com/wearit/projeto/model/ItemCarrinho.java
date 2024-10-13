package com.wearit.projeto.model;

import com.wearit.projeto.dto.ProdutoDTO;

public class ItemCarrinho {
    private ProdutoDTO produto;
    private int quantidade;

    public ItemCarrinho(ProdutoDTO produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
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

    public double getTotalItem() {
        return produto.getPro_preco() * quantidade;
    }
}
