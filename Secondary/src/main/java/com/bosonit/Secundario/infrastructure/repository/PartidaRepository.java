package com.bosonit.Secundario.infrastructure.repository;

import com.bosonit.Secundario.domain.Partida;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface PartidaRepository extends ReactiveSortingRepository<Partida, Integer> {
}
