package br.com.grupomateus.product.api.application.usecase.get;

import br.com.grupomateus.product.api.domain.exception.ProdutoNotFoundException;
import br.com.grupomateus.product.api.domain.factory.DAOFactory;
import br.com.grupomateus.product.api.domain.model.Produto;
import br.com.grupomateus.product.api.application.dto.ProdutoDTO;
import br.com.grupomateus.product.api.domain.repository.ProdutoRepository;
import br.com.grupomateus.product.api.application.mapper.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetProdutoUseCaseImpl implements GetProdutoUseCase {

    private final DAOFactory daoFactory;
    private final ProdutoMapper produtoMapper;
    private final MessageSource messageSource;

    @Override
    public Optional<ProdutoDTO> execute(Long id) {
        ProdutoRepository produtoRepository = daoFactory.getProdutoRepository();
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isEmpty()) {
            throw new ProdutoNotFoundException(messageSource.getMessage("error.product.notfound", new Object[]{id}, Locale.getDefault()));
        }
        return produtoOptional.map(produtoMapper::toDTO);
    }
}
