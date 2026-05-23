package br.com.challenge.nutricode.projectNutricode.presentation.dto;

import java.math.BigDecimal;

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
    private BigDecimal valorCalorico;
    private BigDecimal proteinaTotal;
    private BigDecimal carboTotal;
    private BigDecimal gorduraTotal;

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
