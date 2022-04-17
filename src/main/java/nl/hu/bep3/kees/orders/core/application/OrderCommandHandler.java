package nl.hu.bep3.kees.orders.core.application;

import nl.hu.bep3.kees.orders.core.application.command.PlaceOrder;
import nl.hu.bep3.kees.orders.core.application.services.IngredientService;
import nl.hu.bep3.kees.orders.core.domain.Order;
import nl.hu.bep3.kees.orders.core.domain.events.OrderEvent;
import nl.hu.bep3.kees.orders.core.ports.messaging.OrderEventPublisher;
import nl.hu.bep3.kees.orders.core.ports.storage.OrderRepository;
import nl.hu.bep3.kees.orders.core.ports.storage.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCommandHandler {
    private final OrderEventPublisher eventPublisher;
    private final OrderRepository orderRepository;
    private final StockRepository stockRepository;
    private final IngredientService ingredientService;

    public OrderCommandHandler(OrderEventPublisher eventPublisher, OrderRepository repository, StockRepository stockRepository){
        this.eventPublisher = eventPublisher;
        this.orderRepository = repository;
        this.stockRepository = stockRepository;
        this.ingredientService = new IngredientService(stockRepository);
    }

    public Order handle(PlaceOrder command) {
        //validate meals
        ingredientService.Validate(command.getMeals());

        //create
        Order order = new Order(command.getMeals(), command.getCustomerName(), command.getCustomerSurname(), command.getOrderTime(), command.getComment());

        //save
        this.orderRepository.save(order);
        order.placeOrder();

        //publish events
        this.publishEventsFor(order);

        return order;
    }

    private void publishEventsFor(Order order) {
        List<OrderEvent> orders = order.listEvents();
        orders.forEach(eventPublisher::publish);
        order.clearEvents();
    }
}
