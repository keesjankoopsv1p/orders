package nl.hu.bep3.kees.orders.core.application;

import nl.hu.bep3.kees.orders.core.application.command.PlaceOrder;
import nl.hu.bep3.kees.orders.core.domain.Order;
import nl.hu.bep3.kees.orders.core.domain.events.OrderEvent;
import nl.hu.bep3.kees.orders.core.ports.messaging.OrderEventPublisher;
import nl.hu.bep3.kees.orders.core.ports.storage.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCommandHandler {
    private final OrderEventPublisher eventPublisher;
    private final OrderRepository orderRepository;

    public OrderCommandHandler(OrderEventPublisher eventPublisher, OrderRepository repository){
        this.eventPublisher = eventPublisher;
        this.orderRepository = repository;

    }

    public Order handle(PlaceOrder command) {
        Order order = new Order(command.getMeals(), command.getCustomerName(), command.getCustomerSurname(), command.getOrderTime(), command.getComment());

        this.publishEventsFor(order);
        this.orderRepository.save(order);

        return order;
    }

    private void publishEventsFor(Order order) {
        List<OrderEvent> orders = order.listEvents();
        orders.forEach(eventPublisher::publish);
        order.clearEvents();
    }
}
