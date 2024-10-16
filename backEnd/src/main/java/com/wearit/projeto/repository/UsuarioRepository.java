package com.wearit.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wearit.projeto.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

}
