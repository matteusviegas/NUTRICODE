package br.com.challenge.nutricode.projectNutricode.presentation.dto.controller;

import br.com.challenge.nutricode.projectNutricode.domain.model.Ingrediente;
import br.com.challenge.nutricode.projectNutricode.service.IngredienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredientes")
@RequiredArgsConstructor
public class IngredienteController {

    private final IngredienteService ingredienteService;

    @PostMapping
    public ResponseEntity<Ingrediente> criar(@RequestBody Ingrediente ingrediente) {
        return ResponseEntity.ok(ingredienteService.salvar(ingrediente));
    }

    @GetMapping
    public ResponseEntity<List<Ingrediente>> listar() {
        return ResponseEntity.ok(ingredienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingrediente> buscar(@PathVariable Long id) {
        return ingredienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingrediente> atualizar(@PathVariable Long id, @RequestBody Ingrediente ingrediente) {
        return ResponseEntity.ok(ingredienteService.atualizar(id, ingrediente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        ingredienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}