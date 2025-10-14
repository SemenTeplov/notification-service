package client.controller;

import client.manager.OrderManager;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final OrderManager manager;

    @PostMapping("/email")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmail(@RequestBody String email) {
        manager.placeOrder(email, "Здравствуйте! Ваш аккаунт на сайте ваш сайт был успешно создан.");
    }

    @DeleteMapping("/email")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMail(@RequestBody String email) {
        manager.placeOrder(email, "Здравствуйте! Ваш аккаунт был удалён.");
    }
}
