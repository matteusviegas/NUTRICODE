package br.com.challenge.nutricode.projectNutricode.domain.model.repository;

import br.com.challenge.nutricode.projectNutricode.domain.model.AvaliacaoReceita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AvaliacaoReceitaRepository extends JpaRepository<AvaliacaoReceita, Long> {
    List<AvaliacaoReceita> findByUsuarioId(Long usuarioId);
    List<AvaliacaoReceita> findByReceitaId(Long receitaId);
}