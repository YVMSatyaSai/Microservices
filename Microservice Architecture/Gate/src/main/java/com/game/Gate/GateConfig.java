package com.game.Gate;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    public class GateConfig {

        @Bean
        public GlobalFilter logFilter() {
            return (exchange, chain) -> {
                System.out.println("Request: " + exchange.getRequest().getURI());
                return chain.filter(exchange);
            };
        }
    }
