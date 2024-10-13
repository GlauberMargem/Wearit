package com.wearit.projeto.entity;

import com.wearit.projeto.dto.ProdutoCorDTO;
import org.springframework.beans.BeanUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "WEA_PRODUTO_COR")
public class ProdutoCorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proc_id; // Identificador único do relacionamento produto-cor

    @Column(nullable = false)
    private Long pro_id; // FK para o produto

    @Column(nullable = false)
    private Long cor_id; // FK para a cor

    // Construtor que aceita um DTO
    public ProdutoCorEntity(ProdutoCorDTO produtoCor) {
        BeanUtils.copyProperties(produtoCor, this);
    }

    // Construtor padrão
    public ProdutoCorEntity() {
    }

    // Getters e Setters
    public Long getProc_id() {
        return proc_id;
    }

    public void setProc_id(Long proc_id) {
        this.proc_id = proc_id;
    }

    public Long getPro_id() {
        return pro_id;
    }

    public void setPro_id(Long pro_id) {
        this.pro_id = pro_id;
    }

    public Long getCor_id() {
        return cor_id;
    }

    public void setCor_id(Long cor_id) {
        this.cor_id = cor_id;
    }
}
