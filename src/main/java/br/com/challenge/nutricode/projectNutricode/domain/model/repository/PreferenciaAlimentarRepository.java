package br.com.challenge.nutricode.projectNutricode.domain.model.repository;

import br.com.challenge.nutricode.projectNutricode.domain.model.PreferenciaAlimentar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreferenciaAlimentarRepository extends JpaRepository<PreferenciaAlimentar, Long> {
    List<PreferenciaAlimentar> findByUsuarioId(Long usuarioId);
}