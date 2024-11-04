package com.wearit.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.wearit.projeto.service.UsuarioService;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5174") // Permite CORS para esta origem
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> credentials) {
        String usuNome = credentials.get("usuNome");
        String senha = credentials.get("senha");

        boolean autenticado = usuarioService.autenticarUsuario(usuNome, senha);
        Map<String, String> response = new HashMap<>();
        
        if (autenticado) {
            response.put("message", "Login bem-sucedido!");
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Credenciais inválidas!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
