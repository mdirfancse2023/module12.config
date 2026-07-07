package june.module12.apigateway.filter;

import june.module12.apigateway.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RoleAuthorizationFilter
        implements GlobalFilter {

    private final JwtUtil jwtUtil;

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {

        return processRequest(
                exchange,
                chain);
    }

    private Mono<Void> processRequest(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {

        String authHeader =
                exchange.getRequest()
                        .getHeaders()
                        .getFirst(
                                HttpHeaders.AUTHORIZATION);

        String requiredRoles =
                exchange.getRequest()
                        .getHeaders()
                        .getFirst(
                                "X-User-Roles");

        if(authHeader == null ||
                !authHeader.startsWith("Bearer ")) {

            exchange.getResponse()
                    .setStatusCode(
                            HttpStatus.UNAUTHORIZED);

            return exchange
                    .getResponse()
                    .setComplete();
        }

        String token =
                authHeader.substring(7);

        List<String> jwtRoles =
                jwtUtil.extractRoles(token);

        if(requiredRoles != null) {

            List<String> requiredRoleList =
                    Arrays.stream(
                                    requiredRoles.split(","))
                            .map(String::trim)
                            .toList();

            boolean authorized =
                    requiredRoleList
                            .stream()
                            .anyMatch(jwtRoles::contains);

            if(!authorized) {

                exchange.getResponse()
                        .setStatusCode(
                                HttpStatus.FORBIDDEN);

                return exchange
                        .getResponse()
                        .setComplete();
            }
        }

        return chain.filter(exchange);
    }
}
