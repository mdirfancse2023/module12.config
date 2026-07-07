package june.module12.inventory.kafka;

import june.module12.inventory.event.OrderStatusUpdatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publish(OrderStatusUpdatedEvent event) {

        kafkaTemplate.send("order_status_updated", event);

    }

}
