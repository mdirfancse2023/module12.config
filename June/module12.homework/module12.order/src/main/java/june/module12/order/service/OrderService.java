package june.module12.order.service;

import june.module12.order.client.InventoryClient;
import june.module12.order.client.ShipmentClient;
import june.module12.order.entity.Order;
import june.module12.order.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepo repository;
    private final InventoryClient inventoryClient;
    private final ShipmentClient shipmentClient;
    private final ShippingIntegrationService shippingIntegrationService;

    public Order placeOrder(Long productId, Integer quantity){
        inventoryClient.reduceStock(productId, quantity);
        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setStatus("CREATED");
        Order savedOrder =  repository.save(order);
        //shipmentClient.createShipment(savedOrder.getOrderId());
        shippingIntegrationService.createShipment(savedOrder.getOrderId());
        return savedOrder;
    }

    public String cancelOrder(Long orderId){
        Order order = repository.findById(orderId).orElseThrow();
        inventoryClient.restock(order.getProductId(), order.getQuantity());
        order.setStatus("CANCELLED");
        repository.save(order);
        return "Order Cancelled";
    }

    public String getShippingStatus(Long orderId){
        return shipmentClient.getShippingStatus(orderId);
    }
}
