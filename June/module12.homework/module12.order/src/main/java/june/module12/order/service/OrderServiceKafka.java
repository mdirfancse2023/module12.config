package june.module12.order.service;

import june.module12.order.entity.Order;
import june.module12.order.event.OrderCreatedEvent;
import june.module12.order.kafka.OrderProducer;
import june.module12.order.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceKafka {

    private final OrderRepo repository;
    private final OrderProducer producer;

    public Order placeOrder(Long productId, Integer quantity) {
        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setStatus("PENDING");
        Order savedOrder = repository.save(order);
        producer.publish(
                new OrderCreatedEvent(
                        savedOrder.getOrderId(),
                        savedOrder.getProductId(),
                        savedOrder.getQuantity()
                )
        );
        return savedOrder;
    }
}
