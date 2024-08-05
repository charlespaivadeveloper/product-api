package br.com.grupomateus.product.api.application.usecase;

public interface UseCaseFactory {
    <T> T getUseCase(Class<T> useCaseClass);
}
