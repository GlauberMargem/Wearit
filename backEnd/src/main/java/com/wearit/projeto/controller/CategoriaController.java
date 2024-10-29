package com.wearit.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wearit.projeto.dto.CategoriaDTO;
import com.wearit.projeto.service.CategoriaService;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping
    public List<CategoriaDTO> listarTodos(){
        return categoriaService.listarTodas();        
    }
    
    @PostMapping
    public void inserir(@RequestBody CategoriaDTO categoria) {
        categoriaService.inserir(categoria);
    }
    
    @PutMapping
    public CategoriaDTO alterar(@RequestBody CategoriaDTO categoria) {
        return categoriaService.alterar(categoria);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        categoriaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
