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
        return usuarioOptional.isPresent() && passwordEncoder.matches(senha, usuarioOptional.get().getUsuSenha());
    }

    public void inserir(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuario = new UsuarioEntity(usuarioDTO);
        usuario.setUsuSenha(passwordEncoder.encode(usuarioDTO.getUsuSenha()));
        usuarioRepository.save(usuario);
    }

    public UsuarioDTO alterar(UsuarioDTO usuarioDTO) {
        UsuarioEntity usuario = new UsuarioEntity(usuarioDTO);
        return new UsuarioDTO(usuarioRepository.save(usuario));
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
}
