package br.com.challenge.nutricode.projectNutricode.presentation.dto.controller;

import br.com.challenge.nutricode.projectNutricode.domain.model.AvaliacaoReceita;
import br.com.challenge.nutricode.projectNutricode.presentation.dto.AvaliacaoReceitaDTO;
import br.com.challenge.nutricode.projectNutricode.service.AvaliacaoReceitaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes-receita")
@RequiredArgsConstructor
public class AvaliacaoReceitaController {

    private final AvaliacaoReceitaService service;

    @GetMapping
    public ResponseEntity<List<AvaliacaoReceitaDTO>> listarTodas() {
        List<AvaliacaoReceitaDTO> lista = service.listarTodas()
                .stream()
                .map(AvaliacaoReceitaDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoReceitaDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(item -> ResponseEntity.ok(AvaliacaoReceitaDTO.fromEntity(item)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<AvaliacaoReceitaDTO>> buscarPorUsuario(@PathVariable Long usuarioId) {
        List<AvaliacaoReceitaDTO> lista = service.buscarPorUsuarioId(usuarioId)
                .stream()
                .map(AvaliacaoReceitaDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/receita/{receitaId}")
    public ResponseEntity<List<AvaliacaoReceitaDTO>> buscarPorReceita(@PathVariable Long receitaId) {
        List<AvaliacaoReceitaDTO> lista = service.buscarPorReceitaId(receitaId)
                .stream()
                .map(AvaliacaoReceitaDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<AvaliacaoReceitaDTO> salvar(@RequestBody AvaliacaoReceitaDTO dto) {
        AvaliacaoReceita salvo = service.salvar(AvaliacaoReceitaDTO.toEntity(dto));
        return ResponseEntity.ok(AvaliacaoReceitaDTO.fromEntity(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoReceitaDTO> atualizar(@PathVariable Long id,
                                                         @RequestBody AvaliacaoReceitaDTO dto) {
        AvaliacaoReceita atualizado = service.atualizar(id, AvaliacaoReceitaDTO.toEntity(dto));
        return ResponseEntity.ok(AvaliacaoReceitaDTO.fromEntity(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}