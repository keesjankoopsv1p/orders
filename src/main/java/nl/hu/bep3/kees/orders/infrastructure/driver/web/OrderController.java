package nl.hu.bep3.kees.orders.infrastructure.driver.web;

import nl.hu.bep3.kees.orders.core.application.OrderCommandHandler;
import nl.hu.bep3.kees.orders.core.application.OrderQueryHandler;
import nl.hu.bep3.kees.orders.core.application.command.PlaceOrder;
import nl.hu.bep3.kees.orders.core.domain.Order;
import nl.hu.bep3.kees.orders.infrastructure.driver.web.request.PlaceOrderRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderCommandHandler commandHandler;
    private final OrderQueryHandler queryHandler;

    public OrderController(OrderCommandHandler commandHandler, OrderQueryHandler queryHandler) {
        this.commandHandler = commandHandler;
        this.queryHandler = queryHandler;
    }

    @PostMapping
    public Order PlaceOrder(@Valid @RequestBody PlaceOrderRequest request) {
        Date orderTime  = new Date();

        //transform Arraylist with duplicates to Hashtable with mealID + quantity
        ArrayList<UUID> temp = request.meals;
        Hashtable<UUID, Integer> meals = new Hashtable<>();
        for (UUID meal : request.meals) {
            if(meals.containsKey(meal)){
                meals.replace(meal, meals.get(meal), meals.get(meal)+1);
            }else {
                meals.put(meal, 1);
            }
        }

        return this.commandHandler.handle(
                new PlaceOrder(meals, request.customerName, request.customerSurname, orderTime, request.comment)
        );
    }
}
