package br.com.grupomateus.product.api.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO {
    private String message;
    private String details;
}
