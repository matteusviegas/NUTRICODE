package br.com.challenge.nutricode.projectNutricode.domain.model.repository;

import br.com.challenge.nutricode.projectNutricode.domain.model.ReceitaIngrediente;
import br.com.challenge.nutricode.projectNutricode.domain.model.ReceitaIngredienteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaIngredienteRepository
        extends JpaRepository<ReceitaIngrediente, ReceitaIngredienteId> {
}