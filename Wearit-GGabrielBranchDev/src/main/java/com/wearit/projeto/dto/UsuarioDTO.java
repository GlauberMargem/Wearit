package com.wearit.projeto.dto;

import com.wearit.projeto.entity.EnderecoEntity;
import com.wearit.projeto.entity.UsuarioEntity;
import org.springframework.beans.BeanUtils;

public class UsuarioDTO {
    
    private Long usu_id; // Identificador único do usuário
    private String usu_nome; // Nome do usuário
    private String usu_senha; // Senha do usuário
    private char usu_adm; // Indica se o usuário é administrador (1 ou 0)
    private EnderecoEntity endereco; // Relacionamento com o endereço

    // Construtor que aceita uma entidade
    public UsuarioDTO(UsuarioEntity usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

    // Construtor padrão
    public UsuarioDTO() {
    }

    // Getters e Setters
    public Long getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(Long usu_id) {
        this.usu_id = usu_id;
    }

    public String getUsu_nome() {
        return usu_nome;
    }

    public void setUsu_nome(String usu_nome) {
        this.usu_nome = usu_nome;
    }

    public String getUsu_senha() {
        return usu_senha;
    }

    public void setUsu_senha(String usu_senha) {
        this.usu_senha = usu_senha;
    }

    public char getUsu_adm() {
        return usu_adm;
    }

    public void setUsu_adm(char usu_adm) {
        this.usu_adm = usu_adm;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }
}
