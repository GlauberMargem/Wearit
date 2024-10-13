package com.wearit.projeto.repository;

import com.wearit.projeto.entity.CarrinhoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Long> {
    // Métodos customizados, se necessário
    CarrinhoEntity findByUsuarioId(Long usuarioId);
}
