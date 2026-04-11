package br.com.challenge.nutricode.projectNutricode.domain.model;

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
    private Double proteinaPor100g;

    @Column(name = "carboidratos_por100g")
    private Double carboidratosPor100g;

    @Column(name = "gorduras_por100g")
    private Double gordurasPor100g;

    @Column(name = "calorias_por100g")
    private Double caloriasPor100g;
}