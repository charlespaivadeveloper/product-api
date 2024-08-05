package br.com.grupomateus.product.api.application.usecase.delete;

import br.com.grupomateus.product.api.domain.exception.ProdutoNotFoundException;
import br.com.grupomateus.product.api.domain.factory.DAOFactory;
import br.com.grupomateus.product.api.domain.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class DeleteProdutoUseCaseImpl implements DeleteProdutoUseCase {

    private final DAOFactory daoFactory;
    private final MessageSource messageSource;

    @Override
    public Void execute(Long id) {
        ProdutoRepository produtoRepository = daoFactory.getProdutoRepository();
        if (!produtoRepository.existsById(id)) {
            String errorMessage = messageSource.getMessage("error.product.notfound", new Object[]{id}, Locale.getDefault());
            throw new ProdutoNotFoundException(errorMessage);
        }
        produtoRepository.deleteById(id);
        return null;
    }
}
