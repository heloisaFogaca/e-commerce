package com.api.ecommerce.model.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPostDTO {
    private String nome;
    private String email;
    private String senha;
    private String endereco;
}
