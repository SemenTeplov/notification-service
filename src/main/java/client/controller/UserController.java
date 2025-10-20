package client.controller;

import client.manager.OrderManager;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/email")
public class UserController {
    private final OrderManager manager;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmail(@RequestBody String email) {
        manager.placeOrder(email, "Здравствуйте! Ваш аккаунт на сайте ваш сайт был успешно создан.");
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteMail(@RequestBody String email) {
        manager.placeOrder(email, "Здравствуйте! Ваш аккаунт был удалён.");
    }
}
