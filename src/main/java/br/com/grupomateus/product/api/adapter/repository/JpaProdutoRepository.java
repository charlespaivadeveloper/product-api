package br.com.grupomateus.product.api.adapter.repository;

import br.com.grupomateus.product.api.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface JpaProdutoRepository extends JpaRepository<Produto, Long> {
}