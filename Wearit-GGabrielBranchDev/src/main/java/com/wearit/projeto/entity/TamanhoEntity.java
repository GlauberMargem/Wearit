package com.wearit.projeto.entity;

import com.wearit.projeto.dto.TamanhoDTO;
import org.springframework.beans.BeanUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "WEA_TAMANHO")
public class TamanhoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tam_id; // Identificador único do tamanho

    @Column(nullable = false)
    private String tam_nome; // Nome do tamanho (ex: P, M, G)

    // Construtor que aceita um DTO
    public TamanhoEntity(TamanhoDTO tamanho) {
        BeanUtils.copyProperties(tamanho, this);
    }

    // Construtor padrão
    public TamanhoEntity() {
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
