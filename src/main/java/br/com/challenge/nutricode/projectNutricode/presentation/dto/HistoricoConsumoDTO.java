package br.com.challenge.nutricode.projectNutricode.presentation.dto;

import br.com.challenge.nutricode.projectNutricode.domain.model.HistoricoConsumo;
import br.com.challenge.nutricode.projectNutricode.domain.model.Receita;
import br.com.challenge.nutricode.projectNutricode.domain.model.Usuario;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;
@Valid
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricoConsumoDTO {

    private Long id;
    private Long usuarioId;
    private Long receitaId;
    private LocalDate dataConsumo;
    private Double quantidade;

    public static HistoricoConsumoDTO fromEntity(HistoricoConsumo entity) {
        return HistoricoConsumoDTO.builder()
                .id(entity.getId())
                .usuarioId(entity.getUsuario() != null ? entity.getUsuario().getId() : null)
                .receitaId(entity.getReceita() != null ? entity.getReceita().getId() : null)
                .dataConsumo(entity.getDataConsumo())
                .quantidade(entity.getQuantidade())
                .build();
    }

    public static HistoricoConsumo toEntity(HistoricoConsumoDTO dto) {
        HistoricoConsumo entity = HistoricoConsumo.builder()
                .id(dto.getId())
                .dataConsumo(dto.getDataConsumo())
                .quantidade(dto.getQuantidade())
                .build();

        if (dto.getUsuarioId() != null) {
            Usuario usuario = new Usuario();
            usuario.setId(dto.getUsuarioId());
            entity.setUsuario(usuario);
        }

        if (dto.getReceitaId() != null) {
            Receita receita = new Receita();
            receita.setId(dto.getReceitaId());
            entity.setReceita(receita);
        }

        return entity;
    }
}