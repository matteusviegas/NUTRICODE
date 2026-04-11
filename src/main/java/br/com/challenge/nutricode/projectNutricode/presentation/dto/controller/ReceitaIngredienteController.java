package br.com.challenge.nutricode.projectNutricode.presentation.dto.controller;

import br.com.challenge.nutricode.projectNutricode.domain.model.ReceitaIngrediente;
import br.com.challenge.nutricode.projectNutricode.presentation.dto.ReceitaIngredienteDTO;
import br.com.challenge.nutricode.projectNutricode.service.ReceitaIngredienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/receita-ingredientes")
@RequiredArgsConstructor
public class ReceitaIngredienteController {

    private final ReceitaIngredienteService service;

    @PostMapping
    public ResponseEntity<ReceitaIngrediente> salvar(@RequestBody ReceitaIngredienteDTO dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }
}