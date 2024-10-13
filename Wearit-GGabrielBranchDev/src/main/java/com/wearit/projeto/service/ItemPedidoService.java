package com.wearit.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wearit.projeto.dto.ItemPedidoDTO;
import com.wearit.projeto.entity.ItemPedidoEntity;
import com.wearit.projeto.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    // Listar todos os itens de pedido
    public List<ItemPedidoDTO> listarTodos() {
        List<ItemPedidoEntity> itensPedido = itemPedidoRepository.findAll();
        return itensPedido.stream().map(ItemPedidoDTO::new).toList();
    }

    // Inserir novo item de pedido
    public void inserir(ItemPedidoDTO itemPedido) {
        ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity(itemPedido);
        itemPedidoRepository.save(itemPedidoEntity);
    }

    // Alterar item de pedido existente
    public ItemPedidoDTO alterar(ItemPedidoDTO itemPedido) {
        ItemPedidoEntity itemPedidoEntity = new ItemPedidoEntity(itemPedido);
        return new ItemPedidoDTO(itemPedidoRepository.save(itemPedidoEntity));
    }

    // Excluir item de pedido por ID
    public void excluir(Long id) {
        ItemPedidoEntity itemPedido = itemPedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item de pedido não encontrado"));
        itemPedidoRepository.delete(itemPedido);
    }

    // Buscar item de pedido por ID
    public ItemPedidoDTO buscarPorId(Long id) {
        return new ItemPedidoDTO(itemPedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item de pedido não encontrado")));
    }
}
