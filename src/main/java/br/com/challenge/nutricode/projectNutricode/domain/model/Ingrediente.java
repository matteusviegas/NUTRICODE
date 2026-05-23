package br.com.challenge.nutricode.projectNutricode.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Ingrediente_sp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingrediente")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "proteina_por100g")
    private BigDecimal proteinaPor100g;

    @Column(name = "carboidratos_por100g")
    private BigDecimal carboidratosPor100g;

    @Column(name = "gorduras_por100g")
    private BigDecimal gordurasPor100g;

    @Column(name = "calorias_por100g")
    private BigDecimal caloriasPor100g;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Ingrediente that))
            return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
