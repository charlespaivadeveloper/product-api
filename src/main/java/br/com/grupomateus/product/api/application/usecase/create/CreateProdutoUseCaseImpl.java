package br.com.grupomateus.product.api.application.usecase.create;

import br.com.grupomateus.product.api.application.dto.ProdutoDTO;
import br.com.grupomateus.product.api.application.mapper.ProdutoMapper;
import br.com.grupomateus.product.api.domain.factory.DAOFactory;
import br.com.grupomateus.product.api.domain.model.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProdutoUseCaseImpl implements CreateProdutoUseCase {

    private final DAOFactory daoFactory;
    private final ProdutoMapper produtoMapper;

    @Override
    public ProdutoDTO execute(ProdutoDTO produtoDTO) {
        Produto produto = produtoMapper.toEntity(produtoDTO);
        Produto salvo = daoFactory.getProdutoRepository().save(produto);
        return produtoMapper.toDTO(salvo);
    }
}
