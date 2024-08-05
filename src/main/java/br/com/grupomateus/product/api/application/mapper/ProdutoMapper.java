package br.com.grupomateus.product.api.application.mapper;

import br.com.grupomateus.product.api.domain.model.Produto;
import br.com.grupomateus.product.api.application.dto.ProdutoDTO;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getQuantidade()
        );
    }

    public Produto toEntity(ProdutoDTO produtoDTO) {
        return new Produto(
                produtoDTO.getId(),
                produtoDTO.getNome(),
                produtoDTO.getDescricao(),
                produtoDTO.getPreco(),
                produtoDTO.getQuantidade()
        );
    }
}
