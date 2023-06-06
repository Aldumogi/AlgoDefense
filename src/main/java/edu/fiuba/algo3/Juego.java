package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.FormatoMapaInvalidoException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Juego {
    private Mapa mapa;
    private int indiceActualListaTurnos;
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private int cantidadDeHormigasMuertas;
    private ArrayList<Turno> turnos;

    public Juego() throws IOException, ParseException, FormatoMapaInvalidoException {
        this.indiceActualListaTurnos = 0;
        this.enemigos = new ArrayList<Enemigo>();
        this.turnos = new ArrayList<>();
        this.mapa = new Mapa();
    }

    public Juego(Jugador jugador, Mapa mapa) {
        this.jugador = jugador;
        this.mapa = mapa;
        this.indiceActualListaTurnos = 0;
        this.enemigos = new ArrayList<Enemigo>();
        this.cantidadDeHormigasMuertas = 0;
        this.turnos = new ArrayList<Turno>();
    }

    public Juego(ArrayList<Turno> turnos) throws IOException, ParseException, FormatoMapaInvalidoException {
        this.indiceActualListaTurnos = 0;
        this.mapa = new Mapa();
        this.enemigos = new ArrayList<Enemigo>();
        this.turnos = turnos;
        this.agregarEnemigosDelTurno();
        this.cantidadDeHormigasMuertas = 0;
    }

    public void setearJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador obtenerJugador() { return this.jugador; };
    public int obtenerNumeroDeturno() { return this.indiceActualListaTurnos; }
    public void agregarEnemigo(Enemigo enemigo){
        enemigos.add(enemigo);
    }
    private void agregarEnemigosDelTurno() {
        if ( turnos.size() == 0 ) return;
        List<Enemigo> enemigosAAgregar = turnos.get(this.indiceActualListaTurnos).getListaEnemigosAgregadosEnElTurno();
        this.enemigos.addAll(enemigosAAgregar);
    }
    public void avanzarTurno(){
        this.indiceActualListaTurnos = (this.indiceActualListaTurnos < 12) ? this.indiceActualListaTurnos++ : (this.indiceActualListaTurnos % 12 + 1);
        this.jugador.actualizarDefensasAlFinalizarTurno();
        this.cantidadDeHormigasMuertas += this.contarMuertosEnElTurnoActual();
        this.obtenerCreditosYEliminarEnemigosAlFinalizarTurno();
        this.actualizarEnergiaJugador();
        this.agregarEnemigosDelTurno();
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
