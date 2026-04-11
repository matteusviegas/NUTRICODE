package br.com.challenge.nutricode.projectNutricode.presentation.dto.controller;

import br.com.challenge.nutricode.projectNutricode.domain.model.Usuario;
import br.com.challenge.nutricode.projectNutricode.presentation.dto.UsuarioDTO;
import br.com.challenge.nutricode.projectNutricode.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listarTodos() {
        List<UsuarioDTO> usuarios = usuarioService.listarTodos()
                .stream()
                .map(UsuarioDTO::fromEntity)
                .toList();

        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(usuario -> ResponseEntity.ok(UsuarioDTO.fromEntity(usuario)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> salvar(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuarioSalvo = usuarioService.salvar(UsuarioDTO.toEntity(usuarioDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioDTO.fromEntity(usuarioSalvo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long id,
                                                @Valid @RequestBody UsuarioDTO usuarioDTO) {
        if (!usuarioService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        Usuario usuarioAtualizado = usuarioService.atualizar(id, UsuarioDTO.toEntity(usuarioDTO));
        return ResponseEntity.ok(UsuarioDTO.fromEntity(usuarioAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!usuarioService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        usuarioService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}