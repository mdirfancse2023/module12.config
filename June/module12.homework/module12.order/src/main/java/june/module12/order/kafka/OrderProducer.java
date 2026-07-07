package june.module12.order.kafka;

import june.module12.order.event.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void publish(OrderCreatedEvent event) {

        System.out.println("Publishing Event : " + event);

        kafkaTemplate.send("order_created", event)
                .whenComplete((result, ex) -> {
                    if (ex != null) {
                        System.out.println("FAILED TO SEND");
                        ex.printStackTrace();
                    } else {
                        System.out.println("MESSAGE SENT SUCCESSFULLY");
                        System.out.println(result.getRecordMetadata());
                    }
                });
    }
}
