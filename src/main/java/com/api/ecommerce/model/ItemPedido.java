package com.api.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_itemPedido")
public class ItemPedido {
    @EmbeddedId
    private ItemPedidoId id;
    private Integer quantidade;
    private Double preco;

    @ManyToOne
    @MapsId("produtoId")
    private Produto produto;
    @ManyToOne
    @MapsId("pedidoId")
    private Pedido pedido;
}
