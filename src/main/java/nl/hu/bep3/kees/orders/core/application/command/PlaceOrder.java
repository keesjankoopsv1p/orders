package nl.hu.bep3.kees.orders.core.application.command;

import java.util.Date;
import java.util.Hashtable;

public class PlaceOrder {
    private final Hashtable<String, Integer> meals;
    private final String customerName;
    private final String customerSurname;
    private final Date orderTime;
    private final String comment;

    public PlaceOrder(Hashtable<String, Integer> meals, String customerName, String customerSurname, Date orderTime, String comment) {
        this.meals = meals;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.orderTime = orderTime;
        this.comment = comment;
    }

    public Hashtable<String, Integer> getMeals() {
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
