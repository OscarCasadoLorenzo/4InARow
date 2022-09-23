package com.bosonit.Secundario.websockets.domain;

public class Partida {
    int id_tablero;
    String host_name;
    String host_ip;
    String guest_name;
    String guest_ip;
    String[][] tablero;
    String turno;
    Boolean existe_ganador;
}