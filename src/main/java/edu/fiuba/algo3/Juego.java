package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.List;

public class Juego {
    private Mapa mapa;
    private int IndiceActualListaTurnos;
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private int cantidadDeHormigasMuertas;
    private ArrayList<Turno> turnos;

    public Juego() {
        this.IndiceActualListaTurnos = 0;
        this.enemigos = new ArrayList<Enemigo>();
        this.turnos = new ArrayList<>();
    }

    public Juego(Jugador jugador, Mapa mapa) {
        this.jugador = jugador;
        this.mapa = mapa;
        this.IndiceActualListaTurnos = 0;
        this.enemigos = new ArrayList<Enemigo>();
        this.cantidadDeHormigasMuertas = 0;
        this.turnos = new ArrayList<Turno>();
    }

    public Juego(ArrayList<Turno> turnos) {
        this.IndiceActualListaTurnos = 0;
        this.enemigos = new ArrayList<Enemigo>();
        this.turnos = turnos;
    }

    public void setearJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador obtenerJugador() { return this.jugador; };
    public int obtenerNumeroDeturno() { return this.IndiceActualListaTurnos; }
    public void agregarEnemigo(Enemigo enemigo){
        enemigos.add(enemigo);
    }
    public void avanzarTurno(){
        this.IndiceActualListaTurnos++;
        this.jugador.actualizarDefensasAlFinalizarTurno();
        this.cantidadDeHormigasMuertas += this.contarMuertosEnElTurnoActual();
        this.obtenerCreditosYEliminarEnemigosAlFinalizarTurno();
        this.actualizarEnergiaJugador();
    }

    public void obtenerCreditosYEliminarEnemigosAlFinalizarTurno(){
        int creditosDelTurno = 0;
        List<Integer> indicesEnemigosAEliminar = new ArrayList<Integer>();
        for (int i = 0; i < this.enemigos.size(); i++) {
            creditosDelTurno += this.enemigos.get(i).cantidadCreditosOtorgados(this.cantidadDeHormigasMuertas);
            // Si el enemigo esta muerto, guardo la posicion correspondiente a la lista de enemigos
            this.enemigos.get(i).agregarIndiceDelEnemigoMuerto(indicesEnemigosAEliminar, i);
        }
        this.jugador.agregarCreditosAlMatarEnemigos( creditosDelTurno );

        /* Voy eliminando los enemigos desde la posicion mas alta para que los indices de la lista
        * enemigos no se modifiquen */
        for ( int j = 0 ; j < indicesEnemigosAEliminar.size() ; j++ ) {
            int posicion = indicesEnemigosAEliminar.get( indicesEnemigosAEliminar.size() - j - 1);
            this.enemigos.remove( posicion );
        }
    }

    public int contarMuertosEnElTurnoActual() {
        ArrayList<Hormiga> hormigasMuertas = new ArrayList<Hormiga>();
        for (Enemigo enemigo: this.enemigos) {
            enemigo.acumularMuertos(hormigasMuertas);
        }
        return hormigasMuertas.size();
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
