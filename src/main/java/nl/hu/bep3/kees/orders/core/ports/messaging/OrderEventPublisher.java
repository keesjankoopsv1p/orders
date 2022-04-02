package nl.hu.bep3.kees.orders.core.ports.messaging;

import nl.hu.bep3.kees.orders.core.domain.events.OrderEvent;

public interface OrderEventPublisher {
    void publish(OrderEvent event);
}
