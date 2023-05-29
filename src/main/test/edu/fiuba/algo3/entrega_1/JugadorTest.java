package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Inicializador;
import edu.fiuba.algo3.Jugador;
import edu.fiuba.algo3.Juego;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {
    @Test
    public void jugadorEmpiezaConVidaYCreditosCorrespondientes() {
        Inicializador inicio = new Inicializador();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        assertEquals( 20, jugador.obtenerPuntosDeVida() );
        assertEquals(100, jugador.obtenerCantidadDeCreditos());
    }
}
