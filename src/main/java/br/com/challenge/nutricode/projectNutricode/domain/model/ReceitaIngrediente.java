package br.com.challenge.nutricode.projectNutricode.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Receita_ingrediente_sp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceitaIngrediente {

    @EmbeddedId
    private ReceitaIngredienteId id;

    @ManyToOne
    @MapsId("receitaId")
    @JoinColumn(name = "id_receita")
    private Receita receita;

    @ManyToOne
    @MapsId("ingredienteId")
    @JoinColumn(name = "id_ingrediente")
    private Ingrediente ingrediente;

    @Column(name = "quantidade")
    private BigDecimal quantidade;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ReceitaIngrediente that))
            return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
