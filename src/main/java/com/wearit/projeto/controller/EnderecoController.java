package com.wearit.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wearit.projeto.dto.EnderecoDTO;
import com.wearit.projeto.service.EnderecoService;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {
    
    @Autowired
    private EnderecoService enderecoService;
    
    @GetMapping
    public List<EnderecoDTO> listarTodos(){
        return enderecoService.listarTodos();        
    }
    
    @PostMapping
    public void inserir(@RequestBody EnderecoDTO endereco) {
        enderecoService.inserir(endereco);
    }
    
    @PutMapping
    public EnderecoDTO alterar(@RequestBody EnderecoDTO endereco) {
        return enderecoService.alterar(endereco);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        enderecoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
