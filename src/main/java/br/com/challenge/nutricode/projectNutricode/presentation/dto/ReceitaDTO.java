package br.com.challenge.nutricode.projectNutricode.presentation.dto;

import br.com.challenge.nutricode.projectNutricode.domain.model.CategoriaReceita;
import br.com.challenge.nutricode.projectNutricode.domain.model.Receita;
import jakarta.validation.Valid;
import lombok.*;
@Valid
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceitaDTO {

    private Long id;
    private String nome;
    private String descricao;
    private String modoPreparo;
    private Integer tempoPreparo;
    private Double valorCalorico;
    private Double proteinaTotal;
    private Double carboTotal;
    private Double gorduraTotal;
    private String indiceGlicemico;
    private Long categoriaId;

    public static ReceitaDTO fromEntity(Receita receita) {
        return ReceitaDTO.builder()
                .id(receita.getId())
                .nome(receita.getNome())
                .descricao(receita.getDescricao())
                .modoPreparo(receita.getModoPreparo())
                .tempoPreparo(receita.getTempoPreparo())
                .valorCalorico(receita.getValorCalorico())
                .proteinaTotal(receita.getProteinaTotal())
                .carboTotal(receita.getCarboTotal())
                .gorduraTotal(receita.getGorduraTotal())
                .indiceGlicemico(receita.getIndiceGlicemico())
                .categoriaId(receita.getCategoria() != null ? receita.getCategoria().getId() : null)
                .build();
    }

    public static Receita toEntity(ReceitaDTO dto) {
        Receita receita = Receita.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .modoPreparo(dto.getModoPreparo())
                .tempoPreparo(dto.getTempoPreparo())
                .valorCalorico(dto.getValorCalorico())
                .proteinaTotal(dto.getProteinaTotal())
                .carboTotal(dto.getCarboTotal())
                .gorduraTotal(dto.getGorduraTotal())
                .indiceGlicemico(dto.getIndiceGlicemico())
                .build();

        if (dto.getCategoriaId() != null) {
            CategoriaReceita categoria = new CategoriaReceita();
            categoria.setId(dto.getCategoriaId());
            receita.setCategoria(categoria);
        }

        return receita;
    }
}