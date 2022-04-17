package nl.hu.bep3.kees.orders.infrastructure.driver.web;

import nl.hu.bep3.kees.orders.core.application.OrderCommandHandler;
import nl.hu.bep3.kees.orders.core.application.command.PlaceOrder;
import nl.hu.bep3.kees.orders.core.domain.Order;
import nl.hu.bep3.kees.orders.infrastructure.driver.web.request.PlaceOrderRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

@RestController
@RequestMapping("/orders")
public class CommandOrderController {
    private final OrderCommandHandler commandHandler;

    public CommandOrderController(OrderCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    //
    @PostMapping
    public Order placeOrder(@Valid @RequestBody PlaceOrderRequest request) {
        Date orderTime  = new Date();

        //transform Arraylist with duplicates to Hashtable with mealID + quantity
        ArrayList<String> temp = request.meals;
        Hashtable<String, Integer> meals = new Hashtable<>();
        for (String meal : request.meals) {
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
