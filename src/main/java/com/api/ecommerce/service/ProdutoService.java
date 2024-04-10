package com.api.ecommerce.service;

import com.api.ecommerce.model.AvaliacaoProduto;
import com.api.ecommerce.model.Categoria;
import com.api.ecommerce.model.Produto;
import com.api.ecommerce.model.avaliacao.AvaliacaoGetDTO;
import com.api.ecommerce.model.avaliacao.AvaliacaoPostDTO;
import com.api.ecommerce.model.categoria.CategoriaGetDTO;
import com.api.ecommerce.model.categoria.CategoriaPostDTO;
import com.api.ecommerce.model.produto.ProdutoGetDTO;
import com.api.ecommerce.model.produto.ProdutoPostDTO;
import com.api.ecommerce.repository.AvaliacaoRepository;
import com.api.ecommerce.repository.CategoriaRepository;
import com.api.ecommerce.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoService {
    private ProdutoRepository produtoRepository;
    private CategoriaRepository categoriaRepository;
    private AvaliacaoRepository avaliacaoRepository;
    public ProdutoGetDTO save(ProdutoPostDTO produtoPostDTO) {
        Produto produto = new Produto();
        Categoria categoria = categoriaRepository.findCategoriaByNome(produtoPostDTO.getCategoria());
        BeanUtils.copyProperties(produtoPostDTO, produto);
        produto.setCategoria(categoria);

        produtoRepository.save(produto);
        ProdutoGetDTO produtoGetDTO = new ProdutoGetDTO(
                                       produto.getId(),
                                       produto.getNome(),
                                       produto.getDescricao(),
                                       produto.getPreco(),
                                       produto.getQuantidade(),
                                       produto.getCategoria().getNome());

        return produtoGetDTO;
    }

    public CategoriaGetDTO createCategoria(CategoriaPostDTO categoriaPostDTO) {
        Categoria categoria = new Categoria();
        BeanUtils.copyProperties(categoriaPostDTO, categoria);
        categoriaRepository.save(categoria);
        CategoriaGetDTO categoriaGetDTO = new CategoriaGetDTO(categoria.getId(), categoria.getNome());
        return categoriaGetDTO;
    }

    public AvaliacaoGetDTO setAvaliacao(AvaliacaoPostDTO avaliacaoPostDTO) {
        AvaliacaoProduto avaliacaoProduto = new AvaliacaoProduto();
        BeanUtils.copyProperties(avaliacaoPostDTO, avaliacaoProduto);
        avaliacaoRepository.save(avaliacaoProduto);

        AvaliacaoGetDTO avaliacaoGetDTO = new AvaliacaoGetDTO(avaliacaoProduto.getNota(), avaliacaoProduto.getComentario(), avaliacaoProduto.getHorarioComentario());
        return  avaliacaoGetDTO;
    }
}
