package com.wearit.projeto.entity;

import com.wearit.projeto.dto.ProdutoDTO;
import org.springframework.beans.BeanUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "WEA_PRODUTO")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pro_id; // Identificador único do produto

    @Column(nullable = false)
    private String pro_nome; // Nome do produto

    @Column(nullable = false)
    private Double pro_preco; // Preço do produto

    @Column(nullable = false)
    private Long cat_id; // FK para a categoria do produto

    @Column(nullable = false)
    private Long lin_id; // FK para a linha do produto

    // Construtor que aceita um DTO
    public ProdutoEntity(ProdutoDTO produto) {
        BeanUtils.copyProperties(produto, this);
    }

    // Construtor padrão
    public ProdutoEntity() {
    }

    // Getters e Setters
    public Long getPro_id() {
        return pro_id;
    }

    public void setPro_id(Long pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_nome() {
        return pro_nome;
    }

    public void setPro_nome(String pro_nome) {
        this.pro_nome = pro_nome;
    }

    public Double getPro_preco() {
        return pro_preco;
    }

    public void setPro_preco(Double pro_preco) {
        this.pro_preco = pro_preco;
    }

    public Long getCat_id() {
        return cat_id;
    }

    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }

    public Long getLin_id() {
        return lin_id;
    }

    public void setLin_id(Long lin_id) {
        this.lin_id = lin_id;
    }
}
