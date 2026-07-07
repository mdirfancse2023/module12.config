package june.module12.shipping.service;

import june.module12.shipping.entity.Shipment;
import june.module12.shipping.repository.ShipmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShipmentService {
    private final ShipmentRepo repository;

    public Shipment createShipment(Long orderId){
        Shipment shipment = new Shipment();
        shipment.setOrderId(orderId);
        shipment.setShippingStatus("PROCESSING");
        return repository.save(shipment);
    }

    public String getShippingStatus(Long orderId){
        Shipment shipment = repository.findByOrderId(orderId).orElseThrow();
        return shipment.getShippingStatus();
    }
}
