package br.com.grupomateus.product.api.adapter.repository;

import br.com.grupomateus.product.api.domain.model.Produto;
import br.com.grupomateus.product.api.domain.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final JpaProdutoRepository jpaProdutoRepository;

    @Override
    public Produto save(Produto produto) {
        return jpaProdutoRepository.save(produto);
    }

    @Override
    public Optional<Produto> findById(Long id) {
        return jpaProdutoRepository.findById(id);
    }

    @Override
    public List<Produto> findAll(PageRequest pageRequest) {
        return jpaProdutoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {jpaProdutoRepository.deleteById(id);}

    @Override
    public boolean existsById(Long id) { return jpaProdutoRepository.existsById(id); }

}
