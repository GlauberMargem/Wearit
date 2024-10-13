package com.wearit.projeto.dto;

import org.springframework.beans.BeanUtils;

import com.wearit.projeto.entity.ProdutoTamanhoEntity;

public class ProdutoTamanhoDTO {

    private Long protam_id; // Identificador único do relacionamento produto-tamanho
    private Long pro_id; // FK para o produto
    private Long tam_id; // FK para o tamanho

    // Construtor que aceita uma entidade
    public ProdutoTamanhoDTO(ProdutoTamanhoEntity produtoTamanho) {
        BeanUtils.copyProperties(produtoTamanho, this); // Copia propriedades da entidade para o DTO
    }

    // Construtor padrão
    public ProdutoTamanhoDTO() {
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
