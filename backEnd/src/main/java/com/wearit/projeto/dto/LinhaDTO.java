package com.wearit.projeto.dto;

import org.springframework.beans.BeanUtils;

import com.wearit.projeto.entity.LinhaEntity; // Certifique-se de ter a importação correta

public class LinhaDTO {

    private Long lin_id; // Identificador único da linha
    private String lin_nome; // Nome da linha

    // Construtor que aceita uma entidade
    public LinhaDTO(LinhaEntity linha) {
        BeanUtils.copyProperties(linha, this); // Copia propriedades da entidade para o DTO
    }

    // Construtor padrão
    public LinhaDTO() {
    }

    // Getters e Setters
    public Long getLin_id() {
        return lin_id;
    }

    public void setLin_id(Long lin_id) {
        this.lin_id = lin_id;
    }

    public String getLin_nome() {
        return lin_nome;
    }

    public void setLin_nome(String lin_nome) {
        this.lin_nome = lin_nome;
    }
}