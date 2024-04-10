package com.api.ecommerce.repository;

import com.api.ecommerce.model.AvaliacaoProduto;
import com.api.ecommerce.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {

    Categoria findCategoriaByNome(String nome);
}
