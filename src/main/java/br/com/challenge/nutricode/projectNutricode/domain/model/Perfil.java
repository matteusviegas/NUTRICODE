package br.com.challenge.nutricode.projectNutricode.domain.model;

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
    private Double peso;

    @Column(name = "altura")
    private Double altura;

    @Column(name = "objetivo", length = 100)
    private String objetivo;

    @OneToOne
    @JoinColumn(name = "id_usuario", unique = true)
    private Usuario usuario;
}