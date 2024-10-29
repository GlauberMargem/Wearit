package com.wearit.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wearit.projeto.entity.LinhaEntity;

public interface LinhaRepository extends JpaRepository<LinhaEntity, Long> {
    // Este repositório herda os métodos CRUD do JpaRepository
}
