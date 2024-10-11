package com.wearit.projeto.dto;

import org.springframework.beans.BeanUtils;

import com.wearit.projeto.entity.TamanhoEntity;

public class TamanhoDTO {

    private Long tam_id; // Identificador único do tamanho
    private String tam_nome; // Nome do tamanho (ex: P, M, G)

    // Construtor que aceita uma entidade
    public TamanhoDTO(TamanhoEntity tamanho) {
        BeanUtils.copyProperties(tamanho, this); // Copia propriedades da entidade para o DTO
    }

    // Construtor padrão
    public TamanhoDTO() {
    }

    // Getters e Setters
    public Long getTam_id() {
        return tam_id;
    }

    public void setTam_id(Long tam_id) {
        this.tam_id = tam_id;
    }

    public String getTam_nome() {
        return tam_nome;
    }

    public void setTam_nome(String tam_nome) {
        this.tam_nome = tam_nome;
    }
}

