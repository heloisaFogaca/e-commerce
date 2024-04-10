package com.api.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private Integer quantidade;

    @OneToMany(mappedBy = "produto")
    private Collection<ItemPedido> itemPedidos;
    @ManyToOne(cascade = CascadeType.ALL)
    private Categoria categoria;
    @OneToMany(mappedBy = "produto")
    private Collection<AvaliacaoProduto> avaliacoesProduto;
}
