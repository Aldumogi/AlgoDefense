package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Arania;
import edu.fiuba.algo3.Enemigo;
import edu.fiuba.algo3.Hormiga;
import edu.fiuba.algo3.Inicializador;
import edu.fiuba.algo3.Jugador;
import edu.fiuba.algo3.Juego;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
