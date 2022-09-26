package com.bosonit.Secundario.infrastructure.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PartidaRoutes {
    @Bean
    public RouterFunction<ServerResponse> routes(PartidaHandler handler) {
        return route().path(
                "/partidas", builder -> builder
                        .GET("", handler::getAll)
                        .GET("/{id}", handler::getOne)
                        .POST("",handler::save)
                        .DELETE("/{id}", handler::deleteById)
        ).build();
    }
}
