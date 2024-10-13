package com.wearit.projeto.entity;

import com.wearit.projeto.dto.UsuarioDTO;
import org.springframework.beans.BeanUtils;
import jakarta.persistence.*;

@Entity
@Table(name = "WEA_USUARIO")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usu_id; // Identificador único do usuário
    
    @Column(nullable = false, unique = true)
    private String usu_nome; // Nome do usuário
    
    @Column(nullable = false)
    private String usu_senha; // Senha do usuário
    
    @Column(nullable = false)
    private char usu_adm; // Indica se o usuário é administrador (1 ou 0)

    // Mapeamento do relacionamento com o endereço
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "end_id", referencedColumnName = "end_id")
    private EnderecoEntity endereco; // Relacionamento com o endereço

    // Construtor que aceita um DTO
    public UsuarioEntity(UsuarioDTO usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

    // Construtor padrão
    public UsuarioEntity() {
    	
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
