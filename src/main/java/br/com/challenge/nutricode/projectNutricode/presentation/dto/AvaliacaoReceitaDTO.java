package br.com.challenge.nutricode.projectNutricode.presentation.dto;

import br.com.challenge.nutricode.projectNutricode.domain.model.AvaliacaoReceita;
import br.com.challenge.nutricode.projectNutricode.domain.model.Receita;
import br.com.challenge.nutricode.projectNutricode.domain.model.Usuario;
import jakarta.validation.Valid;
import lombok.*;
@Valid
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvaliacaoReceitaDTO {

    private Long id;
    private Integer nota;
    private String comentario;
    private Long usuarioId;
    private Long receitaId;

    public static AvaliacaoReceitaDTO fromEntity(AvaliacaoReceita entity) {
        return AvaliacaoReceitaDTO.builder()
                .id(entity.getId())
                .nota(entity.getNota())
                .comentario(entity.getComentario())
                .usuarioId(entity.getUsuario() != null ? entity.getUsuario().getId() : null)
                .receitaId(entity.getReceita() != null ? entity.getReceita().getId() : null)
                .build();
    }

    public static AvaliacaoReceita toEntity(AvaliacaoReceitaDTO dto) {
        AvaliacaoReceita entity = AvaliacaoReceita.builder()
                .id(dto.getId())
                .nota(dto.getNota())
                .comentario(dto.getComentario())
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