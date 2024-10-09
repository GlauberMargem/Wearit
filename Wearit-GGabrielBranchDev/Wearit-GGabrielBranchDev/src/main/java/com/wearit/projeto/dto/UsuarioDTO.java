package com.wearit.projeto.dto;

import org.springframework.beans.BeanUtils;

import com.wearit.projeto.entity.UsuarioEntity;

public class UsuarioDTO {
	
    private Long usu_id; // Identificador único do usuário
    private String usu_nome; // Nome do usuário
    private String usu_senha; // Senha do usuário
    private char usu_adm; // Indica se o usuário é administrador (1 ou 0)
    private Long end_id; // Referência ao endereço (FK)
    
    public UsuarioDTO (UsuarioEntity usuario) {
    	BeanUtils.copyProperties(usuario, this);
    }
    
    public UsuarioDTO() {
    	
    }
    
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
	public Long getEnd_id() {
		return end_id;
	}
	public void setEnd_id(Long end_id) {
		this.end_id = end_id;
	}
}
