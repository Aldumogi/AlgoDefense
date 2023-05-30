package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.*;

public class Juego {
    private Mapa mapa;
    private Turno turno;
    private Jugador jugador;
    private List<Enemigo> enemigos;

    public Juego() {
        this.enemigos = new ArrayList<Enemigo>();
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

    public void agregarEnemigo(Enemigo enemigo){
        enemigos.add(enemigo);
    }

    public boolean juegoTerminado(){
        return enemigos.size() == 0;
    }
}
