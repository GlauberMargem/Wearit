package com.wearit.projeto.dto;

import org.springframework.beans.BeanUtils;

import com.wearit.projeto.entity.CategoriaEntity;

public class CategoriaDTO {

    private Long cat_id; // Identificador único da categoria
    private String cat_nome; // Nome da categoria

    // Construtor que aceita uma entidade
    public CategoriaDTO(CategoriaEntity categoria) {
        BeanUtils.copyProperties(categoria, this); // Copia propriedades da entidade para o DTO
    }

    // Construtor padrão
    public CategoriaDTO() {
    }

    // Getters e Setters
    public Long getCat_id() {
        return cat_id;
    }

    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }

    public String getCat_nome() {
        return cat_nome;
    }

    public void setCat_nome(String cat_nome) {
        this.cat_nome = cat_nome;
    }
}