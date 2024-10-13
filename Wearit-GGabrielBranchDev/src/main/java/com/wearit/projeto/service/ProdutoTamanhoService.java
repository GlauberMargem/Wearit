package com.wearit.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wearit.projeto.dto.ProdutoTamanhoDTO;
import com.wearit.projeto.entity.ProdutoTamanhoEntity;
import com.wearit.projeto.repository.ProdutoTamanhoRepository;

@Service
public class ProdutoTamanhoService {

    @Autowired
    private ProdutoTamanhoRepository produtoTamanhoRepository;

    // Listar todos os relacionamentos produto-tamanho
    public List<ProdutoTamanhoDTO> listarTodos() {
        List<ProdutoTamanhoEntity> produtoTamanhos = produtoTamanhoRepository.findAll();
        return produtoTamanhos.stream().map(ProdutoTamanhoDTO::new).toList();
    }

    // Inserir novo relacionamento produto-tamanho
    public void inserir(ProdutoTamanhoDTO produtoTamanho) {
        ProdutoTamanhoEntity produtoTamanhoEntity = new ProdutoTamanhoEntity(produtoTamanho);
        produtoTamanhoRepository.save(produtoTamanhoEntity);
    }

    // Alterar relacionamento produto-tamanho existente
    public ProdutoTamanhoDTO alterar(ProdutoTamanhoDTO produtoTamanho) {
        ProdutoTamanhoEntity produtoTamanhoEntity = new ProdutoTamanhoEntity(produtoTamanho);
        return new ProdutoTamanhoDTO(produtoTamanhoRepository.save(produtoTamanhoEntity));
    }

    // Excluir relacionamento produto-tamanho por ID
    public void excluir(Long id) {
        ProdutoTamanhoEntity produtoTamanho = produtoTamanhoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProdutoTamanho não encontrado"));
        produtoTamanhoRepository.delete(produtoTamanho);
    }

    // Buscar relacionamento produto-tamanho por ID
    public ProdutoTamanhoDTO buscarPorId(Long id) {
        ProdutoTamanhoEntity produtoTamanho = produtoTamanhoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProdutoTamanho não encontrado"));
        return new ProdutoTamanhoDTO(produtoTamanho);
    }
}
