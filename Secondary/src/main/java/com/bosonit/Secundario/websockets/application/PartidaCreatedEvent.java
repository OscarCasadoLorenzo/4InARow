package com.bosonit.Secundario.websockets.application;

import com.bosonit.Secundario.websockets.domain.Partida;
import org.springframework.context.ApplicationEvent;

public class PartidaCreatedEvent extends ApplicationEvent {

    public PartidaCreatedEvent(Partida source) {
        super(source);
    }
}
