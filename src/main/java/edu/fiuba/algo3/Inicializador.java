package edu.fiuba.algo3;

import java.util.Scanner;

import static java.util.Objects.isNull;

public class Inicializador {
    private Juego juego;
    public void agregarJugador(String nombre) {
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

    public Juego obtenerJuego() { return this.juego; }
}
