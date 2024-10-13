package com.wearit.projeto.service;

import com.wearit.projeto.dto.ProdutoDTO;
import com.wearit.projeto.model.ItemCarrinho;
import com.wearit.projeto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class CarrinhoService {

    private final ProdutoRepository produtoRepository;
    private final Map<Long, ItemCarrinho> carrinho = new HashMap<>();

    public CarrinhoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void adicionarProduto(Long produtoId, int quantidade) {
        ProdutoDTO produtoDTO = produtoRepository.findById(produtoId)
                .map(ProdutoDTO::new)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (carrinho.containsKey(produtoId)) {
            ItemCarrinho itemExistente = carrinho.get(produtoId);
            itemExistente.setQuantidade(itemExistente.getQuantidade() + quantidade);
        } else {
            carrinho.put(produtoId, new ItemCarrinho(produtoDTO, quantidade));
        }
    }

    public void atualizarQuantidade(Long produtoId, int quantidade) {
        ItemCarrinho item = carrinho.get(produtoId);
        if (item != null) {
            item.setQuantidade(quantidade);
        } else {
            throw new RuntimeException("Produto não encontrado no carrinho");
        }
    }

    public void removerProduto(Long produtoId) {
        if (!carrinho.containsKey(produtoId)) {
            throw new RuntimeException("Produto não encontrado no carrinho");
        }
        carrinho.remove(produtoId);
    }

    public Map<Long, ItemCarrinho> visualizarCarrinho() {
        return carrinho;
    }

    public double calcularTotalCarrinho() {
        return carrinho.values().stream()
                .mapToDouble(ItemCarrinho::getTotalItem)
                .sum();
    }
}
