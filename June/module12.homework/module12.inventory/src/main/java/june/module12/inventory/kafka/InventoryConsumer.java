package june.module12.inventory.kafka;

import june.module12.inventory.event.OrderCreatedEvent;
import june.module12.inventory.service.InventoryServiceKafka;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryConsumer {
    private final InventoryServiceKafka inventoryServiceKafka;
    @KafkaListener(
            topics = "order_created",
            groupId = "inventory-group"
    )
    public void consume(OrderCreatedEvent event) {
        System.out.println("Received : " + event);
        inventoryServiceKafka.processOrder(event);
    }
}