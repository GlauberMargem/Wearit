package com.wearit.projeto.entity;

import com.wearit.projeto.dto.ItemPedidoDTO;
import org.springframework.beans.BeanUtils;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "WEA_ITEM_PEDIDO")
public class ItemPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id; // Identificador único do item de pedido

    @ManyToOne
    @JoinColumn(name = "PCO_ID", nullable = false)
    private ProdutoCorEntity produtoCor; // FK para WEA_PRODUTO_COR

    @ManyToOne
    @JoinColumn(name = "PTO_ID", nullable = false)
    private ProdutoTamanhoEntity produtoTamanho; // FK para WEA_PRODUTO_TAMANHO

    @ManyToOne
    @JoinColumn(name = "PL_ID", nullable = false)
    private ProdutoLinhaEntity produtoLinha; // FK para WEA_PRODUTO_LINHA

    @ManyToOne
    @JoinColumn(name = "USU_ID", nullable = false)
    private UsuarioEntity usuario; // FK para WEA_USUARIO

    @Column(nullable = false)
    private int ite_quantidade; // Quantidade do item no pedido

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal ite_preco_final; // Preço final do item

    @Column(nullable = false)
    private LocalDateTime ite_data_pedido; // Data do pedido

    // Construtor que aceita um DTO
    public ItemPedidoEntity(ItemPedidoDTO itemPedidoDTO) {
        BeanUtils.copyProperties(itemPedidoDTO, this);
    }

    // Construtor padrão
    public ItemPedidoEntity() {
    }

    // Getters e Setters
    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public ProdutoCorEntity getProdutoCor() {
        return produtoCor;
    }

    public void setProdutoCor(ProdutoCorEntity produtoCor) {
        this.produtoCor = produtoCor;
    }

    public ProdutoTamanhoEntity getProdutoTamanho() {
        return produtoTamanho;
    }

    public void setProdutoTamanho(ProdutoTamanhoEntity produtoTamanho) {
        this.produtoTamanho = produtoTamanho;
    }

    public ProdutoLinhaEntity getProdutoLinha() {
        return produtoLinha;
    }

    public void setProdutoLinha(ProdutoLinhaEntity produtoLinha) {
        this.produtoLinha = produtoLinha;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public int getIte_quantidade() {
        return ite_quantidade;
    }

    public void setIte_quantidade(int ite_quantidade) {
        this.ite_quantidade = ite_quantidade;
    }

    public BigDecimal getIte_preco_final() {
        return ite_preco_final;
    }

    public void setIte_preco_final(BigDecimal ite_preco_final) {
        this.ite_preco_final = ite_preco_final;
    }

    public LocalDateTime getIte_data_pedido() {
        return ite_data_pedido;
    }

    public void setIte_data_pedido(LocalDateTime ite_data_pedido) {
        this.ite_data_pedido = ite_data_pedido;
    }
}
