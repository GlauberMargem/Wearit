package com.wearit.projeto.entity;

import com.wearit.projeto.dto.EnderecoDTO;
import org.springframework.beans.BeanUtils;
import jakarta.persistence.*;

@Entity
@Table(name = "WEA_ENDERECO")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long end_id; // Identificador único do endereço

    @Column(nullable = false)
    private String end_rua; // Rua do endereço

    @Column(nullable = false)
    private String end_numero; // Número do endereço

    @Column(nullable = false)
    private String end_cep; // CEP do endereço

    // Construtor que aceita um DTO
    public EnderecoEntity(EnderecoDTO enderecoDTO) {
        BeanUtils.copyProperties(enderecoDTO, this);
    }

    // Construtor padrão
    public EnderecoEntity() {
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
