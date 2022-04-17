package nl.hu.bep3.kees.orders.core.application;

import nl.hu.bep3.kees.orders.core.application.query.GetOrderByCustomerQuery;
import nl.hu.bep3.kees.orders.core.domain.Order;
import nl.hu.bep3.kees.orders.core.ports.storage.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderQueryHandler {
    private final OrderRepository orderRepository;

    public OrderQueryHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order handle(GetOrderByCustomerQuery query) {
        return this.orderRepository.findOrderByCustomer(query.getCustomer());
    }
}
