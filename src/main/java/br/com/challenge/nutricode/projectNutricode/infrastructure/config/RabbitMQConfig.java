package br.com.challenge.nutricode.projectNutricode.infrastructure.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FILA_HISTORICO = "fila.historico.consumo";

    @Bean
    public Queue filaHistoricoConsumo() {
        return new Queue(FILA_HISTORICO, true);
    }
}