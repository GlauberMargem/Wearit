package com.wearit.projeto.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wearit.projeto.dto.UsuarioDTO;
import com.wearit.projeto.service.UsuarioService;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = "http://localhost:5174") // Permite CORS para esta origem
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listarTodos() {
        return usuarioService.listarTodos();        
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody UsuarioDTO usuario) {
        try {
            usuarioService.inserir(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(null);
        }
    }

    @PutMapping
    public UsuarioDTO alterar(@RequestBody UsuarioDTO usuario) {
        return usuarioService.alterar(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }
}

