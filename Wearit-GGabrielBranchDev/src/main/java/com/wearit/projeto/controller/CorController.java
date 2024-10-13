package com.wearit.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wearit.projeto.dto.CorDTO;
import com.wearit.projeto.service.CorService;

@RestController
@RequestMapping(value = "/cor")
public class CorController {
    
    @Autowired
    private CorService corService;
    
    @GetMapping
    public List<CorDTO> listarTodos(){
        return corService.listarTodas();        
    }
    
    @PostMapping
    public void inserir(@RequestBody CorDTO cor) {
        corService.inserir(cor);
    }
    
    @PutMapping
    public CorDTO alterar(@RequestBody CorDTO cor) {
        return corService.alterar(cor);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        corService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
