package nl.hu.bep3.kees.orders.core.ports.storage;

import nl.hu.bep3.kees.orders.core.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.UUID;

public interface OrderRepository extends MongoRepository<Order, UUID> {

    //get order by customername
    @Query(value = "{ 'customerSurname' : ?0 }")
    Order findOrderByCustomer(String customerSurname);
}
