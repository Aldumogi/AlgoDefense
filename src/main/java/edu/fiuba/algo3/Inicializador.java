package edu.fiuba.algo3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import edu.fiuba.algo3.exceptions.FormatoEnemigosInvalidoException;
import edu.fiuba.algo3.exceptions.FormatoMapaInvalidoException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Objects.isNull;

public class Inicializador {
    private Juego juego;

    public static final Logger logger = LogManager.getLogger(App.class);

    public Inicializador() throws IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        ArrayList<Turno> turnos = LoaderEnemigosJuego.recuperarTurnosYEnemigos();

        // LoaderMapaJuego.recuperarMapa();
        // this. juego = new Juego(turnos, mapa);
        this.juego = new Juego(turnos);
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
