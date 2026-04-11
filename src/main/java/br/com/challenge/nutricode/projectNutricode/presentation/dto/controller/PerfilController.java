package br.com.challenge.nutricode.projectNutricode.presentation.dto.controller;

import br.com.challenge.nutricode.projectNutricode.domain.model.Perfil;
import br.com.challenge.nutricode.projectNutricode.presentation.dto.PerfilDTO;
import br.com.challenge.nutricode.projectNutricode.service.PerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfis")
@RequiredArgsConstructor
public class PerfilController {

    private final PerfilService perfilService;

    @GetMapping
    public ResponseEntity<List<PerfilDTO>> listarTodos() {
        List<PerfilDTO> perfis = perfilService.listarTodos()
                .stream()
                .map(PerfilDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(perfis);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilDTO> buscarPorId(@PathVariable Long id) {
        return perfilService.buscarPorId(id)
                .map(perfil -> ResponseEntity.ok(PerfilDTO.fromEntity(perfil)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<PerfilDTO> buscarPorUsuarioId(@PathVariable Long usuarioId) {
        return perfilService.buscarPorUsuarioId(usuarioId)
                .map(perfil -> ResponseEntity.ok(PerfilDTO.fromEntity(perfil)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PerfilDTO> salvar(@RequestBody PerfilDTO dto) {
        Perfil perfilSalvo = perfilService.salvar(PerfilDTO.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(PerfilDTO.fromEntity(perfilSalvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PerfilDTO> atualizar(@PathVariable Long id, @RequestBody PerfilDTO dto) {
        if (!perfilService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Perfil perfilAtualizado = perfilService.atualizar(id, PerfilDTO.toEntity(dto));
        return ResponseEntity.ok(PerfilDTO.fromEntity(perfilAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!perfilService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        perfilService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}