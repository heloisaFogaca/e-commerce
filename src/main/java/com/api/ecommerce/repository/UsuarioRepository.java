package com.api.ecommerce.repository;

import com.api.ecommerce.model.AvaliacaoProduto;
import com.api.ecommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
