package br.com.challenge.nutricode.projectNutricode.service;

import br.com.challenge.nutricode.projectNutricode.domain.model.*;
import br.com.challenge.nutricode.projectNutricode.domain.model.repository.*;
import br.com.challenge.nutricode.projectNutricode.presentation.dto.ReceitaIngredienteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReceitaIngredienteService {

    private final ReceitaIngredienteRepository repository;
    private final ReceitaRepository receitaRepository;
    private final IngredienteRepository ingredienteRepository;

    public ReceitaIngrediente salvar(ReceitaIngredienteDTO dto) {

        Receita receita = receitaRepository.findById(dto.getReceitaId())
                .orElseThrow(() -> new RuntimeException("Receita não encontrada"));

        Ingrediente ingrediente = ingredienteRepository.findById(dto.getIngredienteId())
                .orElseThrow(() -> new RuntimeException("Ingrediente não encontrado"));

        ReceitaIngrediente entidade = ReceitaIngrediente.builder()
                .id(new ReceitaIngredienteId(dto.getReceitaId(), dto.getIngredienteId()))
                .receita(receita)
                .ingrediente(ingrediente)
                .quantidade(dto.getQuantidade())
                .build();

        return repository.save(entidade);
    }

}
