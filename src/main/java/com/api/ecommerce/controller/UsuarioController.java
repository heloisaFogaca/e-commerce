package com.api.ecommerce.controller;

import com.api.ecommerce.model.ItemPedidoId;
import com.api.ecommerce.model.pedido.ItemPedidoGetDTO;
import com.api.ecommerce.model.pedido.ItemPedidoPostDTO;
import com.api.ecommerce.model.usuario.UsuarioGetDTO;
import com.api.ecommerce.model.usuario.UsuarioPostDTO;
import com.api.ecommerce.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UsuarioController {
    private UsuarioService usuarioService;

    @PostMapping
    private ResponseEntity<UsuarioGetDTO> insert(@RequestBody UsuarioPostDTO usuarioPostDTO) {
        try {
            return ResponseEntity.ok(usuarioService.save(usuarioPostDTO));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{userId}/password")
    private ResponseEntity<UsuarioGetDTO> changePassword(@PathVariable Long userId, @RequestParam String senha){
        try {
            return ResponseEntity.ok(usuarioService.password(userId, senha));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{userId}/name")
    private ResponseEntity<UsuarioGetDTO> changeName(@PathVariable Long userId, @RequestParam String nome){
        try {
            return ResponseEntity.ok(usuarioService.name(userId, nome));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{userId}/order")
    private ResponseEntity<ItemPedidoGetDTO> insertPedido(@PathVariable Long userId, @RequestBody ItemPedidoId itemPedidoId, @RequestParam Integer quantidade){
        try {
            return ResponseEntity.ok(usuarioService.order(userId, itemPedidoId, quantidade));
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
