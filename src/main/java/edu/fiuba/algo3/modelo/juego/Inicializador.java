package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.enemigo.LoaderEnemigosJuego;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import static edu.fiuba.algo3.modelo.LoggerManager.logger;
import edu.fiuba.algo3.modelo.exceptions.FormatoEnemigosInvalidoException;
import edu.fiuba.algo3.modelo.exceptions.FormatoMapaInvalidoException;
import org.apache.logging.log4j.Logger;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inicializador {
    private Juego juego;
    public Inicializador() throws IOException, ParseException, FormatoMapaInvalidoException {
        // inicializador sin enemigos
        Mapa mapa = new Mapa( "src/main/java/edu/fiuba/algo3/resources/mapa.json" );
        ArrayList<Turno> turnos = new ArrayList<>();
        this.juego = new Juego(turnos, mapa);
    }
    public Inicializador(ArrayList<Turno> turnos) throws IOException, ParseException, FormatoMapaInvalidoException {
        // inicializador sin enemigos
        Mapa mapa = new Mapa( "src/main/java/edu/fiuba/algo3/resources/mapa.json" );
        this.juego = new Juego(turnos, mapa);
    }
    public Inicializador(String jsonArchivoEnemigos, String jsonArchivoMapa) throws IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        Mapa mapa = new Mapa( jsonArchivoMapa );
        ArrayList<Turno> turnos = LoaderEnemigosJuego.recuperarTurnosYEnemigos(jsonArchivoEnemigos, mapa.getCoordenadasLargada());
        this.juego = new Juego(turnos, mapa);
    }

    public Juego obtenerJuego() {
        return this.juego;
    }

    public void agregarJugador(String nombre) throws IOException, ParseException, FormatoMapaInvalidoException {
        int cantidadMinimaDeCaracteres = 6;
        Scanner scanner = new Scanner(System.in);

        while( nombre.length() < cantidadMinimaDeCaracteres ) {
            System.out.println("Ingrese el nombre del jugador (Mínimo " + cantidadMinimaDeCaracteres + " caracteres)");
            nombre = scanner.nextLine();
        }

        Jugador jugador = new Jugador(nombre);
        if ( juego == null ) this.juego = new Juego();
        this.juego.setearJugador(jugador);
        logger.info(nombre + "se ha unido al juego");
    }

}
