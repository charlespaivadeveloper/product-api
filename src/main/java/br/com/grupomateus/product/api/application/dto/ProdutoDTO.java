// usecase/dto/ProdutoDTO.java
package br.com.grupomateus.product.api.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidade;
}
