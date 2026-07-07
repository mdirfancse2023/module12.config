package june.module12.apigateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.gateway.config.GatewayProperties;

import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private GatewayProperties gatewayProperties;

    @Test
    void gatewayRoutesAreBoundFromConfiguration() {
        Set<String> routeIds = gatewayProperties.getRoutes()
                .stream()
                .map(route -> route.getId())
                .collect(Collectors.toSet());

        assertThat(routeIds)
                .containsExactlyInAnyOrder(
                        "order-route",
                        "inventory-route",
                        "shipping-route");
    }
}
