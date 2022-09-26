package com.bosonit.Secundario.infrastructure.controller.dto.output;

public record PartidaOutputDto(
           int id,
           String host_name,
           String host_ip,
           String guest_name,
           String guest_ip,
           String[][] tablero,
           String turno,
           Boolean existe_ganador) {
}
