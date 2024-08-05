package br.com.grupomateus.product.api.application.usecase;

public interface UseCase<I, O> {
    O execute(I input);
}
