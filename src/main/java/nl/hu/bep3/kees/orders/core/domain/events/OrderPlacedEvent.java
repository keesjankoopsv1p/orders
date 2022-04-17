package nl.hu.bep3.kees.orders.core.domain.events;

import java.util.Hashtable;
import java.util.UUID;

public class OrderPlacedEvent extends OrderEvent{
    private final UUID order;
    private final Hashtable<String, Integer> meals;

    public OrderPlacedEvent(UUID id, Hashtable<String, Integer> meals) {
        this.order = id;
        this.meals = meals;
    }

    @Override
    public String getEventKey() { return "orders.stock.placed"; }

    public UUID getOrder() { return order; }

    public Hashtable<String, Integer> getMeals() {
        return meals;
    }
}
