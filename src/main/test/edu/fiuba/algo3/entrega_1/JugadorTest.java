package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    public void generoUnaDefensaYSeAgregaAlaListaDeDefensas() {
        Inicializador inicio = new Inicializador();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        TorrePlateada unaTorre = new TorrePlateada();
        boolean sePudoConstruir = jugador.generarConstruccion(unaTorre);

        assertEquals( 20, unaTorre.costo() );
        assertTrue( sePudoConstruir );
        assertEquals( 1, jugador.obtenerDefensas().size() );
    }
    
    @Test
    public void siMeQuedoSinCreditosNoSeGeneraNingunaDefensa() {
        Inicializador inicio = new Inicializador();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        TorrePlateada unaTorre1 = new TorrePlateada();
        jugador.generarConstruccion(unaTorre1);

        TorrePlateada unaTorre2 = new TorrePlateada();
        jugador.generarConstruccion(unaTorre2);

        TorrePlateada unaTorre3 = new TorrePlateada();
        jugador.generarConstruccion(unaTorre3);

        TorrePlateada unaTorre4 = new TorrePlateada();
        jugador.generarConstruccion(unaTorre4);

        TorrePlateada unaTorre5 = new TorrePlateada();
        jugador.generarConstruccion(unaTorre5);

        TorrePlateada unaTorre6 = new TorrePlateada();

        assertEquals( 20, unaTorre1.costo() );
        assertFalse( jugador.generarConstruccion(unaTorre6) );
        assertEquals( 5, jugador.obtenerDefensas().size() );

    }
}
