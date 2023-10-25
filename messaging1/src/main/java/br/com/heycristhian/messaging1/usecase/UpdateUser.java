package br.com.heycristhian.messaging1.usecase;

import br.com.heycristhian.messaging1.domain.Status;
import br.com.heycristhian.messaging1.domain.User;
import br.com.heycristhian.messaging1.messaging.producer.UserProducer;
import br.com.heycristhian.messaging1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class UpdateUser {

    private final UserRepository userRepository;
    private final UserProducer userProducer;

    public void execute(User user) {
        log.info("Updating user object");
        user.setStatus(Status.MESSAGING1);

        log.info("Saving user to database");
        var userSaved = userRepository.save(user);

        userProducer.send(userSaved);
    }
}
