package br.com.challenge.nutricode.projectNutricode.domain.model;

import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Avaliacao_receita_sp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvaliacaoReceita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avaliacao")
    private Long id;

    @Column(name = "nota_1a10")
    private Integer nota;

    @Column(name = "comentario", length = 400)
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_receita")
    private Receita receita;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AvaliacaoReceita that))
            return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
