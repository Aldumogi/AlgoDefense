package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Defensa;
import edu.fiuba.algo3.Inicializador;
import edu.fiuba.algo3.Jugador;
import edu.fiuba.algo3.TorreBlanca;
import edu.fiuba.algo3.TorrePlateada;
import edu.fiuba.algo3.Juego;
import edu.fiuba.algo3.Coordenadas;
import edu.fiuba.algo3.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    @Test
    public void jugadorEmpiezaConVidaYCreditosCorrespondientes() throws IOException, ParseException, FormatoMapaInvalidoException {
        Inicializador inicio = new Inicializador();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        assertEquals( 20, jugador.obtenerPuntosDeVida() );
        assertEquals(100, jugador.obtenerCantidadDeCreditos());
    }
    @Test
    public void generoUnaDefensaYSeAgregaAlaListaDeDefensas() throws NoDisponibleParaConstruirException, IOException, ParseException, FormatoMapaInvalidoException {
        Inicializador inicio = new Inicializador();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        TorrePlateada unaTorre = new TorrePlateada();
        Coordenadas coordenadas = new Coordenadas(10, 20);

        assertDoesNotThrow( () -> jugador.generarConstruccion(unaTorre, coordenadas) );
        assertEquals( 1, jugador.obtenerDefensas().size() );
    }
    
    @Test
    public void siMeQuedoSinCreditosNoSeGeneraNingunaDefensa() throws NoDisponibleParaConstruirException, IOException, ParseException, FormatoMapaInvalidoException {
        Inicializador inicio = new Inicializador();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        TorrePlateada unaTorre1 = new TorrePlateada();
        Coordenadas coordenadasTorre1 = new Coordenadas(11, 21);
        jugador.generarConstruccion(unaTorre1, coordenadasTorre1);

        TorrePlateada unaTorre2 = new TorrePlateada();
        Coordenadas coordenadasTorre2 = new Coordenadas(12, 22);
        jugador.generarConstruccion(unaTorre2, coordenadasTorre2);

        TorrePlateada unaTorre3 = new TorrePlateada();
        Coordenadas coordenadasTorre3 = new Coordenadas(13, 23);
        jugador.generarConstruccion(unaTorre3, coordenadasTorre3);

        TorrePlateada unaTorre4 = new TorrePlateada();
        Coordenadas coordenadasTorre4 = new Coordenadas(14, 24);
        jugador.generarConstruccion(unaTorre4, coordenadasTorre4);

        TorrePlateada unaTorre5 = new TorrePlateada();
        Coordenadas coordenadasTorre5 = new Coordenadas(15, 25);
        jugador.generarConstruccion(unaTorre5, coordenadasTorre5);

        TorrePlateada unaTorre6 = new TorrePlateada();
        Coordenadas coordenadasTorre6 = new Coordenadas(20, 30);

        assertDoesNotThrow( () -> jugador.generarConstruccion(unaTorre6, coordenadasTorre6) );
        assertEquals( 5, jugador.obtenerDefensas().size() );

    }
}
