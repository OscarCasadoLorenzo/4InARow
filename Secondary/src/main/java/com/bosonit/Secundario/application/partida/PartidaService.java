package com.bosonit.Secundario.application.partida;

import com.bosonit.Secundario.domain.Partida;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface PartidaService {
    public Mono<Partida> findById(int id) ;

    public Mono<Void> deleteById(int id);
    public Mono<Partida> save(Partida partida) ;
    public Flux<Partida> findAll() ;
}
