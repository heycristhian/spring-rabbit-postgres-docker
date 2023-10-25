package br.com.heycristhian.main.messaging.producer;

import br.com.heycristhian.main.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserProducer {
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbit.messaging1.exchange.name}")
    private String exchangeName;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(User user) {
        log.info("Sending message: " + user.toString());
        rabbitTemplate.convertAndSend(exchangeName, "", user);
        log.info("Message sent successfully ");
    }
}
