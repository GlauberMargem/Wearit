package com.wearit.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wearit.projeto.dto.TamanhoDTO;
import com.wearit.projeto.service.TamanhoService;

@RestController
@RequestMapping(value = "/tamanho")
public class TamanhoController {
    
    @Autowired
    private TamanhoService tamanhoService;
    
    @GetMapping
    public List<TamanhoDTO> listarTodos(){
        return tamanhoService.listarTodos();        
    }
    
    @PostMapping
    public void inserir(@RequestBody TamanhoDTO tamanho) {
        tamanhoService.inserir(tamanho);
    }
    
    @PutMapping
    public TamanhoDTO alterar(@RequestBody TamanhoDTO tamanho) {
        return tamanhoService.alterar(tamanho);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        tamanhoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
