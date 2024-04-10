package com.api.ecommerce.controller;

import com.api.ecommerce.model.AvaliacaoProduto;
import com.api.ecommerce.model.ItemPedido;
import com.api.ecommerce.model.avaliacao.AvaliacaoGetDTO;
import com.api.ecommerce.model.avaliacao.AvaliacaoPostDTO;
import com.api.ecommerce.model.categoria.CategoriaGetDTO;
import com.api.ecommerce.model.categoria.CategoriaPostDTO;
import com.api.ecommerce.model.produto.ProdutoGetDTO;
import com.api.ecommerce.model.produto.ProdutoPostDTO;
import com.api.ecommerce.service.ProdutoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProdutoController {
    private ProdutoService produtoService;

    @PostMapping
    private ResponseEntity<ProdutoGetDTO> insert(@RequestBody ProdutoPostDTO produtoPostDTO) {
        try {
            return ResponseEntity.ok(produtoService.save(produtoPostDTO));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/categories")
    private ResponseEntity<CategoriaGetDTO> insertCategoria(@RequestBody CategoriaPostDTO categoriaPostDTO){
        try {
            return ResponseEntity.ok(produtoService.createCategoria(categoriaPostDTO));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{userId}/reviews")
    private ResponseEntity<AvaliacaoGetDTO> insertAvaliacao(@PathVariable Long userId, @RequestBody AvaliacaoPostDTO avaliacaoPostDTO){
        try {
            return ResponseEntity.ok(produtoService.setAvaliacao(avaliacaoPostDTO));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
