package com.wearit.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wearit.projeto.dto.ItemPedidoDTO;
import com.wearit.projeto.service.ItemPedidoService;

@RestController
@RequestMapping(value = "/item-pedido")
public class ItemPedidoController {
    
    @Autowired
    private ItemPedidoService itemPedidoService;
    
    @GetMapping
    public List<ItemPedidoDTO> listarTodos(){
        return itemPedidoService.listarTodos();        
    }
    
    @PostMapping
    public void inserir(@RequestBody ItemPedidoDTO itemPedido) {
        itemPedidoService.inserir(itemPedido);
    }
    
    @PutMapping
    public ItemPedidoDTO alterar(@RequestBody ItemPedidoDTO itemPedido) {
        return itemPedidoService.alterar(itemPedido);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        itemPedidoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
