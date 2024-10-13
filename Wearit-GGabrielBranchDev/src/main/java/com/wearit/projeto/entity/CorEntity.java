package com.wearit.projeto.entity;

import com.wearit.projeto.dto.CorDTO; // Certifique-se de ter um DTO para a cor
import org.springframework.beans.BeanUtils; // Importação correta para BeanUtils

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "WEA_COR")
public class CorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cor_id; // Identificador único da cor

    @Column(nullable = false)
    private String cor_nome; // Nome da cor

    @Column(nullable = false)
    private String cor_hex; // Código hexadecimal da cor

    // Construtor que aceita um DTO
    public CorEntity(CorDTO cor) {
        BeanUtils.copyProperties(cor, this); // Copia propriedades do DTO para a entidade
    }
    
    // Construtor padrão
    public CorEntity() {
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

