package june.module12.order.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import june.module12.order.client.ShipmentClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShippingIntegrationService {
    private final ShipmentClient shipmentClient;

    @CircuitBreaker(name = "module12.shipment", fallbackMethod = "shipmentFallback")
    @Retry(name = "shippingRetry")
    public String createShipment(Long orderId) {
        log.info("Calling Shipping Service");
        return shipmentClient.createShipment(orderId);
    }

    public String shipmentFallback(Long orderId, Exception ex) {
        log.error("Shipping Service Down: {}", ex.getMessage());
        return "SHIPPING_SERVICE_UNAVAILABLE";
    }
}
