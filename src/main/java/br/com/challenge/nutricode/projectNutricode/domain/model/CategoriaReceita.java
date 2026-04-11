package br.com.challenge.nutricode.projectNutricode.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Categoria_receita_sp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaReceita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "descricao", length = 200)
    private String descricao;
}