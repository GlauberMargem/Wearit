package com.wearit.projeto.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "WEA_CARRINHO")
public class CarrinhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "carrinho_id")
    private List<ItemCarrinhoEntity> itens;

    private Long usuarioId; // ID do usuário associado ao carrinho

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemCarrinhoEntity> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinhoEntity> itens) {
        this.itens = itens;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    // Método para calcular o total do carrinho
    public double getTotal() {
        return itens.stream().mapToDouble(ItemCarrinhoEntity::getTotalItem).sum();
    }
}
