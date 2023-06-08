package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.exceptions.*;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JuegoTest {
    public class TesteableInicializador extends Inicializador {
      private Juego juego;
      public TesteableInicializador() throws IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        this.juego = new Juego();
      }
      public Juego obtenerJuego() {
        return this.juego;
      }
      public void agregarJugador(String nombre) {
        Jugador jugador = new Jugador(nombre);
        this.juego.setearJugador(jugador);
      }
    }
    @Test
    public void juegoConDosEnemigosNoDeberiaEstarTerminado() throws IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
      // Arrange
      Inicializador inicio = new Inicializador();

      inicio.agregarJugador("NombreDelJugador");
      Juego juego = inicio.obtenerJuego();
      
      juego.agregarEnemigo(new Arania());
      juego.agregarEnemigo(new Hormiga());

      // Act
      boolean terminado =  juego.juegoTerminado();

      // Assert
      assertFalse(terminado);
  }

  @Test
    public void juegoSinEnemigosDeberiaEstarTerminado() throws IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
      // Arrange
      TesteableInicializador inicio = new TesteableInicializador();

      inicio.agregarJugador("NombreDelJugador");
      Juego juego = inicio.obtenerJuego();

      // Act
      boolean terminado =  juego.juegoTerminado();

      // Assert
      assertTrue(terminado);
  }

  @Test
  public void caso11() throws ElEnemigoEstaMuertoException, FueraDeRangoException, DefensaEnConstruccionException, NoDisponibleParaConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
    TesteableInicializador inicio = new TesteableInicializador();

    inicio.agregarJugador("Alberto");
    Juego juego = inicio.obtenerJuego();
    Jugador jugador = juego.obtenerJugador();

    Defensa defensa = new TorrePlateada();
    Coordenadas coordDefensa = new Coordenadas(4,2);
    jugador.generarConstruccion(defensa, coordDefensa);

    juego.avanzarTurno();
    juego.avanzarTurno();

    Enemigo enemigo = new Arania(new Coordenadas(5,2));
    Enemigo enemigo1 = new Arania(new Coordenadas(5,2));
    Enemigo enemigo2 = new Arania(new Coordenadas(5,2));
    Enemigo enemigo3 = new Arania(new Coordenadas(5,2));
    Enemigo enemigo4 = new Arania(new Coordenadas(5,2));
    juego.agregarEnemigo(enemigo);

    try {
      defensa.atacarEnemigo(enemigo);
      defensa.atacarEnemigo(enemigo1);
      defensa.atacarEnemigo(enemigo2);
      defensa.atacarEnemigo(enemigo3);
      defensa.atacarEnemigo(enemigo4);
    }
    catch(ElEnemigoMurioDuranteElAtaqueException e) {}

    Enemigo enemigo5 = new Arania(new Coordenadas(5, 2));
    Enemigo enemigo6 = new Arania(new Coordenadas(5, 2));
    Enemigo enemigo7 = new Arania(new Coordenadas(5, 2));
    Enemigo enemigo8 = new Arania(new Coordenadas(5, 2));
    Enemigo enemigo9 = new Arania(new Coordenadas(5, 2));

    juego.avanzarTurno();

    boolean terminado =  juego.juegoTerminado();

    assertTrue(jugador.estaVivo());
    assertTrue(terminado);
  }

  @Test
  public void caso12() throws IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
    Inicializador inicio = new Inicializador();

    inicio.agregarJugador("Alberto");
    Juego juego = inicio.obtenerJuego();
    Jugador jugador = juego.obtenerJugador();
    Enemigo enemigo = new Arania(new Coordenadas(5,2));

    juego.agregarEnemigo(enemigo);
    juego.avanzarTurno();
    juego.avanzarTurno();
    juego.avanzarTurno();
    juego.avanzarTurno();
    juego.avanzarTurno();
    juego.avanzarTurno();
    juego.avanzarTurno();
    juego.avanzarTurno();
    juego.avanzarTurno();
    juego.avanzarTurno();

    assertFalse(jugador.estaVivo());
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
