package br.com.challenge.nutricode.projectNutricode.presentation.dto;

import br.com.challenge.nutricode.projectNutricode.domain.model.Perfil;
import jakarta.validation.Valid;
import lombok.*;
@Valid
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerfilDTO {

    private Long id;
    private Integer idade;
    private Double peso;
    private Double altura;
    private String objetivo;
    private Long usuarioId;

    public static PerfilDTO fromEntity(Perfil perfil) {
        return PerfilDTO.builder()
                .id(perfil.getId())
                .idade(perfil.getIdade())
                .peso(perfil.getPeso())
                .altura(perfil.getAltura())
                .objetivo(perfil.getObjetivo())
                .usuarioId(perfil.getUsuario() != null ? perfil.getUsuario().getId() : null)
                .build();
    }

    public static Perfil toEntity(PerfilDTO dto) {
        return Perfil.builder()
                .id(dto.getId())
                .idade(dto.getIdade())
                .peso(dto.getPeso())
                .altura(dto.getAltura())
                .objetivo(dto.getObjetivo())
                .build();
    }
}