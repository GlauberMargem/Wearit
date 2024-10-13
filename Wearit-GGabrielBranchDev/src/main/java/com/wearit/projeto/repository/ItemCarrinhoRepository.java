package com.wearit.projeto.repository;

import com.wearit.projeto.entity.ItemCarrinhoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCarrinhoRepository extends JpaRepository<ItemCarrinhoEntity, Long> {
    // Métodos customizados, se necessário
}
