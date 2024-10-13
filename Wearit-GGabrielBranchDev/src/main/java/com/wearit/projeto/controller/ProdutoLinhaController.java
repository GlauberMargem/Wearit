package com.wearit.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wearit.projeto.dto.ProdutoLinhaDTO;
import com.wearit.projeto.service.ProdutoLinhaService;

@RestController
@RequestMapping(value = "/produto-linha")
public class ProdutoLinhaController {
    
    @Autowired
    private ProdutoLinhaService produtoLinhaService;
    
    @GetMapping
    public List<ProdutoLinhaDTO> listarTodos(){
        return produtoLinhaService.listarTodos();        
    }
    
    @PostMapping
    public void inserir(@RequestBody ProdutoLinhaDTO produtoLinha) {
        produtoLinhaService.inserir(produtoLinha);
    }
    
    @PutMapping
    public ProdutoLinhaDTO alterar(@RequestBody ProdutoLinhaDTO produtoLinha) {
        return produtoLinhaService.alterar(produtoLinha);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        produtoLinhaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
