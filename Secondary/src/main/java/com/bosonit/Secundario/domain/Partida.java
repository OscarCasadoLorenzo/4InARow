package com.bosonit.Secundario.domain;

import com.bosonit.Secundario.infrastructure.controller.dto.input.PartidaInputDto;
import com.bosonit.Secundario.infrastructure.controller.dto.output.PartidaOutputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partida {
    @Id
    @GeneratedValue
    int id;
    String host_name;
    String host_ip;
    String guest_name;
    String guest_ip;
    String[][] tablero;
    String turno;
    Boolean existe_ganador;


    public Partida(PartidaInputDto partidaInputDto) {
        this.id = partidaInputDto.id();
        this.host_name = partidaInputDto.host_name();
        this.host_ip = partidaInputDto.host_ip();
        this.guest_name = partidaInputDto.guest_name();
        this.guest_ip = partidaInputDto.guest_ip();
        this.tablero = partidaInputDto.tablero();
        this.turno = partidaInputDto.turno();
        this.existe_ganador = partidaInputDto.existe_ganador();
    }

    public PartidaOutputDto PartidaToOutputDto() {
        return new PartidaOutputDto(this.id,
                this.host_name,
                this.host_ip,
                this.guest_name,
                this.guest_ip,
                this.tablero,
                this.turno,
                this.existe_ganador);
    }
}
