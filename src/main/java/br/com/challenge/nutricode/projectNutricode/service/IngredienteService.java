package br.com.challenge.nutricode.projectNutricode.service;

import br.com.challenge.nutricode.projectNutricode.domain.model.Ingrediente;
import br.com.challenge.nutricode.projectNutricode.domain.model.repository.IngredienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;

    public Ingrediente salvar(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    public List<Ingrediente> listarTodos() {
        return ingredienteRepository.findAll();
    }

    public Optional<Ingrediente> buscarPorId(Long id) {
        return ingredienteRepository.findById(id);
    }

    public Ingrediente atualizar(Long id, Ingrediente ingrediente) {
        Ingrediente existente = ingredienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingrediente não encontrado"));

        existente.setNome(ingrediente.getNome());
        existente.setProteinaPor100g(ingrediente.getProteinaPor100g());
        existente.setCarboidratosPor100g(ingrediente.getCarboidratosPor100g());
        existente.setGordurasPor100g(ingrediente.getGordurasPor100g());
        existente.setCaloriasPor100g(ingrediente.getCaloriasPor100g());

        return ingredienteRepository.save(existente);
    }

    public void deletar(Long id) {
        ingredienteRepository.deleteById(id);
    }
}