package br.com.heycristhian.main.controller;

import br.com.heycristhian.main.domain.User;
import br.com.heycristhian.main.usecase.UpdateUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UpdateUser updateUser;

    public UserController(UpdateUser updateUser) {
        this.updateUser = updateUser;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody User user) {
        updateUser.execute(user);
        return ResponseEntity.ok().build();
    }
}
