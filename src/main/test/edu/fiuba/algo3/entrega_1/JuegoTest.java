package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.exceptions.*;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

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
  public void caso11() throws ElEnemigoEstaMuertoException, ElEnemigoMurioDuranteElAtaqueException, FueraDeRangoException, DefensaEnConstruccionException, NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
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
}
