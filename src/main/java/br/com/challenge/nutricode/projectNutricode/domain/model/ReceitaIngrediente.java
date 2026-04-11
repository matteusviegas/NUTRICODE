package br.com.challenge.nutricode.projectNutricode.domain.model;

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
    private Double quantidade;
}