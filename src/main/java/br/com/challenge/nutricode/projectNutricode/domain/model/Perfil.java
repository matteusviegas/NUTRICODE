package br.com.challenge.nutricode.projectNutricode.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Perfil_sp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_perfil")
    private Long id;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "peso")
    private BigDecimal peso;

    @Column(name = "altura")
    private BigDecimal altura;

    @Column(name = "objetivo", length = 100)
    private String objetivo;

    @OneToOne
    @JoinColumn(name = "id_usuario", unique = true)
    private Usuario usuario;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Perfil that))
            return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}