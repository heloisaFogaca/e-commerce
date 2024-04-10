package com.api.ecommerce.service;

import com.api.ecommerce.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@AllArgsConstructor
public class PedidoService {
    private PedidoRepository pedidoRepository;
}
