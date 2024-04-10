package com.api.ecommerce.model.pedido;

import com.api.ecommerce.model.Pedido;
import com.api.ecommerce.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoPostDTO {
    private Produto produto;
    private Pedido pedido;
}
