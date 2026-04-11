package br.com.challenge.nutricode.projectNutricode.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Condicao_medica_sp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CondicaoMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_condicao")
    private Long id;

    @Column(name = "descricao_medica", length = 150)
    private String descricaoMedica;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}