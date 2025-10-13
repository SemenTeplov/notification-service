package client.handler;

import lombok.extern.slf4j.Slf4j;

import client.manager.OrderManager;
import client.manager.SimpleOrderManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserCreatedEventHandler {
    private final OrderManager orderManager;

    @Autowired
    public UserCreatedEventHandler(SimpleOrderManager orderManager) {
        this.orderManager = orderManager;
    }

    @KafkaListener(topics = "user-created-events-topic", groupId = "user-created-events")
    public void handleCreated(String event) {
        if (event != null) {
            String createdText = "Здравствуйте! Ваш аккаунт на сайте ваш сайт был успешно создан.";

            log.info("{} Hello! Your account on the website was created success.", event);

            orderManager.placeOrder(event, createdText);
        }
    }

    @KafkaListener(topics = "user-deleted-events-topic", groupId = "user-created-events")
    public void handleDeleted(String event) {
        if (event != null) {
            String deletedText = "Здравствуйте! Ваш аккаунт был удалён.";

            log.info("{} Hello! Your account was deleted", event);

            orderManager.placeOrder(event, deletedText);
        }
    }
}
