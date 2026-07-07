package june.module12.order.client;

import june.module12.order.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "module12.shipping")
public interface ShipmentClient {
    @PostMapping("/shipment/{orderId}")
    String createShipment(@PathVariable Long orderId);

    @GetMapping("/shipment/{orderId}")
    String getShippingStatus(@PathVariable Long orderId);

}
