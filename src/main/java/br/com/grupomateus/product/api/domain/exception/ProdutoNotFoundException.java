package br.com.grupomateus.product.api.domain.exception;

public class ProdutoNotFoundException extends RuntimeException {
    public ProdutoNotFoundException(String message) {
        super(message);
    }
}
