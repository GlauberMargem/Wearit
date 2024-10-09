package com.wearit.projeto.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Carrinho")
public class CarrinhoController {

    private Carrinho carrinho = new Carrinho();
    // para adicionar produto
    @PostMapping("/adicionar")
    public Carrinho adicionarProduto(@RequestBody Produto produto) {
        carrinho.getItens().add(produto);
        carrinho.calcularTotal();
        return carrinho;
    }
    // para atualizar produto
    @PutMapping("/atualizar")
    public Carrinho atualizarProduto(@RequestBody Produto produtoAtualizado) {
        for (Produto produto : carrinho.getItens()) {
            if (produto.getId().equals(produtoAtualizado.getId())) {
                produto.setQuantidade(produtoAtualizado.getQuantidade());
            }
        }
        carrinho.calcularTotal();
        return carrinho;
    }

    // para remover produto
    @DeleteMapping("/remover/{produtoId}")
    public Carrinho removerProduto(@PathVariable Long produtoId) {
        carrinho.getItens().removeIf(produto -> produto.getId().equals(produtoId));
        carrinho.calcularTotal();
        return carrinho;
    }

    // Visualizar itens no carrinho
    @GetMapping
    public Carrinho visualizarCarrinho() {
        return carrinho;
    }
}
