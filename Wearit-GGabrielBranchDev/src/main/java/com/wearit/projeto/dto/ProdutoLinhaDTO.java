package com.wearit.projeto.dto;

import com.wearit.projeto.entity.ProdutoLinhaEntity;
import org.springframework.beans.BeanUtils;

public class ProdutoLinhaDTO {

    private Long pl_id; // Identificador único da associação
    private Long pro_id; // FK para WEA_PRODUTO
    private Long lin_id; // FK para WEA_LINHA

    // Construtor que aceita uma Entity
    public ProdutoLinhaDTO(ProdutoLinhaEntity produtoLinhaEntity) {
        BeanUtils.copyProperties(produtoLinhaEntity, this);
    }

    // Construtor padrão
    public ProdutoLinhaDTO() {
    }

    // Getters e Setters
    public Long getPl_id() {
        return pl_id;
    }

    public void setPl_id(Long pl_id) {
        this.pl_id = pl_id;
    }

    public Long getPro_id() {
        return pro_id;
    }

    public void setPro_id(Long pro_id) {
        this.pro_id = pro_id;
    }

    public Long getLin_id() {
        return lin_id;
    }

    public void setLin_id(Long lin_id) {
        this.lin_id = lin_id;
    }
}
