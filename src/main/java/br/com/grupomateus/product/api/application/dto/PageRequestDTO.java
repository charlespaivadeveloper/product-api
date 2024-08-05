// application/dto/PageRequestDTO.java
package br.com.grupomateus.product.api.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {
    private int page;
    private int size;
}
