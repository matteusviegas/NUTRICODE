package br.com.challenge.nutricode.projectNutricode.presentation.dto.controller;

import br.com.challenge.nutricode.projectNutricode.domain.model.PreferenciaAlimentar;
import br.com.challenge.nutricode.projectNutricode.presentation.dto.PreferenciaAlimentarDTO;
import br.com.challenge.nutricode.projectNutricode.service.PreferenciaAlimentarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/preferencias-alimentares")
@RequiredArgsConstructor
public class PreferenciaAlimentarController {

    private final PreferenciaAlimentarService service;

    @GetMapping
    public ResponseEntity<List<PreferenciaAlimentarDTO>> listarTodas() {
        List<PreferenciaAlimentarDTO> lista = service.listarTodas()
                .stream()
                .map(PreferenciaAlimentarDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreferenciaAlimentarDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(item -> ResponseEntity.ok(PreferenciaAlimentarDTO.fromEntity(item)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<PreferenciaAlimentarDTO>> buscarPorUsuario(@PathVariable Long usuarioId) {
        List<PreferenciaAlimentarDTO> lista = service.buscarPorUsuarioId(usuarioId)
                .stream()
                .map(PreferenciaAlimentarDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<PreferenciaAlimentarDTO> salvar(@RequestBody PreferenciaAlimentarDTO dto) {
        PreferenciaAlimentar salvo = service.salvar(PreferenciaAlimentarDTO.toEntity(dto));
        return ResponseEntity.ok(PreferenciaAlimentarDTO.fromEntity(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PreferenciaAlimentarDTO> atualizar(@PathVariable Long id,
                                                             @RequestBody PreferenciaAlimentarDTO dto) {
        PreferenciaAlimentar atualizado = service.atualizar(id, PreferenciaAlimentarDTO.toEntity(dto));
        return ResponseEntity.ok(PreferenciaAlimentarDTO.fromEntity(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}