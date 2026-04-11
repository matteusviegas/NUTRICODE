package br.com.challenge.nutricode.projectNutricode.domain.model.repository;

import br.com.challenge.nutricode.projectNutricode.domain.model.CondicaoMedica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CondicaoMedicaRepository extends JpaRepository<CondicaoMedica, Long> {
    List<CondicaoMedica> findByUsuarioId(Long usuarioId);
}