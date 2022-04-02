package nl.hu.bep3.kees.orders.core.domain;

import nl.hu.bep3.kees.orders.core.domain.events.OrderEvent;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

@Document
public class Order {
    @Id
    private UUID id;
    @Indexed
    private Hashtable<UUID, Integer> meals;
    @Indexed
    private String customerName;
    @Indexed
    private String customerSurname;
    @Indexed
    private Date orderTime;
    @Indexed
    private String comment;
    @Transient
    private List<OrderEvent> events = new ArrayList<>();

    public Order(Hashtable<UUID, Integer> meals, String customerName, String customerSurname, Date orderTime, String comment){
        this.id = UUID.randomUUID();
        this.meals = meals;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.orderTime = orderTime;
        this.comment = comment;
    }

    public void clearEvents() {
        this.events.clear();
    }

    public List<OrderEvent> listEvents() {return events;}
}
