package com.wearit.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wearit.projeto.dto.ProdutoDTO;
import com.wearit.projeto.service.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping
    public List<ProdutoDTO> listarTodos(){
        return produtoService.listarTodos();        
    }
    
    @PostMapping
    public void inserir(@RequestBody ProdutoDTO produto) {
        produtoService.inserir(produto);
    }
    
    @PutMapping
    public ProdutoDTO alterar(@RequestBody ProdutoDTO produto) {
        return produtoService.alterar(produto);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        produtoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
