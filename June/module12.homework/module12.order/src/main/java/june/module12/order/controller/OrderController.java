package june.module12.order.controller;

import june.module12.order.entity.Order;
import june.module12.order.service.OrderService;
import june.module12.order.service.OrderServiceKafka;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderServiceKafka service;
    @PostMapping
    public Order placeOrder(@RequestParam Long productId, @RequestParam Integer quantity){
        return service.placeOrder(productId, quantity);
    }
   /* @PutMapping("/{id}/cancel")
    public String cancelOrder(@PathVariable Long id){
        return service.cancelOrder(id);
    }

    @GetMapping("/{orderId}/shipping-status")
    public String shippingStatus(@PathVariable Long orderId){
        return service.getShippingStatus(orderId);
    }*/
}
