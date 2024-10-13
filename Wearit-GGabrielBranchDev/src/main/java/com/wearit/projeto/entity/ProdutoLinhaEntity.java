package com.wearit.projeto.entity;

import com.wearit.projeto.dto.ProdutoLinhaDTO;
import org.springframework.beans.BeanUtils;
import jakarta.persistence.*;

@Entity
@Table(name = "WEA_PRODUTO_LINHA")
public class ProdutoLinhaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pl_id; // Identificador único da associação

    @Column(name = "PRO_ID", nullable = false)
    private Long pro_id; // FK para WEA_PRODUTO

    @Column(name = "LIN_ID", nullable = false)
    private Long lin_id; // FK para WEA_LINHA

    // Construtor que aceita um DTO
    public ProdutoLinhaEntity(ProdutoLinhaDTO produtoLinhaDTO) {
        BeanUtils.copyProperties(produtoLinhaDTO, this);
    }

    // Construtor padrão
    public ProdutoLinhaEntity() {
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
