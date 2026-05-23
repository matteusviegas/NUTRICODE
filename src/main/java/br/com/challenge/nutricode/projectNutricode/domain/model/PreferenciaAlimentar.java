package br.com.challenge.nutricode.projectNutricode.domain.model;

import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Preferencia_alimentar_sp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreferenciaAlimentar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_preferencia")
    private Long id;

    @Column(name = "nome_preferencia", length = 100)
    private String nomePreferencia;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof PreferenciaAlimentar that))
            return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
