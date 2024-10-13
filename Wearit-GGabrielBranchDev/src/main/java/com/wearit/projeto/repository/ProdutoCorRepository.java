package com.wearit.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wearit.projeto.entity.ProdutoCorEntity;

public interface ProdutoCorRepository extends JpaRepository<ProdutoCorEntity, Long> {
    // Este repositório herda os métodos CRUD do JpaRepository
}
