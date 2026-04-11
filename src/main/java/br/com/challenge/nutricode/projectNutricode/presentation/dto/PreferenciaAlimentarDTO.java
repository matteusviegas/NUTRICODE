package br.com.challenge.nutricode.projectNutricode.presentation.dto;

import br.com.challenge.nutricode.projectNutricode.domain.model.PreferenciaAlimentar;
import br.com.challenge.nutricode.projectNutricode.domain.model.Usuario;
import jakarta.validation.Valid;
import lombok.*;
@Valid
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreferenciaAlimentarDTO {

    private Long id;
    private String nomePreferencia;
    private Long usuarioId;

    public static PreferenciaAlimentarDTO fromEntity(PreferenciaAlimentar entity) {
        return PreferenciaAlimentarDTO.builder()
                .id(entity.getId())
                .nomePreferencia(entity.getNomePreferencia())
                .usuarioId(entity.getUsuario() != null ? entity.getUsuario().getId() : null)
                .build();
    }

    public static PreferenciaAlimentar toEntity(PreferenciaAlimentarDTO dto) {
        PreferenciaAlimentar entity = PreferenciaAlimentar.builder()
                .id(dto.getId())
                .nomePreferencia(dto.getNomePreferencia())
                .build();

        if (dto.getUsuarioId() != null) {
            Usuario usuario = new Usuario();
            usuario.setId(dto.getUsuarioId());
            entity.setUsuario(usuario);
        }

        return entity;
    }
}