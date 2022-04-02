package nl.hu.bep3.kees.orders.infrastructure.driven.messaging;

import nl.hu.bep3.kees.orders.core.domain.events.OrderEvent;
import nl.hu.bep3.kees.orders.core.ports.messaging.OrderEventPublisher;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitMqEventPublisher implements OrderEventPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final String orderExchange;

    public RabbitMqEventPublisher(
            RabbitTemplate rabbitTemplate,
            String orderExchange
    ) {
        this.rabbitTemplate = rabbitTemplate;
        this.orderExchange = orderExchange;
    }

    public void publish(OrderEvent event) {
        this.rabbitTemplate.convertAndSend(orderExchange, event.getEventKey(), event);
    }
}
