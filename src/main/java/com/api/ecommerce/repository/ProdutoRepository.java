package com.api.ecommerce.repository;

import com.api.ecommerce.model.AvaliacaoProduto;
import com.api.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Long> {
}
