package br.com.challenge.nutricode.projectNutricode.domain.model.repository;

import br.com.challenge.nutricode.projectNutricode.domain.model.HistoricoConsumo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoConsumoRepository extends JpaRepository<HistoricoConsumo, Long> {
    List<HistoricoConsumo> findByUsuarioId(Long usuarioId);
    List<HistoricoConsumo> findByReceitaId(Long receitaId);
}