package com.wearit.projeto.dto;

import org.springframework.beans.BeanUtils;

import com.wearit.projeto.entity.ProdutoCorEntity;

public class ProdutoCorDTO {

    private Long proc_id; // Identificador único do relacionamento produto-cor
    private Long pro_id; // FK para o produto
    private Long cor_id; // FK para a cor

    // Construtor que aceita uma entidade
    public ProdutoCorDTO(ProdutoCorEntity produtoCor) {
        BeanUtils.copyProperties(produtoCor, this); // Copia propriedades da entidade para o DTO
    }

    // Construtor padrão
    public ProdutoCorDTO() {
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
