package com.wearit.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wearit.projeto.dto.ProdutoCorDTO;
import com.wearit.projeto.entity.ProdutoCorEntity;
import com.wearit.projeto.repository.ProdutoCorRepository;
import java.util.List;

@Service
public class ProdutoCorService {

    @Autowired
    private ProdutoCorRepository produtoCorRepository;

    public List<ProdutoCorDTO> listarTodos() {
        List<ProdutoCorEntity> produtosCor = produtoCorRepository.findAll();
        return produtosCor.stream().map(ProdutoCorDTO::new).toList();
    }

    public void inserir(ProdutoCorDTO produtoCorDTO) {
        ProdutoCorEntity produtoCorEntity = new ProdutoCorEntity(produtoCorDTO);
        produtoCorRepository.save(produtoCorEntity);
    }

    public ProdutoCorDTO alterar(ProdutoCorDTO produtoCorDTO) {
        ProdutoCorEntity produtoCorEntity = new ProdutoCorEntity(produtoCorDTO);
        return new ProdutoCorDTO(produtoCorRepository.save(produtoCorEntity));
    }

    public void excluir(Long id) {
        produtoCorRepository.deleteById(id);
    }

    public ProdutoCorDTO buscarPorId(Long id) {
        return produtoCorRepository.findById(id)
            .map(ProdutoCorDTO::new)
            .orElseThrow(() -> new RuntimeException("ProdutoCor não encontrado com ID: " + id));
    }
}
