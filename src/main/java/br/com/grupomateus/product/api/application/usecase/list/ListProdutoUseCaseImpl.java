package br.com.grupomateus.product.api.application.usecase.list;

import br.com.grupomateus.product.api.application.dto.PageRequestDTO;
import br.com.grupomateus.product.api.application.dto.PageResultDTO;
import br.com.grupomateus.product.api.domain.factory.DAOFactory;
import br.com.grupomateus.product.api.domain.model.Produto;
import br.com.grupomateus.product.api.application.dto.ProdutoDTO;
import br.com.grupomateus.product.api.domain.repository.ProdutoRepository;
import br.com.grupomateus.product.api.application.mapper.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListProdutoUseCaseImpl implements ListProdutoUseCase {

    private final DAOFactory daoFactory;
    private final ProdutoMapper produtoMapper;

    @Override
    public PageResultDTO<ProdutoDTO> execute(PageRequestDTO pageRequestDTO) {
        ProdutoRepository produtoRepository = daoFactory.getProdutoRepository();
        PageRequest pageRequest = PageRequest.of(pageRequestDTO.getPage(), pageRequestDTO.getSize());
        Page<Produto> produtoPage = produtoRepository.findAll(pageRequest);

        List<ProdutoDTO> content = produtoPage.getContent()
                .stream()
                .map(produtoMapper::toDTO)
                .collect(Collectors.toList());

        return new PageResultDTO<>(
                content,
                produtoPage.getNumber(),
                produtoPage.getSize(),
                produtoPage.getTotalElements(),
                produtoPage.getTotalPages()
        );
    }

}
