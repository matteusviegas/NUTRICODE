package br.com.challenge.nutricode.projectNutricode.messaging;

import br.com.challenge.nutricode.projectNutricode.infrastructure.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HistoricoConsumer {

    @RabbitListener(queues = RabbitMQConfig.FILA_HISTORICO)
    public void consumirMensagem(String mensagem) {
        System.out.println("🔥 Mensagem recebida: " + mensagem);
    }
}