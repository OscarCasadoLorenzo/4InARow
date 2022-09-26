package com.bosonit.Secundario.infrastructure.controller;


import com.bosonit.Secundario.application.partida.PartidaServiceImpl;
import com.bosonit.Secundario.domain.Partida;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
public class PartidaHandler {

    @Autowired
    PartidaServiceImpl service;

    public Mono<ServerResponse> getAll(ServerRequest req) {
        var all = service.findAll();
        return ok().body(fromPublisher(all, Partida.class));
    }

    public Mono<ServerResponse> getOne(ServerRequest req) {
        var mono = service
                .findById(Integer.parseInt(req.pathVariable("id")))
                .switchIfEmpty(Mono.error(() -> new ResponseStatusException(NOT_FOUND)));
        return ok().body(fromPublisher(mono, Partida.class));
    }

    public Mono<ServerResponse> save(ServerRequest req) {

        final Mono<Partida> partida = req.bodyToMono(Partida.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(partida.flatMap(service::save), Partida.class));
    }

    public Mono deleteById(ServerRequest req) {

        var id = Integer.parseInt(req.pathVariable("id"));
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(service.deleteById(id), Void.class);
    }
}
