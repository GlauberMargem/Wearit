package com.wearit.projeto.dto;

import org.springframework.beans.BeanUtils;

import com.wearit.projeto.entity.CorEntity; // Certifique-se de ter a importação correta

public class CorDTO {
	
    private Long cor_id; // Identificador único da cor
    private String cor_nome; // Nome da cor
    private String cor_hex; // Código hexadecimal da cor

    // Construtor que aceita uma entidade
    public CorDTO(CorEntity cor) {
        BeanUtils.copyProperties(cor, this); // Copia propriedades da entidade para o DTO
    }

    // Construtor padrão
    public CorDTO() {
    }
    
    // Getters e Setters
    public Long getCor_id() {
        return cor_id;
    }

    public void setCor_id(Long cor_id) {
        this.cor_id = cor_id;
    }

    public String getCor_nome() {
        return cor_nome;
    }

    public void setCor_nome(String cor_nome) {
        this.cor_nome = cor_nome;
    }

    public String getCor_hex() {
        return cor_hex;
    }

    public void setCor_hex(String cor_hex) {
        this.cor_hex = cor_hex;
    }
}
