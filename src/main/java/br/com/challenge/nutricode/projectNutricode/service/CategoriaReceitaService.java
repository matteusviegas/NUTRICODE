package br.com.challenge.nutricode.projectNutricode.service;

import br.com.challenge.nutricode.projectNutricode.domain.model.CategoriaReceita;
import br.com.challenge.nutricode.projectNutricode.domain.model.repository.CategoriaReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaReceitaService {

    private final CategoriaReceitaRepository categoriaReceitaRepository;

    public CategoriaReceita salvar(CategoriaReceita categoriaReceita) {
        return categoriaReceitaRepository.save(categoriaReceita);
    }

    public List<CategoriaReceita> listarTodas() {
        return categoriaReceitaRepository.findAll();
    }

    public Optional<CategoriaReceita> buscarPorId(Long id) {
        return categoriaReceitaRepository.findById(id);
    }

    public CategoriaReceita atualizar(Long id, CategoriaReceita categoriaReceita) {
        CategoriaReceita existente = categoriaReceitaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        existente.setNome(categoriaReceita.getNome());
        existente.setDescricao(categoriaReceita.getDescricao());

        return categoriaReceitaRepository.save(existente);
    }

    public void deletar(Long id) {
        categoriaReceitaRepository.deleteById(id);
    }
}