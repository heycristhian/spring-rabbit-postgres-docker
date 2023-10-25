package br.com.heycristhian.messaging2.messaging.consumer;

import br.com.heycristhian.messaging2.domain.User;
import br.com.heycristhian.messaging2.usecase.UpdateUser;
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

    @RabbitListener(queues = "user.messaging2")
    public void consumeMessage(User user) {
        log.info("Message received: " + user);
        updateUser.execute(user);
    }
}
