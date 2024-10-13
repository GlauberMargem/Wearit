package com.wearit.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wearit.projeto.dto.TamanhoDTO;
import com.wearit.projeto.entity.TamanhoEntity;
import com.wearit.projeto.repository.TamanhoRepository;
import java.util.List;

@Service
public class TamanhoService {

    @Autowired
    private TamanhoRepository tamanhoRepository;

    public List<TamanhoDTO> listarTodos() {
        List<TamanhoEntity> tamanhos = tamanhoRepository.findAll();
        return tamanhos.stream().map(TamanhoDTO::new).toList();
    }

    public void inserir(TamanhoDTO tamanhoDTO) {
        TamanhoEntity tamanhoEntity = new TamanhoEntity(tamanhoDTO);
        tamanhoRepository.save(tamanhoEntity);
    }

    public TamanhoDTO alterar(TamanhoDTO tamanhoDTO) {
        TamanhoEntity tamanhoEntity = new TamanhoEntity(tamanhoDTO);
        return new TamanhoDTO(tamanhoRepository.save(tamanhoEntity));
    }

    public void excluir(Long id) {
        tamanhoRepository.deleteById(id);
    }

    public TamanhoDTO buscarPorId(Long id) {
        return tamanhoRepository.findById(id)
            .map(TamanhoDTO::new)
            .orElseThrow(() -> new RuntimeException("Tamanho não encontrado com ID: " + id));
    }
}
