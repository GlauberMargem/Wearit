package com.wearit.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wearit.projeto.dto.CategoriaDTO;
import com.wearit.projeto.entity.CategoriaEntity;
import com.wearit.projeto.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Listar todas as categorias
    public List<CategoriaDTO> listarTodas() {
        List<CategoriaEntity> categorias = categoriaRepository.findAll();
        return categorias.stream().map(CategoriaDTO::new).toList();
    }

    // Inserir nova categoria
    public void inserir(CategoriaDTO categoria) {
        CategoriaEntity categoriaEntity = new CategoriaEntity(categoria);
        categoriaRepository.save(categoriaEntity);
    }

    // Alterar categoria existente
    public CategoriaDTO alterar(CategoriaDTO categoria) {
        CategoriaEntity categoriaEntity = new CategoriaEntity(categoria);
        return new CategoriaDTO(categoriaRepository.save(categoriaEntity));
    }

    // Excluir categoria por ID
    public void excluir(Long id) {
        CategoriaEntity categoria = categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        categoriaRepository.delete(categoria);
    }

    // Buscar categoria por ID
    public CategoriaDTO buscarPorId(Long id) {
        return new CategoriaDTO(categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada")));
    }
}
