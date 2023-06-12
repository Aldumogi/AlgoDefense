package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.enemigo.LoaderEnemigosJuego;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import static edu.fiuba.algo3.modelo.LoggerManager.logger;
import edu.fiuba.algo3.modelo.exceptions.FormatoEnemigosInvalidoException;
import edu.fiuba.algo3.modelo.exceptions.FormatoMapaInvalidoException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class Inicializador {
    private Juego juego;

    public Inicializador(String filepath) throws FormatoMapaInvalidoException, IOException, ParseException {
        // inicializador sin enemigos
        Mapa mapa = new Mapa(filepath);
        ArrayList<Turno> turnos = new ArrayList<>();
        this.juego = new Juego(turnos, mapa);
    }

    public Inicializador(ArrayList<Turno> turnos) throws FormatoMapaInvalidoException, IOException, ParseException, FormatoMapaInvalidoException {
        // inicializador sin enemigos
        Mapa mapa = new Mapa( "src/main/java/edu/fiuba/algo3/resources/mapa.json" );
        this.juego = new Juego(turnos, mapa);
    }

    public Inicializador(String jsonArchivoEnemigos, String jsonArchivoMapa) throws FormatoMapaInvalidoException, FormatoEnemigosInvalidoException, IOException, ParseException {
        Mapa mapa = new Mapa( jsonArchivoMapa );
        ArrayList<Turno> turnos = LoaderEnemigosJuego.recuperarTurnosYEnemigos(jsonArchivoEnemigos, mapa.getCoordenadasLargada());
        this.juego = new Juego(turnos, mapa);
    }

    public Juego obtenerJuego() {
        return this.juego;
    }

    public void agregarJugador(String nombre) {
        if(nombre.length() >= 6) {
            Jugador jugador = new Jugador(nombre);
            this.juego.setearJugador(jugador);
            logger.info(nombre + "se ha unido al juego");
        }
    }

}
