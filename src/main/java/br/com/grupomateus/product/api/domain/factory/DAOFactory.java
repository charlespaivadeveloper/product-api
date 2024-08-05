package br.com.grupomateus.product.api.domain.factory;

import br.com.grupomateus.product.api.domain.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DAOFactory {

    private final ProdutoRepository produtoRepository;

    public ProdutoRepository getProdutoRepository() {
        return produtoRepository;
    }
}