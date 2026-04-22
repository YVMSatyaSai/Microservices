package com.game.Gate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.*;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class JwtFilter implements GlobalFilter {

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public reactor.core.publisher.Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String path = exchange.getRequest().getURI().getPath();

        // Allow login API
        if (path.contains("/auth/login")) {
            return chain.filter(exchange);
        }

        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Missing token");
        }

        String token = authHeader.substring(7);

        try {
            jwtUtil.validateToken(token);
        } catch (Exception e) {
            throw new RuntimeException("Invalid token");
        }

        return chain.filter(exchange);
    }
}
