package br.com.grupomateus.product.api.adapter.controller;

import br.com.grupomateus.product.api.application.dto.PageRequestDTO;
import br.com.grupomateus.product.api.application.dto.PageResultDTO;
import br.com.grupomateus.product.api.application.usecase.UseCaseFactory;
import br.com.grupomateus.product.api.application.usecase.create.CreateProdutoUseCase;
import br.com.grupomateus.product.api.application.usecase.delete.DeleteProdutoUseCase;
import br.com.grupomateus.product.api.application.dto.ProdutoDTO;
import br.com.grupomateus.product.api.application.usecase.get.GetProdutoUseCase;
import br.com.grupomateus.product.api.application.usecase.list.ListProdutoUseCase;
import br.com.grupomateus.product.api.application.usecase.update.UpdateProdutoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final UseCaseFactory useCaseFactory;

    @PostMapping
    public ProdutoDTO criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        return useCaseFactory.getUseCase(CreateProdutoUseCase.class).execute(produtoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        UpdateProdutoUseCase.InputValues input = new UpdateProdutoUseCase.InputValues(id, produtoDTO);
        ProdutoDTO atualizado = useCaseFactory.getUseCase(UpdateProdutoUseCase.class).execute(input);
        if (atualizado != null) {
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerProduto(@PathVariable Long id) {
        useCaseFactory.getUseCase(DeleteProdutoUseCase.class).execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public PageResultDTO<ProdutoDTO> listarTodos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageRequestDTO pageRequestDTO = new PageRequestDTO(page, size);
        return useCaseFactory.getUseCase(ListProdutoUseCase.class).execute(pageRequestDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> obterPorId(@PathVariable Long id) {
        Optional<ProdutoDTO> produto = useCaseFactory.getUseCase(GetProdutoUseCase.class).execute(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
