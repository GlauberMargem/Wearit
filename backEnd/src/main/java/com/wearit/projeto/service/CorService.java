package com.wearit.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wearit.projeto.dto.CorDTO;
import com.wearit.projeto.entity.CorEntity;
import com.wearit.projeto.repository.CorRepository;

@Service
public class CorService {

    @Autowired
    private CorRepository corRepository;

    // Listar todas as cores
    public List<CorDTO> listarTodas() {
        List<CorEntity> cores = corRepository.findAll();
        return cores.stream().map(CorDTO::new).toList();
    }

    // Inserir nova cor
    public void inserir(CorDTO cor) {
        CorEntity corEntity = new CorEntity(cor);
        corRepository.save(corEntity);
    }

    // Alterar cor existente
    public CorDTO alterar(CorDTO cor) {
        CorEntity corEntity = new CorEntity(cor);
        return new CorDTO(corRepository.save(corEntity));
    }

    // Excluir cor por ID
    public void excluir(Long id) {
        CorEntity cor = corRepository.findById(id).orElseThrow(() -> new RuntimeException("Cor não encontrada"));
        corRepository.delete(cor);
    }

    // Buscar cor por ID
    public CorDTO buscarPorId(Long id) {
        return new CorDTO(corRepository.findById(id).orElseThrow(() -> new RuntimeException("Cor não encontrada")));
    }
}
