package br.com.grupomateus.product.api.configuration;

import br.com.grupomateus.product.api.application.usecase.create.CreateProdutoUseCase;
import br.com.grupomateus.product.api.application.usecase.delete.DeleteProdutoUseCase;
import br.com.grupomateus.product.api.application.usecase.get.GetProdutoUseCase;
import br.com.grupomateus.product.api.application.usecase.list.ListProdutoUseCase;
import br.com.grupomateus.product.api.application.usecase.update.UpdateProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BeanConfig {

    @Bean("useCases")
    public Map<Class<?>, Object> useCasesMap(
            CreateProdutoUseCase createProdutoUseCase,
            UpdateProdutoUseCase updateProdutoUseCase,
            DeleteProdutoUseCase deleteProdutoUseCase,
            GetProdutoUseCase getProdutoUseCase,
            ListProdutoUseCase listProdutoUseCase) {

        Map<Class<?>, Object> useCases = new HashMap<>();
        useCases.put(CreateProdutoUseCase.class, createProdutoUseCase);
        useCases.put(UpdateProdutoUseCase.class, updateProdutoUseCase);
        useCases.put(DeleteProdutoUseCase.class, deleteProdutoUseCase);
        useCases.put(GetProdutoUseCase.class, getProdutoUseCase);
        useCases.put(ListProdutoUseCase.class, listProdutoUseCase);
        return useCases;
    }

}
