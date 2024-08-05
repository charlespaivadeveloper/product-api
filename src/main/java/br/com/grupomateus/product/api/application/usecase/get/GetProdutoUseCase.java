package br.com.grupomateus.product.api.application.usecase.get;


import br.com.grupomateus.product.api.application.usecase.UseCase;
import br.com.grupomateus.product.api.application.dto.ProdutoDTO;

import java.util.Optional;

public interface GetProdutoUseCase extends UseCase<Long, Optional<ProdutoDTO>> {
}
