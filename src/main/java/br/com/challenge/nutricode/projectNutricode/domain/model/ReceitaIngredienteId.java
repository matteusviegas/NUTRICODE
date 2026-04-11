package br.com.challenge.nutricode.projectNutricode.domain.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReceitaIngredienteId implements Serializable {

    private Long receitaId;
    private Long ingredienteId;
}