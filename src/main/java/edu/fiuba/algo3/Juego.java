package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.*;

public class Juego {
    private Mapa mapa;
    private int numeroDeTurno;
    private Jugador jugador;
    private List<Enemigo> enemigos;

    public Juego() {
        this.numeroDeTurno = 0;
        this.enemigos = new ArrayList<Enemigo>();
    }

    public Juego(Jugador jugador, Mapa mapa) {
        this.jugador = jugador;
        this.mapa = mapa;
        this.numeroDeTurno = 0;
        this.enemigos = new ArrayList<Enemigo>();
    }

    public void setearJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador obtenerJugador() { return this.jugador; };

    public void agregarEnemigo(Enemigo enemigo){
        enemigos.add(enemigo);
    }
    public void avanzarTurno(){
        this.numeroDeTurno++;
    }
    public boolean juegoTerminado(){
        return enemigos.size() == 0;
    }
}
