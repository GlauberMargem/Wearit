package com.wearit.projeto.dto;

import org.springframework.beans.BeanUtils;

import com.wearit.projeto.entity.ProdutoEntity;

public class ProdutoDTO {

    private Long pro_id; // Identificador único do produto
    private String pro_nome; // Nome do produto
    private Double pro_preco; // Preço do produto
    private Long cat_id; // FK para a categoria do produto
    private Long lin_id; // FK para a linha do produto

    // Construtor que aceita uma entidade
    public ProdutoDTO(ProdutoEntity produto) {
        BeanUtils.copyProperties(produto, this); // Copia propriedades da entidade para o DTO
    }

    // Construtor padrão
    public ProdutoDTO() {
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
