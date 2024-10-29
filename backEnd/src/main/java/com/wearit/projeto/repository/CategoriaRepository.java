package com.wearit.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wearit.projeto.entity.CategoriaEntity;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

}
