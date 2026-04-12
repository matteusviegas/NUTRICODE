package br.com.challenge.nutricode.projectNutricode.messaging;

import br.com.challenge.nutricode.projectNutricode.infrastructure.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HistoricoProducer {

    private final RabbitTemplate rabbitTemplate;

    public void enviarMensagem(String mensagem) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.FILA_HISTORICO, mensagem);
    }
}