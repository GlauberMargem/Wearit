package com.wearit.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wearit.projeto.dto.LinhaDTO;
import com.wearit.projeto.service.LinhaService;

@RestController
@RequestMapping(value = "/linha")
public class LinhaController {
    
    @Autowired
    private LinhaService linhaService;
    
    @GetMapping
    public List<LinhaDTO> listarTodos(){
        return linhaService.listarTodos();        
    }
    
    @PostMapping
    public void inserir(@RequestBody LinhaDTO linha) {
        linhaService.inserir(linha);
    }
    
    @PutMapping
    public LinhaDTO alterar(@RequestBody LinhaDTO linha) {
        return linhaService.alterar(linha);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        linhaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
