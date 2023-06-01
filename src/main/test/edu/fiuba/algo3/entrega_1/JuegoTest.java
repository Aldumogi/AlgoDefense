package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JuegoTest {
    @Test
    public void juegoConDosEnemigosNoDeberiaEstarTerminado() {
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
    public void juegoSinEnemigosDeberiaEstarTerminado() {
      // Arrange
      Inicializador inicio = new Inicializador();

      inicio.agregarJugador("NombreDelJugador");
      Juego juego = inicio.obtenerJuego();

      // Act
      boolean terminado =  juego.juegoTerminado();

      // Assert
      assertTrue(terminado);
  }

  @Test
  public void test12() {
    Inicializador inicio = new Inicializador();

    inicio.agregarJugador("Alberto");
    Juego juego = inicio.obtenerJuego();
    Jugador jugador = juego.obtenerJugador();
    Coordenadas coordenadasMeta = new Coordenadas(5, 2);
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
