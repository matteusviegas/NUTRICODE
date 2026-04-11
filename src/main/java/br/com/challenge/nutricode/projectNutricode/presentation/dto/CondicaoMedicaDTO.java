package br.com.challenge.nutricode.projectNutricode.presentation.dto;

import br.com.challenge.nutricode.projectNutricode.domain.model.CondicaoMedica;
import br.com.challenge.nutricode.projectNutricode.domain.model.Usuario;
import jakarta.validation.Valid;
import lombok.*;
@Valid
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CondicaoMedicaDTO {

    private Long id;
    private String descricaoMedica;
    private Long usuarioId;

    public static CondicaoMedicaDTO fromEntity(CondicaoMedica entity) {
        return CondicaoMedicaDTO.builder()
                .id(entity.getId())
                .descricaoMedica(entity.getDescricaoMedica())
                .usuarioId(entity.getUsuario() != null ? entity.getUsuario().getId() : null)
                .build();
    }

    public static CondicaoMedica toEntity(CondicaoMedicaDTO dto) {
        CondicaoMedica entity = CondicaoMedica.builder()
                .id(dto.getId())
                .descricaoMedica(dto.getDescricaoMedica())
                .build();

        if (dto.getUsuarioId() != null) {
            Usuario usuario = new Usuario();
            usuario.setId(dto.getUsuarioId());
            entity.setUsuario(usuario);
        }

        return entity;
    }
}