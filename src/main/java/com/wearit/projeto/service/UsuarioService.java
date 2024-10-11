package com.wearit.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wearit.projeto.dto.UsuarioDTO;
import com.wearit.projeto.entity.UsuarioEntity;
import com.wearit.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Listar todos os usuários
    public List<UsuarioDTO> listarTodos() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDTO::new).toList();
    }

    // Inserir novo usuário
    public void inserir(UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioRepository.save(usuarioEntity);
    }

    // Alterar usuário existente
    public UsuarioDTO alterar(UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
    }

    // Excluir usuário por ID
    public void excluir(Long id) {
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuarioRepository.delete(usuario);
    }

    // Buscar usuário por ID
    public UsuarioDTO buscarPorId(Long id) {
        return new UsuarioDTO(usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado")));
    }
}
