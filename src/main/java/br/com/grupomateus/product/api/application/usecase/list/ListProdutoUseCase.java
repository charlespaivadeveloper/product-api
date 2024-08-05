package br.com.grupomateus.product.api.application.usecase.list;


import br.com.grupomateus.product.api.application.dto.PageRequestDTO;
import br.com.grupomateus.product.api.application.dto.PageResultDTO;
import br.com.grupomateus.product.api.application.usecase.UseCase;
import br.com.grupomateus.product.api.application.dto.ProdutoDTO;

import java.util.List;

public interface ListProdutoUseCase extends UseCase<PageRequestDTO, PageResultDTO<ProdutoDTO>> {

}
