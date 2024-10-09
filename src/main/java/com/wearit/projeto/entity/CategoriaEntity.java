package com.wearit.projeto.entity;

import com.wearit.projeto.dto.CategoriaDTO;
import org.springframework.beans.BeanUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "WEA_CATEGORIA")
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cat_id; // Identificador único da categoria

    @Column(nullable = false)
    private String cat_nome; // Nome da categoria

    // Construtor que aceita um DTO
    public CategoriaEntity(CategoriaDTO categoria) {
        BeanUtils.copyProperties(categoria, this);
    }

    // Construtor padrão
    public CategoriaEntity() {
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