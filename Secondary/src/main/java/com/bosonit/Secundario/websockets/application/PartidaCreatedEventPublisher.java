package com.bosonit.Secundario.websockets.application;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

@Component
public
class PartidaCreatedEventPublisher implements
        ApplicationListener<PartidaCreatedEvent>,
        Consumer<FluxSink<PartidaCreatedEvent>> {

    private FluxSink<PartidaCreatedEvent> sink;

    @Override
    public void onApplicationEvent(PartidaCreatedEvent event) {
        FluxSink<PartidaCreatedEvent> sink = this.sink;
        if (sink != null) {
            sink.next(event);
        }
    }

    @Override
    public void accept(FluxSink<PartidaCreatedEvent> sink) {
        this.sink = sink;
        sink.onDispose(() -> this.sink = null);
    }
}
