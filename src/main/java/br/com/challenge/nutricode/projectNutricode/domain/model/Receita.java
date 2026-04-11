package br.com.challenge.nutricode.projectNutricode.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Receita_sp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receita")
    private Long id;

    @Column(name = "nome", length = 150)
    private String nome;

    @Column(name = "descricao", length = 300)
    private String descricao;

    @Column(name = "modo_preparo", length = 500)
    private String modoPreparo;

    @Column(name = "tempo_preparo")
    private Integer tempoPreparo;

    @Column(name = "valor_calorico")
    private Double valorCalorico;

    @Column(name = "proteina_total")
    private Double proteinaTotal;

    @Column(name = "carbo_total")
    private Double carboTotal;

    @Column(name = "gordura_total")
    private Double gorduraTotal;

    @Column(name = "indice_glicemico", length = 10)
    private String indiceGlicemico;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaReceita categoria;
}