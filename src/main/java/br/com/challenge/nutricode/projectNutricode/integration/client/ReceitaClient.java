package br.com.challenge.nutricode.projectNutricode.integration.client;

import br.com.challenge.nutricode.projectNutricode.presentation.dto.ReceitaResumoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "receitaClient", url = "http://localhost:8080")
public interface ReceitaClient {

    @GetMapping("/api/receitas/public/{id}/resumo")
    ReceitaResumoDTO buscarResumo(@PathVariable("id") Long id);
}