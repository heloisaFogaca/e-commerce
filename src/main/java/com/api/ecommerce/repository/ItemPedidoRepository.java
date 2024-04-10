package com.api.ecommerce.repository;

import com.api.ecommerce.model.AvaliacaoProduto;
import com.api.ecommerce.model.ItemPedido;
import com.api.ecommerce.model.ItemPedidoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository  extends JpaRepository<ItemPedido, ItemPedidoId> {
}
