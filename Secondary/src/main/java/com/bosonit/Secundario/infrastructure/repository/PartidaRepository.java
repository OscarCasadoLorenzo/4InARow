package com.bosonit.Secundario.infrastructure.repository;

import com.bosonit.Secundario.domain.Partida;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;

public interface PartidaRepository extends ReactiveSortingRepository<Partida, Integer> {
}
