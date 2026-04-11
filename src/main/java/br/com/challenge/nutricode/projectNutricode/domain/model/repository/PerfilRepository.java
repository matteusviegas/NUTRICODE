package br.com.challenge.nutricode.projectNutricode.domain.model.repository;

import br.com.challenge.nutricode.projectNutricode.domain.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {

    Optional<Perfil> findByUsuarioId(Long usuarioId);

    boolean existsByUsuarioId(Long usuarioId);
}