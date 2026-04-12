package br.com.challenge.nutricode.projectNutricode.presentation.dto;

import br.com.challenge.nutricode.projectNutricode.domain.model.Receita;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceitaResumoDTO {

    private Long id;
    private String nome;
    private Double valorCalorico;
    private Double proteinaTotal;
    private Double carboTotal;
    private Double gorduraTotal;

    public static ReceitaResumoDTO fromEntity(Receita receita) {
        return ReceitaResumoDTO.builder()
                .id(receita.getId())
                .nome(receita.getNome())
                .valorCalorico(receita.getValorCalorico())
                .proteinaTotal(receita.getProteinaTotal())
                .carboTotal(receita.getCarboTotal())
                .gorduraTotal(receita.getGorduraTotal())
                .build();
    }
}