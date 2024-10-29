package com.wearit.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wearit.projeto.entity.TamanhoEntity;

public interface TamanhoRepository extends JpaRepository<TamanhoEntity, Long> {
    // Este repositório herda os métodos CRUD do JpaRepository
}
