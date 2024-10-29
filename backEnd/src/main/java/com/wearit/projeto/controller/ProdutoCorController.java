package com.wearit.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wearit.projeto.dto.ProdutoCorDTO;
import com.wearit.projeto.service.ProdutoCorService;

@RestController
@RequestMapping(value = "/produto-cor")
public class ProdutoCorController {
    
    @Autowired
    private ProdutoCorService produtoCorService;
    
    @GetMapping
    public List<ProdutoCorDTO> listarTodos(){
        return produtoCorService.listarTodos();        
    }
    
    @PostMapping
    public void inserir(@RequestBody ProdutoCorDTO produtoCor) {
        produtoCorService.inserir(produtoCor);
    }
    
    @PutMapping
    public ProdutoCorDTO alterar(@RequestBody ProdutoCorDTO produtoCor) {
        return produtoCorService.alterar(produtoCor);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        produtoCorService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
