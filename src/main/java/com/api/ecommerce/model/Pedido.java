package com.api.ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataPedido = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany
    private Collection<ItemPedido> itemPedidos;
    @ManyToOne
    private Usuario usuario;
}
