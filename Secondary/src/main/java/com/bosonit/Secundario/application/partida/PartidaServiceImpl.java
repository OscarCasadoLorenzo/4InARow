package com.bosonit.Secundario.application.partida;

import com.bosonit.Secundario.domain.Partida;
import com.bosonit.Secundario.infrastructure.repository.PartidaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class PartidaServiceImpl implements PartidaService{

//    @Autowired
//    PartidaRepository partidaRepository;

    public final PartidaRepository partidaRepository;

    @Override
    public Mono<Partida> findById(int id) {
        return partidaRepository
                .findById(id)
                .doOnNext(p -> log.info("Partida with id " + p.getId()));
    }
    @Override
    public Mono<Void> deleteById(int id) {
        return partidaRepository.deleteById(id).doOnNext(c -> log.info("Partida with id {} deleted", id));
    }
    @Override
    public Mono<Partida> save(Partida partida) {
        return partidaRepository.save(partida);
    }
    @Override
    public Flux<Partida> findAll() {
        return partidaRepository.findAll();
    }
}
