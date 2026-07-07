package june.module12.shipping.controller;

import june.module12.shipping.entity.Shipment;
import june.module12.shipping.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipment")
@RequiredArgsConstructor
public class ShipmentController {
    private final ShipmentService service;

    @PostMapping("/{orderId}")
    public Shipment createShipment(@PathVariable Long orderId){
        return service.createShipment(orderId);
    }

    @GetMapping("/{orderId}")
    public String getShippingStatus(@PathVariable Long orderId){
        return service.getShippingStatus(orderId);
    }
}
