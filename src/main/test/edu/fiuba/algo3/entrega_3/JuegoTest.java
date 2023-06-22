package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.defensa.*;
import edu.fiuba.algo3.modelo.exceptions.FormatoEnemigosInvalidoException;
import edu.fiuba.algo3.modelo.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.juego.Inicializador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JuegoTest {
    static String MAP_RELATIVE_PATH = "src/main/test/edu/fiuba/algo3/resources/mapa.json";
    static String ENEMIGOS_RELATIVE_PATH = "src/main/test/edu/fiuba/algo3/resources/enemigos.json";
    // Test de aceptación
    @Test
    public void SePuedeJugarUnaPartidaDesdeLaPrueba() throws IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException, NoSePudoConstruirException {

        Inicializador inicio = new Inicializador(ENEMIGOS_RELATIVE_PATH, MAP_RELATIVE_PATH);
        inicio.agregarJugador("Pedroo");

        Juego juego = inicio.obtenerJuego();
        Mapa mapa =juego.obtenerMapa();
        Jugador jugador = juego.obtenerJugador();

        // Turno 1
        Defensa defensa1 = new TorrePlateada();
        jugador.generarConstruccion(defensa1, new Coordenadas(2, 3), mapa);

        Defensa defensa2 = new TorreBlanca();
        jugador.generarConstruccion(defensa2, new Coordenadas(3, 1), mapa);

        juego.avanzarTurno();

        // Turno 2
        Defensa defensa3 = new TrampaArenosa();
        jugador.generarConstruccion(defensa3, new Coordenadas(2, 2), mapa);

        juego.avanzarTurno();

        // Turno 3
        Defensa defensa4 = new TorreBlanca();
        jugador.generarConstruccion(defensa4, new Coordenadas(6, 1), mapa);

        juego.avanzarTurno();

        // Turno 4
        Defensa defensa5 = new TorrePlateada();
        jugador.generarConstruccion(defensa5, new Coordenadas(8, 3), mapa);

        juego.avanzarTurno();

        assertTrue(jugador.estaVivo());
    }
}
