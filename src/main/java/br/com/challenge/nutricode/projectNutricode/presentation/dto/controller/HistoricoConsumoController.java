package br.com.challenge.nutricode.projectNutricode.presentation.dto.controller;

import br.com.challenge.nutricode.projectNutricode.domain.model.HistoricoConsumo;
import br.com.challenge.nutricode.projectNutricode.presentation.dto.HistoricoConsumoDTO;
import br.com.challenge.nutricode.projectNutricode.service.HistoricoConsumoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historicos-consumo")
@RequiredArgsConstructor
public class HistoricoConsumoController {

    private final HistoricoConsumoService service;

    @GetMapping
    public ResponseEntity<List<HistoricoConsumoDTO>> listarTodos() {
        List<HistoricoConsumoDTO> lista = service.listarTodos()
                .stream()
                .map(HistoricoConsumoDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoConsumoDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(item -> ResponseEntity.ok(HistoricoConsumoDTO.fromEntity(item)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<HistoricoConsumoDTO>> buscarPorUsuario(@PathVariable Long usuarioId) {
        List<HistoricoConsumoDTO> lista = service.buscarPorUsuarioId(usuarioId)
                .stream()
                .map(HistoricoConsumoDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/receita/{receitaId}")
    public ResponseEntity<List<HistoricoConsumoDTO>> buscarPorReceita(@PathVariable Long receitaId) {
        List<HistoricoConsumoDTO> lista = service.buscarPorReceitaId(receitaId)
                .stream()
                .map(HistoricoConsumoDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<HistoricoConsumoDTO> salvar(@RequestBody HistoricoConsumoDTO dto) {
        HistoricoConsumo salvo = service.salvar(HistoricoConsumoDTO.toEntity(dto));
        return ResponseEntity.ok(HistoricoConsumoDTO.fromEntity(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoricoConsumoDTO> atualizar(@PathVariable Long id,
                                                         @RequestBody HistoricoConsumoDTO dto) {
        HistoricoConsumo atualizado = service.atualizar(id, HistoricoConsumoDTO.toEntity(dto));
        return ResponseEntity.ok(HistoricoConsumoDTO.fromEntity(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}