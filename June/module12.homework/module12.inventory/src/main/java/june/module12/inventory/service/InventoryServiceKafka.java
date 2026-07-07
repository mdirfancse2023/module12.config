package june.module12.inventory.service;

import june.module12.inventory.event.OrderCreatedEvent;
import june.module12.inventory.event.OrderStatusUpdatedEvent;
import june.module12.inventory.kafka.InventoryProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryServiceKafka {

    private final InventoryService inventoryService;
    private final InventoryProducer producer;

    public void processOrder(OrderCreatedEvent event) {

        boolean stockAvailable = inventoryService.reduceStock(
                event.getProductId(),
                event.getQuantity()
        );

        if (stockAvailable) {

            producer.publish(
                    new OrderStatusUpdatedEvent(
                            event.getOrderId(),
                            "FULFILLED"
                    )
            );

        } else {

            producer.publish(
                    new OrderStatusUpdatedEvent(
                            event.getOrderId(),
                            "OUT_OF_STOCK"
                    )
            );

        }

    }
}