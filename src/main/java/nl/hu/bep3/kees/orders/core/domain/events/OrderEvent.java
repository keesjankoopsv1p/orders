package nl.hu.bep3.kees.orders.core.domain.events;

import java.time.Instant;
import java.util.UUID;

public abstract class OrderEvent {
    private final UUID eventId = UUID.randomUUID();
    private final Instant eventDate = Instant.now();

    public UUID getEventId() {
        return eventId;
    }

    public Instant getEventDate() {
        return eventDate;
    }

    public abstract String getEventKey();
}
