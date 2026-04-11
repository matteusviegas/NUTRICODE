package br.com.challenge.nutricode.projectNutricode.domain.model.repository;

import br.com.challenge.nutricode.projectNutricode.domain.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}