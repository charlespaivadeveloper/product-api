package br.com.grupomateus.product.api.configuration;

import br.com.grupomateus.product.api.domain.model.Produto;
import br.com.grupomateus.product.api.domain.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DatabaseLoader {

    private final ProdutoRepository produtoRepository;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            produtoRepository.save(new Produto(null, "Produto 1", "Descrição do Produto 1", 100.0, 10));
            produtoRepository.save(new Produto(null, "Produto 2", "Descrição do Produto 2", 200.0, 20));
            produtoRepository.save(new Produto(null, "Produto 3", "Descrição do Produto 3", 300.0, 30));
            produtoRepository.save(new Produto(null, "Produto 4", "Descrição do Produto 4", 400.0, 40));
            produtoRepository.save(new Produto(null, "Produto 5", "Descrição do Produto 5", 500.0, 50));
            produtoRepository.save(new Produto(null, "Produto 6", "Descrição do Produto 6", 600.0, 60));
            produtoRepository.save(new Produto(null, "Produto 7", "Descrição do Produto 7", 700.0, 70));
            produtoRepository.save(new Produto(null, "Produto 8", "Descrição do Produto 8", 800.0, 80));
            produtoRepository.save(new Produto(null, "Produto 9", "Descrição do Produto 9", 900.0, 90));
            produtoRepository.save(new Produto(null, "Produto 10", "Descrição do Produto 10", 1000.0, 100));
        };
    }
}