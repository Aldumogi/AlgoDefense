package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.*;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static edu.fiuba.algo3.Inicializador.logger;

public class Juego {
    private Mapa mapa;
    private int indiceActualListaTurnos;
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private ArrayList<Turno> turnos;

    public Juego() throws IOException, ParseException, FormatoMapaInvalidoException {
        this.indiceActualListaTurnos = 0;
        this.enemigos = new ArrayList<Enemigo>();
        this.turnos = new ArrayList<>();
        this.mapa = new Mapa();

        logger.info("Se ha iniciado el juego");

    }

    public Juego(Jugador jugador, Mapa mapa, ArrayList<Turno> turnos) {
        this.jugador = jugador;
        this.indiceActualListaTurnos = 0;
        this.mapa = mapa;
        this.enemigos = new ArrayList<Enemigo>();
        this.turnos = turnos;
        this.agregarEnemigosDelTurno();

        logger.info("Se ha iniciado el juego con un jugador y un mapa");
    }

    public Juego(ArrayList<Turno> turnos) throws IOException, ParseException, FormatoMapaInvalidoException {
        this.indiceActualListaTurnos = 0;
        this.mapa = new Mapa();
        this.enemigos = new ArrayList<Enemigo>();
        this.turnos = turnos;
        this.agregarEnemigosDelTurno();

        logger.info("Se ha iniciado el juego con los turnos");
    }

    public Juego(ArrayList<Turno> turnos, Mapa mapa) throws IOException, ParseException, FormatoMapaInvalidoException {
        this.indiceActualListaTurnos = 0;
        this.mapa = mapa;
        this.enemigos = new ArrayList<Enemigo>();
        this.turnos = turnos;
        this.agregarEnemigosDelTurno();

        logger.info("Se ha iniciado el juego con los turnos");
    }
    public void setearJugador(Jugador jugador) {
        this.jugador = jugador;

        logger.info("Seteo del jugador");
    }

    public Jugador obtenerJugador() {
        return this.jugador;
    }

    public int obtenerNumeroDeturno() {
        // aca deberia devolver el numero de turno real
        return this.indiceActualListaTurnos + 1;
    }
    public Mapa obtenerMapa() { return this.mapa; }

    public void agregarEnemigo(Enemigo enemigo) {
        enemigos.add(enemigo);
    }

    private void agregarEnemigosDelTurno() {
        if (this.turnos.size() == 0 || this.indiceActualListaTurnos >= turnos.size()) return;
        List<Enemigo> enemigosAAgregar = turnos.get(this.indiceActualListaTurnos).getListaEnemigosAgregadosEnElTurno();
        enemigosAAgregar.forEach( enemigo -> {
            enemigo.coordenadas = this.mapa.getCoordenadasLargada();
            this.mapa.recibir(this.mapa.getCoordenadasLargada(), enemigo);
        } );
        this.enemigos.addAll(enemigosAAgregar);
    }

    public void avanzarTurno(){
        this.indiceActualListaTurnos = (this.indiceActualListaTurnos < turnos.size() - 1 )? this.indiceActualListaTurnos + 1 : (this.indiceActualListaTurnos % 12);
        this.jugador.finalizarTurno(this.enemigos);
        this.eliminarEnemigosMuertos();
        this.actualizarEnergiaJugador();
        this.avanzarEnemigos();
        this.agregarEnemigosDelTurno();
        logger.info("Se avanzó al turno " + this.indiceActualListaTurnos);
    }

    public void avanzarEnemigos(){
        this.enemigos.forEach( enemigo -> {
            try{
                enemigo.mover(this.mapa);
            } catch(NoSePudoBorrarElEnemigoException e) {
                logger.error("No se pudo borrar el enemigo");
            }
        });
    }
    public void eliminarEnemigosMuertos(){

        List<Integer> indicesEnemigosAEliminar = new ArrayList<Integer>();
        for (int i = 0; i < this.enemigos.size(); i++) {
            // Si el enemigo esta muerto, guardo la posicion correspondiente a la lista de enemigos
            this.enemigos.get(i).agregarIndiceDelEnemigoMuerto(indicesEnemigosAEliminar, i);
        }

        /* Voy eliminando los enemigos desde la posicion mas alta para que los indices de la lista
        * enemigos no se modifiquen */
        for ( int j = 0 ; j < indicesEnemigosAEliminar.size() ; j++ ) {
            int posicion = indicesEnemigosAEliminar.get( indicesEnemigosAEliminar.size() - j - 1);
            this.enemigos.remove( posicion );
        }
    }

    public void actualizarEnergiaJugador() {
        Coordenadas coordenadasMeta = this.mapa.getCoordenadasMeta();
        this.enemigos.forEach( enemigo -> {
            if(coordenadasMeta.distanciaEntreCoordenadas(enemigo.obtenerCoordenadas()) == 0) {
                jugador.restarEnergia(enemigo.obtenerDanioCausado( this.obtenerNumeroDeturno() ));
            }
        });
        logger.info("Se actualizó la energía del jugador");
    }

    public boolean juegoTerminado(){
        return (enemigos.size() == 0 || this.indiceActualListaTurnos == turnos.size()-1 );
    }
    
    public void moverEnemigosAMeta() {
        Coordenadas coordenadasMeta = this.mapa.getCoordenadasMeta();
        this.enemigos.forEach( enemigo -> {
            enemigo.coordenadas = coordenadasMeta;
        });
    }

}
