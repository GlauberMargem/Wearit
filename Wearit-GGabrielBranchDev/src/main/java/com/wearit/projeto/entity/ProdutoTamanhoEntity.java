package com.wearit.projeto.entity;

import com.wearit.projeto.dto.ProdutoTamanhoDTO;
import org.springframework.beans.BeanUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "WEA_PRODUTO_TAMANHO")
public class ProdutoTamanhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long protam_id; // Identificador único do relacionamento produto-tamanho

    @Column(nullable = false)
    private Long pro_id; // FK para o produto

    @Column(nullable = false)
    private Long tam_id; // FK para o tamanho

    // Construtor que aceita um DTO
    public ProdutoTamanhoEntity(ProdutoTamanhoDTO produtoTamanho) {
        BeanUtils.copyProperties(produtoTamanho, this);
    }

    // Construtor padrão
    public ProdutoTamanhoEntity() {
    }

    // Getters e Setters
    public Long getProtam_id() {
        return protam_id;
    }

    public void setProtam_id(Long protam_id) {
        this.protam_id = protam_id;
    }

    public Long getPro_id() {
        return pro_id;
    }

    public void setPro_id(Long pro_id) {
        this.pro_id = pro_id;
    }

    public Long getTam_id() {
        return tam_id;
    }

    public void setTam_id(Long tam_id) {
        this.tam_id = tam_id;
    }
}
