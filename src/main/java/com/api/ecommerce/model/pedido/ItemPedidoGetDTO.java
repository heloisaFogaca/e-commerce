package com.api.ecommerce.model.pedido;

import com.api.ecommerce.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoGetDTO {
    private Integer quantidade;
    private Double preco;
    private String nomeProduto;
    private Status status;
}
