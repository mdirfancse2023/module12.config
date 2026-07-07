package june.module12.order.kafka;

import june.module12.order.entity.Order;
import june.module12.order.event.OrderStatusUpdatedEvent;
import june.module12.order.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderStatusConsumer {
    private final OrderRepo repository;
    @KafkaListener(topics = "order_status_updated", groupId = "order-group")
    public void consume(OrderStatusUpdatedEvent event) {
        Order order = repository.findById(event.getOrderId()).orElseThrow();
        order.setStatus(event.getStatus());
        repository.save(order);
        System.out.println("Order Updated : " + event);
    }
}