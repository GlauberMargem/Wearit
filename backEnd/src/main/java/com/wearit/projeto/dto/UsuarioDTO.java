package com.wearit.projeto.dto;

import org.springframework.beans.BeanUtils;
import com.wearit.projeto.entity.EnderecoEntity;
import com.wearit.projeto.entity.UsuarioEntity;

public class UsuarioDTO {
    
    private Long usu_id;
    private String usuNome;
    private String usuSenha;
    private boolean usuAdm;
    private EnderecoEntity endereco;

    public UsuarioDTO(UsuarioEntity usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

    public UsuarioDTO() {
    }

    // Getters e Setters
    public Long getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(Long usu_id) {
        this.usu_id = usu_id;
    }

    public String getUsuNome() {
        return usuNome;
    }

    public void setUsuNome(String usuNome) {
        this.usuNome = usuNome;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }

    public boolean isUsuAdm() {
        return usuAdm;
    }

    public void setUsuAdm(boolean usuAdm) {
        this.usuAdm = usuAdm;
    }

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }
}
