package edu.fiuba.algo3;

import edu.fiuba.algo3.*;

public class Juego {
    private Mapa mapa;
    private Turno turno;
    private Jugador jugador;

    public Juego() {
    }
    public Juego(Jugador jugador, Mapa mapa) {
        this.jugador = jugador;
        this.mapa = mapa;
        this.turno = new Turno();
    }

    public void setearJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador obtenerJugador() { return this.jugador; };
}
