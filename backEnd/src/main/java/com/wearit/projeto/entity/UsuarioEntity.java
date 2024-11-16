package com.wearit.projeto.entity;

import com.wearit.projeto.dto.UsuarioDTO;
import org.springframework.beans.BeanUtils;
import jakarta.persistence.*;

@Entity
@Table(name = "WEA_USUARIO")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usu_id;
    
    @Column(name = "usu_nome", nullable = false, unique = true)
    private String usuNome;
    
    @Column(nullable = false)
    private String usuSenha;
    
    @Column(nullable = false)
    private boolean usuAdm;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "end_id", referencedColumnName = "end_id")
    private EnderecoEntity endereco;

    public UsuarioEntity(UsuarioDTO usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

    public UsuarioEntity() {
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
