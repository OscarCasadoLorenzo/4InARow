package com.bosonit.Secundario.websockets.infrastructure.controller;

import com.bosonit.Secundario.websockets.application.PartidaCreatedEvent;
import com.bosonit.Secundario.websockets.application.PartidaCreatedEventPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ServerSentEventController {
    private final Flux<PartidaCreatedEvent> events;
    private final ObjectMapper objectMapper;

    public ServerSentEventController(PartidaCreatedEventPublisher eventPublisher, ObjectMapper objectMapper) {
        this.events = Flux.create(eventPublisher).share();
        this.objectMapper = objectMapper;
    }

    @GetMapping(path = "/sse/profiles", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> profiles() {
        return this.events.map(pce -> {
            try {
                return objectMapper.writeValueAsString(pce);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
