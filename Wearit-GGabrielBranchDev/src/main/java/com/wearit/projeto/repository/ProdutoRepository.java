package com.wearit.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wearit.projeto.entity.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

}
