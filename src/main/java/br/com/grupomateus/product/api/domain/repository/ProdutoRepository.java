package br.com.grupomateus.product.api.domain.repository;

import br.com.grupomateus.product.api.domain.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {
    Produto save(Produto produto);
    Optional<Produto> findById(Long id);
    Page<Produto> findAll(PageRequest pageRequest);
    void deleteById(Long id);

    boolean existsById(Long id);
}
