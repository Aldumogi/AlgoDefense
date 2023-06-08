package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.exceptions.*;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class JuegoTest {
    @Test
    public void elJuegoSeCreaAcordeAAmbosJSON() throws FormatoEnemigosInvalidoException, IOException, ParseException, FormatoMapaInvalidoException, NoSePudoBorrarElEnemigoException {

        List<Enemigo> enemigosEnLaPasarela;
        Inicializador inicio = new Inicializador();
        inicio.agregarJugador("NombreDelJugador");
        Juego juego = inicio.obtenerJuego();
        Mapa mapaCargadoEnElJuego = juego.obtenerMapa();

        Coordenadas coordenadasLargada = new Coordenadas(1, 2);
        Parcela parcela = mapaCargadoEnElJuego.obtenerCelda(coordenadasLargada);

        // Assert
        assertThat(parcela, instanceOf(PasarelaLargada.class) );
        enemigosEnLaPasarela = parcela.obtener();

        // turno 1
        assertEquals(1, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 2
        assertEquals(2, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        assertThat(enemigosEnLaPasarela.get(1), instanceOf(Arania.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 3
        assertEquals(3, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        assertThat(enemigosEnLaPasarela.get(1), instanceOf(Hormiga.class));
        assertThat(enemigosEnLaPasarela.get(2), instanceOf(Arania.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 4
        assertEquals(1, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Arania.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 5
        assertEquals(2, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        assertThat(enemigosEnLaPasarela.get(1), instanceOf(Arania.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 6
        assertEquals(3, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        assertThat(enemigosEnLaPasarela.get(1), instanceOf(Arania.class));
        assertThat(enemigosEnLaPasarela.get(2), instanceOf(Arania.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 7
        assertEquals(1, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Arania.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 8
        assertEquals(1, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 9
        assertEquals(1, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 10
        assertEquals(2, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        assertThat(enemigosEnLaPasarela.get(1), instanceOf(Hormiga.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 11
        assertEquals(1, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Arania.class));
        juego.avanzarTurno();
        mapaCargadoEnElJuego.borrar( enemigosEnLaPasarela.get(0) );

        // turno 12
        assertEquals(3, enemigosEnLaPasarela.size() );
        assertThat(enemigosEnLaPasarela.get(0), instanceOf(Hormiga.class));
        assertThat(enemigosEnLaPasarela.get(1), instanceOf(Arania.class));
        assertThat(enemigosEnLaPasarela.get(1), instanceOf(Arania.class));

    }

  /*
    Caso de Uso 18 - Simular y verificar que el jugador gane una partida
   */
  @Test
  public void caso18() throws FormatoEnemigosInvalidoException, IOException, ParseException, FormatoMapaInvalidoException, NoDisponibleParaConstruirException {
    // Arrange
    Jugador jugador = new Jugador("Alberto");
    Mapa mapa = new Mapa("src/main/test/edu/fiuba/algo3/resources/mapaValido.json");
    ArrayList<Turno> turnos = LoaderEnemigosJuego.recuperarTurnosYEnemigos("src/main/test/edu/fiuba/algo3/resources/enemigosValido.json");
    // turno 1
    Juego juego = new Juego(jugador, mapa, turnos);

    Defensa defensa1 = new TorrePlateada();
    Coordenadas coordDefensa1 = new Coordenadas(2,1); // coordenadas validas de mapaValido.Json
    jugador.generarConstruccion(defensa1, coordDefensa1);

    Defensa defensa2 = new TorrePlateada();
    Coordenadas coordDefensa2 = new Coordenadas(1,3);
    jugador.generarConstruccion(defensa2, coordDefensa2);

    // Act
    juego.avanzarTurno(); // pasa a turno 2

    Defensa defensa3 = new TorrePlateada();
    Coordenadas coordDefensa3 = new Coordenadas(4,3);
    jugador.generarConstruccion(defensa3, coordDefensa3);

    juego.avanzarTurno(); // pasa a turno 3, se termina de construir defensa1 y defensa2
    juego.jugar();  // aca defensa1 y defensa2 deben atacar a enemigos dentro de su rango
    juego.avanzarTurno(); // pasa a turno 4, se termina de construir defensa3
    juego.avanzarTurno(); // pasa a turno 5

    // Assert
    assertTrue(juego.juegoTerminado());
    assertTrue(jugador.estaVivo());
  }

  /*
    Caso de Uso 19 - Simular y verificar que el jugador pierde una partida
   */
  @Test
  public void caso19() throws FormatoEnemigosInvalidoException, IOException, ParseException, FormatoMapaInvalidoException, NoDisponibleParaConstruirException {
    // Arrange
    Jugador jugador = new Jugador("Alberto");
    Mapa mapa = new Mapa("src/main/test/edu/fiuba/algo3/resources/mapaValido.json");
    ArrayList<Turno> turnos = LoaderEnemigosJuego.recuperarTurnosYEnemigos("src/main/test/edu/fiuba/algo3/resources/enemigosValido.json");
    // turno 1
    Juego juego = new Juego(jugador, mapa, turnos);

    Defensa defensa = new TorrePlateada();
    Coordenadas coordDefensa = new Coordenadas(2,1); // coordenadas validas de mapaValido.Json
    jugador.generarConstruccion(defensa, coordDefensa);

    // Act
    juego.avanzarTurno(); // pasa a turno 2
    juego.avanzarTurno(); // pasa a turno 3, se termina de construir defensa
    juego.jugar();  // defensa deben atacar a enemigo dentro de su rango
    juego.avanzarTurno(); // pasa a turno 4
    juego.moverEnemigosAMeta();
    juego.avanzarTurno(); // pasa a turno 5

    // Assert
    assertTrue(juego.juegoTerminado());
    assertFalse(jugador.estaVivo());
  }

}
