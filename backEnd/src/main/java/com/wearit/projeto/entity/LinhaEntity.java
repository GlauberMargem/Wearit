package com.wearit.projeto.entity;

import com.wearit.projeto.dto.LinhaDTO;
import org.springframework.beans.BeanUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "WEA_LINHA")
public class LinhaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lin_id; // Identificador único da linha

    @Column(nullable = false)
    private String lin_nome; // Nome da linha

    // Construtor que aceita um DTO
    public LinhaEntity(LinhaDTO linha) {
        BeanUtils.copyProperties(linha, this);
    }

    // Construtor padrão
    public LinhaEntity() {
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
