package nl.hu.bep3.kees.orders.infrastructure.driven.messaging;

import nl.hu.bep3.kees.orders.core.domain.events.OrderEvent;
import nl.hu.bep3.kees.orders.core.ports.messaging.OrderEventPublisher;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitMqEventPublisher implements OrderEventPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final String restaurantExchange;

    public RabbitMqEventPublisher(
            RabbitTemplate rabbitTemplate,
            String restaurantExchange
    ) {
        this.rabbitTemplate = rabbitTemplate;
        this.restaurantExchange = restaurantExchange;
    }

    public void publish(OrderEvent event) {
        this.rabbitTemplate.convertAndSend(restaurantExchange, event.getEventKey(), event);
    }
}
