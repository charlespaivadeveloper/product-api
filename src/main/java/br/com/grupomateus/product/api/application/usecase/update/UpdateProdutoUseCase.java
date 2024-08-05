package br.com.grupomateus.product.api.application.usecase.update;


import br.com.grupomateus.product.api.application.usecase.UseCase;
import br.com.grupomateus.product.api.application.dto.ProdutoDTO;

public interface UpdateProdutoUseCase extends UseCase<UpdateProdutoUseCase.InputValues, ProdutoDTO> {
    class InputValues {
        private final Long id;
        private final ProdutoDTO produtoDTO;

        public InputValues(Long id, ProdutoDTO produtoDTO) {
            this.id = id;
            this.produtoDTO = produtoDTO;
        }

        public Long getId() {
            return id;
        }

        public ProdutoDTO getProdutoDTO() {
            return produtoDTO;
        }
    }
}
