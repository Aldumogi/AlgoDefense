package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoBorrarElEnemigoException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

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


    }

    public Juego(Jugador jugador, Mapa mapa, ArrayList<Turno> turnos) {
        this.jugador = jugador;
        this.indiceActualListaTurnos = 0;
        this.mapa = mapa;
        this.enemigos = new ArrayList<Enemigo>();
        this.turnos = turnos;
        this.agregarEnemigosDelTurno();
    }

    public Juego(ArrayList<Turno> turnos) throws IOException, ParseException, FormatoMapaInvalidoException {
        this.indiceActualListaTurnos = 0;
        this.mapa = new Mapa();
        this.enemigos = new ArrayList<Enemigo>();
        this.turnos = turnos;
        this.agregarEnemigosDelTurno();
    }

    public Juego(ArrayList<Turno> turnos, Mapa mapa) throws IOException, ParseException, FormatoMapaInvalidoException {
        this.indiceActualListaTurnos = 0;
        this.mapa = mapa;
        this.enemigos = new ArrayList<Enemigo>();
        this.turnos = turnos;
        this.agregarEnemigosDelTurno();
    }
    public void setearJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador obtenerJugador() {
        return this.jugador;
    }

    public int obtenerNumeroDeturno() {
        // aca deberia devolver el numero de turno real
        return this.indiceActualListaTurnos + 1;
    }

    public void agregarEnemigo(Enemigo enemigo) {
        enemigos.add(enemigo);
    }

    private void agregarEnemigosDelTurno() {
        if (this.turnos.size() == 0 || this.indiceActualListaTurnos >= turnos.size()) return;
        List<Enemigo> enemigosAAgregar = turnos.get(this.indiceActualListaTurnos).getListaEnemigosAgregadosEnElTurno();
        enemigosAAgregar.forEach( enemigo -> {
            enemigo.setCoordenadas(this.mapa.getCoordenadasLargada());
            this.mapa.recibir(this.mapa.getCoordenadasLargada(), enemigo);
        } );
        this.enemigos.addAll(enemigosAAgregar);
    }

    public void avanzarTurno(){
        this.indiceActualListaTurnos = (this.indiceActualListaTurnos < turnos.size() - 1 )? this.indiceActualListaTurnos + 1 : (this.indiceActualListaTurnos % 12);
        this.jugador.finalizarTurno(this.enemigos, this.mapa);
        this.eliminarEnemigosMuertos();
        this.realizarAtaquesDeLosEnemigosEnLaMeta();
        this.avanzarEnemigos();
        this.agregarEnemigosDelTurno();
        logger.info("Se avanzó al turno " + (this.indiceActualListaTurnos + 1));
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

    public void realizarAtaquesDeLosEnemigosEnLaMeta() {
        Coordenadas coordenadasMeta = this.mapa.getCoordenadasMeta();
        ArrayList<Enemigo> enemigosEnLaMeta = new ArrayList<>();
        this.enemigos.forEach( enemigo -> {
            if(coordenadasMeta.distanciaEntreCoordenadas(enemigo.obtenerCoordenadas()) == 0) {
                enemigo.realizarAtaque(jugador, this.obtenerNumeroDeturno(), this.mapa);
                enemigosEnLaMeta.add(enemigo);
            }
        });
        this.enemigos.removeAll(enemigosEnLaMeta);
    }
    
    public boolean juegoTerminado(){
        if ( ! jugador.estaVivo() ) {
            logger.info("Jugador pierde la partida");
            return true;
        }
        if (enemigos.size() == 0 || this.indiceActualListaTurnos == turnos.size()-1 ) {
            logger.info("Jugador gana la partida");
            return true;
        }
        return false;
    }
    
    public void moverEnemigosAMeta() {
        Coordenadas coordenadasMeta = this.mapa.getCoordenadasMeta();
        this.enemigos.forEach( enemigo -> {
            enemigo.setCoordenadas(coordenadasMeta);
        });
    }

    public Mapa obtenerMapa() {
        return this.mapa;
    }

}
