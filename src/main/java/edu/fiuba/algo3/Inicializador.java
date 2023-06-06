package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.FormatoMapaInvalidoException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Objects.isNull;

public class Inicializador {
    private Juego juego;

    public Inicializador() throws IOException, ParseException, FormatoMapaInvalidoException {
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
    }

}
