// usecase/update/UpdateProdutoUseCaseImpl.java
package br.com.grupomateus.product.api.application.usecase.update;

import br.com.grupomateus.product.api.domain.model.Produto;
import br.com.grupomateus.product.api.application.dto.ProdutoDTO;
import br.com.grupomateus.product.api.domain.repository.ProdutoRepository;
import br.com.grupomateus.product.api.application.mapper.ProdutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UpdateProdutoUseCaseImpl implements UpdateProdutoUseCase {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoMapper produtoMapper;

    @Override
    public ProdutoDTO execute(InputValues input) {
        Optional<Produto> produtoOptional = produtoRepository.findById(input.getId());
        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            produto.setNome(input.getProdutoDTO().getNome());
            produto.setDescricao(input.getProdutoDTO().getDescricao());
            produto.setPreco(input.getProdutoDTO().getPreco());
            produto.setQuantidade(input.getProdutoDTO().getQuantidade());
            Produto atualizado = produtoRepository.save(produto);
            return produtoMapper.toDTO(atualizado);
        }
        return null;
    }
}
