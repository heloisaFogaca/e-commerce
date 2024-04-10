package com.api.ecommerce.model.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoPostDTO {
    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidade;
    private String categoria;
}
