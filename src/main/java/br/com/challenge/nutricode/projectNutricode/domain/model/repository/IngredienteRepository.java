package br.com.challenge.nutricode.projectNutricode.domain.model.repository;

import br.com.challenge.nutricode.projectNutricode.domain.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
}