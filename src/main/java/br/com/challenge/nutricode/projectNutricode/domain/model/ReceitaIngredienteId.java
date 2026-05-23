package br.com.challenge.nutricode.projectNutricode.domain.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReceitaIngredienteId implements Serializable {

    private Long receitaId;
    private Long ingredienteId;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ReceitaIngredienteId that))
            return false;

        return Objects.equals(receitaId, that.receitaId)
                && Objects.equals(ingredienteId, that.ingredienteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receitaId, ingredienteId);
    }

}
