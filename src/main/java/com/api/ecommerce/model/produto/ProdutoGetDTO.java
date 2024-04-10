package com.api.ecommerce.model.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoGetDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidade;
    private String categoriaNome;
}
