CREATE TABLE IF NOT EXISTS PARTIDA (
  ID SERIAL PRIMARY KEY,
  host_ip VARCHAR(50) NOT NULL,
  host_name VARCHAR(50) NOT NULL,
  guest_name VARCHAR(50) NOT NULL,
  guest_ip VARCHAR(50) NOT NULL,
  turno VARCHAR(50) NOT NULL,
  existe_ganador BOOOLEAN

);


    int id;
    String host_name;
    String host_ip;
    String guest_name;
    String guest_ip;
    String[][] tablero;
    String turno;
    Boolean existe_ganador;
