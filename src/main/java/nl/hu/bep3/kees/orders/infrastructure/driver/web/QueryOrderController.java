package nl.hu.bep3.kees.orders.infrastructure.driver.web;

import nl.hu.bep3.kees.orders.core.application.OrderQueryHandler;
import nl.hu.bep3.kees.orders.core.application.query.GetOrderByCustomerQuery;
import nl.hu.bep3.kees.orders.core.domain.Order;
import nl.hu.bep3.kees.orders.infrastructure.driver.web.response.OrderResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class QueryOrderController {
    private final OrderQueryHandler queryHandler;

    public QueryOrderController(OrderQueryHandler queryHandler) {
        this.queryHandler = queryHandler;
    }

    @GetMapping("/{customerName}")
    public OrderResponse getOrdersByName(@PathVariable String customerName){
        Order result = queryHandler.handle(new GetOrderByCustomerQuery(customerName));
        return new OrderResponse(result);
    }
}
