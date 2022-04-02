package nl.hu.bep3.kees.orders.core.application.command;

import java.util.Date;
import java.util.Hashtable;
import java.util.UUID;

public class PlaceOrder {
    private final Hashtable<UUID, Integer> meals;
    private final String customerName;
    private final String customerSurname;
    private final Date orderTime;
    private final String comment;

    public PlaceOrder(Hashtable<UUID, Integer> meals, String customerName, String customerSurname, Date orderTime, String comment) {
        this.meals = meals;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.orderTime = orderTime;
        this.comment = comment;
    }

    public Hashtable<UUID, Integer> getMeals() {
        return meals;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public String getComment() {
        return comment;
    }
}
