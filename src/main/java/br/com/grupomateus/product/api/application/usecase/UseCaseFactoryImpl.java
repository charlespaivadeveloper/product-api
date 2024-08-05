package br.com.grupomateus.product.api.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class UseCaseFactoryImpl implements UseCaseFactory {

    @Qualifier("useCases")
    private final Map<Class<?>, Object> useCases;

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getUseCase(Class<T> useCaseClass) {
        return (T) useCases.get(useCaseClass);
    }
}
