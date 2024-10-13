package com.wearit.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wearit.projeto.dto.ProdutoTamanhoDTO;
import com.wearit.projeto.service.ProdutoTamanhoService;

@RestController
@RequestMapping(value = "/produto-tamanho")
public class ProdutoTamanhoController {
    
    @Autowired
    private ProdutoTamanhoService produtoTamanhoService;
    
    @GetMapping
    public List<ProdutoTamanhoDTO> listarTodos(){
        return produtoTamanhoService.listarTodos();        
    }
    
    @PostMapping
    public void inserir(@RequestBody ProdutoTamanhoDTO produtoTamanho) {
        produtoTamanhoService.inserir(produtoTamanho);
    }
    
    @PutMapping
    public ProdutoTamanhoDTO alterar(@RequestBody ProdutoTamanhoDTO produtoTamanho) {
        return produtoTamanhoService.alterar(produtoTamanho);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        produtoTamanhoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
