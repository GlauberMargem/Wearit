package com.wearit.projeto.controller;

import com.wearit.projeto.model.ItemCarrinho;
import com.wearit.projeto.service.CarrinhoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarProduto(@RequestParam Long produtoId, @RequestParam int quantidade) {
        carrinhoService.adicionarProduto(produtoId, quantidade);
        return ResponseEntity.ok("Produto adicionado ao carrinho com sucesso");
    }

    @PutMapping("/atualizar")
    public ResponseEntity<String> atualizarQuantidade(@RequestParam Long produtoId, @RequestParam int quantidade) {
        carrinhoService.atualizarQuantidade(produtoId, quantidade);
        return ResponseEntity.ok("Quantidade atualizada com sucesso");
    }

    @DeleteMapping("/remover/{produtoId}")
    public ResponseEntity<String> removerProduto(@PathVariable Long produtoId) {
        carrinhoService.removerProduto(produtoId);
        return ResponseEntity.ok("Produto removido do carrinho");
    }

    @GetMapping
    public ResponseEntity<Map<Long, ItemCarrinho>> visualizarCarrinho() {
        return ResponseEntity.ok(carrinhoService.visualizarCarrinho());
    }

    @GetMapping("/total")
    public ResponseEntity<Double> calcularTotal() {
        return ResponseEntity.ok(carrinhoService.calcularTotalCarrinho());
    }
}
