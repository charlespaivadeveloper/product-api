package br.com.grupomateus.product.api.domain.exception;

import br.com.grupomateus.product.api.application.dto.ErrorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Locale;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(ProdutoNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleProdutoNotFoundException(ProdutoNotFoundException ex, WebRequest request, Locale locale) {
        String errorMessage = messageSource.getMessage("error.product.notfound", new Object[]{ex.getMessage()}, locale);
        ErrorDTO errorDTO = new ErrorDTO(errorMessage, request.getDescription(false));
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(Exception ex, WebRequest request, Locale locale) {
        String errorMessage = messageSource.getMessage("error.internal", null, locale);
        ErrorDTO errorDTO = new ErrorDTO(errorMessage, request.getDescription(false));
        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
