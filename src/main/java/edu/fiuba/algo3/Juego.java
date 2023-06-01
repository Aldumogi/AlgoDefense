package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.*;

public class Juego {
    private Mapa mapa;
    private int numeroDeTurno;
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private int cantidadDeHormigasMuertas;
    private int creditosDelTurno;

    public Juego() {
        this.numeroDeTurno = 0;
        this.enemigos = new ArrayList<Enemigo>();
        this.creditosDelTurno = 0;
    }

    public Juego(Jugador jugador, Mapa mapa) {
        this.jugador = jugador;
        this.mapa = mapa;
        this.numeroDeTurno = 0;
        this.enemigos = new ArrayList<Enemigo>();
        this.cantidadDeHormigasMuertas = 0;
        this.creditosDelTurno = 0;
    }

    public void setearJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador obtenerJugador() { return this.jugador; };
    public int obtenerNumeroDeturno() { return this.numeroDeTurno; }
    public void agregarEnemigo(Enemigo enemigo){
        enemigos.add(enemigo);
    }
    public void avanzarTurno(){
        this.numeroDeTurno++;
        this.creditosDelTurno = 0;
        this.jugador.actualizarDefensasAlFinalizarTurno(this.numeroDeTurno);
        this.actualizarEstadoDeLosEnemigosYObtenerCreditosAlFinalizarTurno();
        this.jugador.agregarCreditosAlMatarEnemigos( this.creditosDelTurno );
        this.actualizarEnergiaJugador();

    }

    public void actualizarEstadoDeLosEnemigosYObtenerCreditosAlFinalizarTurno(){
        this.enemigos.forEach( enemigo -> {
            boolean cambio = enemigo.actualizarEstado();
            if ( cambio ) {
                if ( enemigo.esUnaHormiga() ) {
                    this.cantidadDeHormigasMuertas++;
                    enemigo.cantidadCreditosOtorgados(this.cantidadDeHormigasMuertas);
                }
                else {
                    enemigo.cantidadCreditosOtorgados(0);
                }
                this.creditosDelTurno += enemigo.creditosOtorgados();
            }
        } );
    }

    public void actualizarEnergiaJugador() {
        Coordenadas coordenadasMeta = new Coordenadas(5,2);
        this.enemigos.forEach( enemigo -> {
            if(coordenadasMeta.distanciaEntreCoordenadas(enemigo.obtenerCoordenadas()) == 0) {
                jugador.restarEnergia(enemigo.obtenerDanioCausado());
            }
        });
    }

    public boolean juegoTerminado(){
        return enemigos.size() == 0;
    }
}
