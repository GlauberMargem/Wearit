package com.wearit.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wearit.projeto.dto.ProdutoLinhaDTO;
import com.wearit.projeto.entity.ProdutoLinhaEntity;
import com.wearit.projeto.repository.ProdutoLinhaRepository;

@Service
public class ProdutoLinhaService {

    @Autowired
    private ProdutoLinhaRepository produtoLinhaRepository;

    // Listar todas as associações de produtos e linhas
    public List<ProdutoLinhaDTO> listarTodos() {
        List<ProdutoLinhaEntity> produtoLinhas = produtoLinhaRepository.findAll();
        return produtoLinhas.stream().map(ProdutoLinhaDTO::new).toList();
    }

    // Inserir nova associação de produto e linha
    public void inserir(ProdutoLinhaDTO produtoLinha) {
        ProdutoLinhaEntity produtoLinhaEntity = new ProdutoLinhaEntity(produtoLinha);
        produtoLinhaRepository.save(produtoLinhaEntity);
    }

    // Alterar associação de produto e linha existente
    public ProdutoLinhaDTO alterar(ProdutoLinhaDTO produtoLinha) {
        ProdutoLinhaEntity produtoLinhaEntity = new ProdutoLinhaEntity(produtoLinha);
        return new ProdutoLinhaDTO(produtoLinhaRepository.save(produtoLinhaEntity));
    }

    // Excluir associação de produto e linha por ID
    public void excluir(Long id) {
        ProdutoLinhaEntity produtoLinha = produtoLinhaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProdutoLinha não encontrada"));
        produtoLinhaRepository.delete(produtoLinha);
    }

    // Buscar associação de produto e linha por ID
    public ProdutoLinhaDTO buscarPorId(Long id) {
        ProdutoLinhaEntity produtoLinha = produtoLinhaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProdutoLinha não encontrada"));
        return new ProdutoLinhaDTO(produtoLinha);
    }
}
