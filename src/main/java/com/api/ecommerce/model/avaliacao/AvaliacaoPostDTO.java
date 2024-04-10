package com.api.ecommerce.model.avaliacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoPostDTO {
    private Integer nota;
    private String comentario;
}
