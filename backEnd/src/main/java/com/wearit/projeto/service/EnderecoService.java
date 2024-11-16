package com.wearit.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wearit.projeto.dto.EnderecoDTO;
import com.wearit.projeto.entity.EnderecoEntity;
import com.wearit.projeto.repository.EnderecoRepository;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    // Listar todos os endereços
    public List<EnderecoDTO> listarTodos() {
        List<EnderecoEntity> enderecos = enderecoRepository.findAll();
        return enderecos.stream().map(EnderecoDTO::new).toList();
    }

    // Inserir novo endereço
    public void inserir(EnderecoDTO endereco) {
        EnderecoEntity enderecoEntity = new EnderecoEntity(endereco);
        enderecoRepository.save(enderecoEntity);
    }

    // Alterar endereço existente
    public EnderecoDTO alterar(EnderecoDTO endereco) {
        EnderecoEntity enderecoEntity = new EnderecoEntity(endereco);
        return new EnderecoDTO(enderecoRepository.save(enderecoEntity));
    }

    // Excluir endereço por ID
    public void excluir(Long id) {
        EnderecoEntity endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        enderecoRepository.delete(endereco);
    }

    // Buscar endereço por ID
    public EnderecoDTO buscarPorId(Long id) {
        return new EnderecoDTO(enderecoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado")));
    }
}
