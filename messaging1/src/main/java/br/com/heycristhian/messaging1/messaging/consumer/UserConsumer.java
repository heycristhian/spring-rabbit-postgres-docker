package br.com.heycristhian.messaging1.messaging.consumer;

import br.com.heycristhian.messaging1.domain.User;
import br.com.heycristhian.messaging1.usecase.UpdateUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserConsumer {

    private final UpdateUser updateUser;

    public UserConsumer(UpdateUser updateUser) {
        this.updateUser = updateUser;
    }

    @RabbitListener(queues = "user.messaging1")
    public void consumeMessage(User user) {
        log.info("Message received: " + user);
        updateUser.execute(user);
    }
}
