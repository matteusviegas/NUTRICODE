package br.com.challenge.nutricode.projectNutricode.presentation.dto.controller;

import br.com.challenge.nutricode.projectNutricode.domain.model.CategoriaReceita;
import br.com.challenge.nutricode.projectNutricode.service.CategoriaReceitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias-receita")
@RequiredArgsConstructor
public class CategoriaReceitaController {

    private final CategoriaReceitaService categoriaReceitaService;

    @PostMapping
    public ResponseEntity<CategoriaReceita> criar(@RequestBody CategoriaReceita categoriaReceita) {
        return ResponseEntity.ok(categoriaReceitaService.salvar(categoriaReceita));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaReceita>> listar() {
        return ResponseEntity.ok(categoriaReceitaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaReceita> buscar(@PathVariable Long id) {
        return categoriaReceitaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaReceita> atualizar(@PathVariable Long id,
                                                      @RequestBody CategoriaReceita categoriaReceita) {
        return ResponseEntity.ok(categoriaReceitaService.atualizar(id, categoriaReceita));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaReceitaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}