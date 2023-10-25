package br.com.heycristhian.messaging2.usecase;

import br.com.heycristhian.messaging2.domain.Status;
import br.com.heycristhian.messaging2.domain.User;
import br.com.heycristhian.messaging2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class UpdateUser {

    private final UserRepository userRepository;

    public void execute(User user) {
        log.info("Updating user object");
        user.setStatus(Status.MESSAGING2);

        log.info("Saving user to database");
        userRepository.save(user);
    }
}
