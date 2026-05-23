package br.com.challenge.nutricode.projectNutricode.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

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
    private BigDecimal valorCalorico;

    @Column(name = "proteina_total")
    private BigDecimal proteinaTotal;

    @Column(name = "carbo_total")
    private BigDecimal carboTotal;

    @Column(name = "gordura_total")
    private BigDecimal gorduraTotal;

    @Column(name = "indice_glicemico", length = 10)
    private String indiceGlicemico;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaReceita categoria;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Receita that))
            return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
