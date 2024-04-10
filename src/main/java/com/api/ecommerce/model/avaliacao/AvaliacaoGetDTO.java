package com.api.ecommerce.model.avaliacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoGetDTO {
    private Integer nota;
    private String comentario;
    private LocalDateTime horarioComentario;
}
