package br.com.challenge.nutricode.projectNutricode.service;

import br.com.challenge.nutricode.projectNutricode.domain.model.CategoriaReceita;
import br.com.challenge.nutricode.projectNutricode.domain.model.Receita;
import br.com.challenge.nutricode.projectNutricode.domain.model.repository.CategoriaReceitaRepository;
import br.com.challenge.nutricode.projectNutricode.domain.model.repository.ReceitaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReceitaService {

    private final ReceitaRepository receitaRepository;
    private final CategoriaReceitaRepository categoriaReceitaRepository;

    public Receita salvar(Receita receita) {
        if (receita.getCategoria() == null || receita.getCategoria().getId() == null) {
            throw new RuntimeException("Receita precisa estar ligada a uma categoria");
        }

        Long categoriaId = receita.getCategoria().getId();

        CategoriaReceita categoria = categoriaReceitaRepository.findById(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        receita.setCategoria(categoria);
        return receitaRepository.save(receita);
    }

    public List<Receita> listarTodas() {
        return receitaRepository.findAll();
    }

    public Optional<Receita> buscarPorId(Long id) {
        return receitaRepository.findById(id);
    }

    public Receita atualizar(Long id, Receita receita) {
        Receita existente = receitaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receita não encontrada"));

        existente.setNome(receita.getNome());
        existente.setDescricao(receita.getDescricao());
        existente.setModoPreparo(receita.getModoPreparo());
        existente.setTempoPreparo(receita.getTempoPreparo());
        existente.setValorCalorico(receita.getValorCalorico());
        existente.setProteinaTotal(receita.getProteinaTotal());
        existente.setCarboTotal(receita.getCarboTotal());
        existente.setGorduraTotal(receita.getGorduraTotal());
        existente.setIndiceGlicemico(receita.getIndiceGlicemico());

        if (receita.getCategoria() != null && receita.getCategoria().getId() != null) {
            CategoriaReceita categoria = categoriaReceitaRepository.findById(receita.getCategoria().getId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
            existente.setCategoria(categoria);
        }

        return receitaRepository.save(existente);
    }

    public void deletar(Long id) {
        receitaRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return receitaRepository.existsById(id);
    }
}