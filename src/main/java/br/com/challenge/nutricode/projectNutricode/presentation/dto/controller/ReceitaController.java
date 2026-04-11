package br.com.challenge.nutricode.projectNutricode.presentation.dto.controller;

import br.com.challenge.nutricode.projectNutricode.domain.model.Receita;
import br.com.challenge.nutricode.projectNutricode.presentation.dto.ReceitaDTO;
import br.com.challenge.nutricode.projectNutricode.service.ReceitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receitas")
@RequiredArgsConstructor
public class ReceitaController {

    private final ReceitaService receitaService;

    @GetMapping
    public ResponseEntity<List<ReceitaDTO>> listarTodas() {
        List<ReceitaDTO> receitas = receitaService.listarTodas()
                .stream()
                .map(ReceitaDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(receitas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaDTO> buscarPorId(@PathVariable Long id) {
        return receitaService.buscarPorId(id)
                .map(receita -> ResponseEntity.ok(ReceitaDTO.fromEntity(receita)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReceitaDTO> salvar(@RequestBody ReceitaDTO dto) {
        Receita receitaSalva = receitaService.salvar(ReceitaDTO.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(ReceitaDTO.fromEntity(receitaSalva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceitaDTO> atualizar(@PathVariable Long id, @RequestBody ReceitaDTO dto) {
        if (!receitaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Receita receitaAtualizada = receitaService.atualizar(id, ReceitaDTO.toEntity(dto));
        return ResponseEntity.ok(ReceitaDTO.fromEntity(receitaAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!receitaService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        receitaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}