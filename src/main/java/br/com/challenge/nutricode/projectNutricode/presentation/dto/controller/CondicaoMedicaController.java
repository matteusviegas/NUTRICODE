package br.com.challenge.nutricode.projectNutricode.presentation.dto.controller;

import br.com.challenge.nutricode.projectNutricode.domain.model.CondicaoMedica;
import br.com.challenge.nutricode.projectNutricode.presentation.dto.CondicaoMedicaDTO;
import br.com.challenge.nutricode.projectNutricode.service.CondicaoMedicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/condicoes-medicas")
@RequiredArgsConstructor
public class CondicaoMedicaController {

    private final CondicaoMedicaService service;

    @GetMapping
    public ResponseEntity<List<CondicaoMedicaDTO>> listarTodas() {
        List<CondicaoMedicaDTO> lista = service.listarTodas()
                .stream()
                .map(CondicaoMedicaDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CondicaoMedicaDTO> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(item -> ResponseEntity.ok(CondicaoMedicaDTO.fromEntity(item)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<CondicaoMedicaDTO>> buscarPorUsuario(@PathVariable Long usuarioId) {
        List<CondicaoMedicaDTO> lista = service.buscarPorUsuarioId(usuarioId)
                .stream()
                .map(CondicaoMedicaDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<CondicaoMedicaDTO> salvar(@RequestBody CondicaoMedicaDTO dto) {
        CondicaoMedica salvo = service.salvar(CondicaoMedicaDTO.toEntity(dto));
        return ResponseEntity.ok(CondicaoMedicaDTO.fromEntity(salvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CondicaoMedicaDTO> atualizar(@PathVariable Long id,
                                                       @RequestBody CondicaoMedicaDTO dto) {
        CondicaoMedica atualizado = service.atualizar(id, CondicaoMedicaDTO.toEntity(dto));
        return ResponseEntity.ok(CondicaoMedicaDTO.fromEntity(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}