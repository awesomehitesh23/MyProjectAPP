package com.pack.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//The API Gateway offers a reverse proxy to redirect or route requests
//to the endpoints of the internal microservices.

/*
 * If you have hundreds of microservices then you don’t need to remember 
 * the port of all microservices. 
 * You can just configure them in your API Gateway and 
 * you can access all your API by using only one port
 */
@Configuration
public class GatewayConfig {


    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes().route("user", r -> r.path("/users/**").uri("http://localhost:8085"))
				.route("auth", r -> r.path("/auth/**").uri("http://localhost:8086"))
				.route("auth", r -> r.path("/events/**").uri("http://localhost:8087"))
				.route("auth", r -> r.path("/wishlist/**").uri("http://localhost:8088")).build();
 	}
}
