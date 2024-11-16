package com.wearit.projeto.dto;

import com.wearit.projeto.entity.EnderecoEntity;
import org.springframework.beans.BeanUtils;

public class EnderecoDTO {

    private Long end_id; // Identificador único do endereço
    private String end_rua; // Rua do endereço
    private String end_numero; // Número do endereço
    private String end_cep; // CEP do endereço

    // Construtor que aceita uma Entity
    public EnderecoDTO(EnderecoEntity enderecoEntity) {
        BeanUtils.copyProperties(enderecoEntity, this);
    }

    // Construtor padrão
    public EnderecoDTO() {
    }

    // Getters e Setters
    public Long getEnd_id() {
        return end_id;
    }

    public void setEnd_id(Long end_id) {
        this.end_id = end_id;
    }

    public String getEnd_rua() {
        return end_rua;
    }

    public void setEnd_rua(String end_rua) {
        this.end_rua = end_rua;
    }

    public String getEnd_numero() {
        return end_numero;
    }

    public void setEnd_numero(String end_numero) {
        this.end_numero = end_numero;
    }

    public String getEnd_cep() {
        return end_cep;
    }

    public void setEnd_cep(String end_cep) {
        this.end_cep = end_cep;
    }
}
