package com.wearit.projeto.service;

import com.wearit.projeto.dto.UsuarioDTO;
import com.wearit.projeto.entity.UsuarioEntity;
import com.wearit.projeto.exception.UsuarioNotFoundException;
import com.wearit.projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean autenticarUsuario(String nomeUsuario, String senha) {
        Optional<UsuarioEntity> usuarioOptional = usuarioRepository.findByUsuNome(nomeUsuario);
        
        if (usuarioOptional.isPresent()) {
            UsuarioEntity usuario = usuarioOptional.get();
            return passwordEncoder.matches(senha, usuario.getUsuSenha());
        }
        return false;
    }

    public void salvarUsuario(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuario = new UsuarioEntity(usuarioDTO);
        usuario.setUsuSenha(passwordEncoder.encode(usuarioDTO.getUsuSenha()));
        usuarioRepository.save(usuario);
    }

    public void inserir(UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioEntity.setUsuSenha(passwordEncoder.encode(usuario.getUsuSenha()));
        usuarioRepository.save(usuarioEntity);
    }

    public UsuarioDTO alterar(UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
    }

    public void excluir(Long id) {
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário não encontrado"));
        usuarioRepository.delete(usuario);
    }

    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioDTO::new)
                .toList();
    }

    public UsuarioDTO buscarPorId(Long id) {
        return new UsuarioDTO(usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário não encontrado")));
    }
}
