package com.wearit.projeto.dto;

import com.wearit.projeto.entity.ItemPedidoEntity;
import org.springframework.beans.BeanUtils;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ItemPedidoDTO {

    private Long item_id; // Identificador único do item de pedido
    private Long pco_id; // FK para WEA_PRODUTO_COR
    private Long pto_id; // FK para WEA_PRODUTO_TAMANHO
    private Long pl_id; // FK para WEA_PRODUTO_LINHA
    private Long usu_id; // FK para WEA_USUARIO
    private int ite_quantidade; // Quantidade do item no pedido
    private BigDecimal ite_preco_final; // Preço final do item
    private LocalDateTime ite_data_pedido; // Data do pedido

    // Construtor que aceita uma Entity
    public ItemPedidoDTO(ItemPedidoEntity itemPedidoEntity) {
        BeanUtils.copyProperties(itemPedidoEntity, this);
    }

    // Construtor padrão
    public ItemPedidoDTO() {
    }

    // Getters e Setters
    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Long getPco_id() {
        return pco_id;
    }

    public void setPco_id(Long pco_id) {
        this.pco_id = pco_id;
    }

    public Long getPto_id() {
        return pto_id;
    }

    public void setPto_id(Long pto_id) {
        this.pto_id = pto_id;
    }

    public Long getPl_id() {
        return pl_id;
    }

    public void setPl_id(Long pl_id) {
        this.pl_id = pl_id;
    }

    public Long getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(Long usu_id) {
        this.usu_id = usu_id;
    }

    public int getIte_quantidade() {
        return ite_quantidade;
    }

    public void setIte_quantidade(int ite_quantidade) {
        this.ite_quantidade = ite_quantidade;
    }

    public BigDecimal getIte_preco_final() {
        return ite_preco_final;
    }

    public void setIte_preco_final(BigDecimal ite_preco_final) {
        this.ite_preco_final = ite_preco_final;
    }

    public LocalDateTime getIte_data_pedido() {
        return ite_data_pedido;
    }

    public void setIte_data_pedido(LocalDateTime ite_data_pedido) {
        this.ite_data_pedido = ite_data_pedido;
    }
}
