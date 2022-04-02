package nl.hu.bep3.kees.orders.core.ports.storage;

import nl.hu.bep3.kees.orders.core.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OrderRepository extends MongoRepository<Order, UUID> {
}
