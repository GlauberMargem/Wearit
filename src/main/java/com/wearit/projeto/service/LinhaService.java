package com.wearit.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wearit.projeto.dto.LinhaDTO;
import com.wearit.projeto.entity.LinhaEntity;
import com.wearit.projeto.repository.LinhaRepository;
import java.util.List;

@Service
public class LinhaService {

    @Autowired
    private LinhaRepository linhaRepository;

    public List<LinhaDTO> listarTodos() {
        List<LinhaEntity> linhas = linhaRepository.findAll();
        return linhas.stream().map(LinhaDTO::new).toList();
    }

    public void inserir(LinhaDTO linhaDTO) {
        LinhaEntity linhaEntity = new LinhaEntity(linhaDTO);
        linhaRepository.save(linhaEntity);
    }

    public LinhaDTO alterar(LinhaDTO linhaDTO) {
        LinhaEntity linhaEntity = new LinhaEntity(linhaDTO);
        return new LinhaDTO(linhaRepository.save(linhaEntity));
    }

    public void excluir(Long id) {
        linhaRepository.deleteById(id);
    }

    public LinhaDTO buscarPorId(Long id) {
        return linhaRepository.findById(id)
            .map(LinhaDTO::new)
            .orElseThrow(() -> new RuntimeException("Linha não encontrada com ID: " + id));
    }
}
