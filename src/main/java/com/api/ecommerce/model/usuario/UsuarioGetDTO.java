package com.api.ecommerce.model.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioGetDTO {
    private Long id;
    private String nome;
    private String email;
    private String endereco;
}
