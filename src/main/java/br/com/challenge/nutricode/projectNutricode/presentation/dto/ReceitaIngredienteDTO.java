package br.com.challenge.nutricode.projectNutricode.presentation.dto;

import jakarta.validation.Valid;
import lombok.*;
@Valid
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceitaIngredienteDTO {

    private Long receitaId;
    private Long ingredienteId;
    private Double quantidade;
}