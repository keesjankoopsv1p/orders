package nl.hu.bep3.kees.orders.infrastructure.driver.web.response;

import nl.hu.bep3.kees.orders.core.domain.Order;

import java.util.Date;
import java.util.Hashtable;

public class OrderResponse {
    public String id;
    public Hashtable<String, Integer> meals;
    public String customerName;
    public String customerSurname;
    public  Date orderTime;
    public String comment;

    public OrderResponse(Order order) {
        this.id = order.getId().toString();
        this.meals = order.getMeals();
        this.customerName = order.getCustomerName();
        this.customerSurname = order.getCustomerSurname();
        this.orderTime = order.getOrderTime();
        this.comment = order.getComment();
    }
}
