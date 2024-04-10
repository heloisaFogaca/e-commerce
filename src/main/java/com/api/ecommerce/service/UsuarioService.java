package com.api.ecommerce.service;

import com.api.ecommerce.model.*;
import com.api.ecommerce.model.pedido.ItemPedidoGetDTO;
import com.api.ecommerce.model.pedido.ItemPedidoPostDTO;
import com.api.ecommerce.model.usuario.UsuarioGetDTO;
import com.api.ecommerce.model.usuario.UsuarioPostDTO;
import com.api.ecommerce.repository.ItemPedidoRepository;
import com.api.ecommerce.repository.PedidoRepository;
import com.api.ecommerce.repository.ProdutoRepository;
import com.api.ecommerce.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private ItemPedidoRepository itemPedidoRepository;
    private PedidoRepository pedidoRepository;
    private ProdutoRepository produtoRepository;

    public UsuarioGetDTO save(UsuarioPostDTO usuarioPostDTO) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioPostDTO, usuario);

        usuarioRepository.save(usuario);
        UsuarioGetDTO usuarioGetDTO = new UsuarioGetDTO();
        BeanUtils.copyProperties(usuario, usuarioGetDTO);
        return  usuarioGetDTO;
    }

    private Usuario findOne(Long id){
        return usuarioRepository.findById(id).get();
    }

    public UsuarioGetDTO password(Long userId, String senha) {
        Usuario usuario = findOne(userId);
        usuario.setSenha(senha);
        usuarioRepository.save(usuario);
        UsuarioGetDTO usuarioGetDTO = new UsuarioGetDTO();
        BeanUtils.copyProperties(usuario, usuarioGetDTO);
        return  usuarioGetDTO;
    }

    public UsuarioGetDTO name(Long userId, String nome) {
        Usuario usuario = findOne(userId);
        usuario.setNome(nome);
        usuarioRepository.save(usuario);
        UsuarioGetDTO usuarioGetDTO = new UsuarioGetDTO();
        BeanUtils.copyProperties(usuario, usuarioGetDTO);
        return  usuarioGetDTO;
    }


    public ItemPedidoGetDTO order(Long userId, ItemPedidoId itemPedidoId, Integer quantidade) {
        Usuario usuario = usuarioRepository.findById(userId).get();

        Produto produto = produtoRepository.findById(itemPedidoId.getProdutoId()).get();

        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setStatus(Status.PENDENTE);
        pedidoRepository.save(pedido);

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);
        itemPedido.setQuantidade(quantidade);
        itemPedido.setPreco(produto.getPreco() * quantidade);
        itemPedidoRepository.save(itemPedido);

        // Atualizar estoque do produto
        produto.setQuantidade(produto.getQuantidade() - quantidade);
        produtoRepository.save(produto);

        ItemPedidoGetDTO pedidoGetDTO = new ItemPedidoGetDTO(quantidade, itemPedido.getPreco(), produto.getNome(), pedido.getStatus());

        return pedidoGetDTO;
    }
}
