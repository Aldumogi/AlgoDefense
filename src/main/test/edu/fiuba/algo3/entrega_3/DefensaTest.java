package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.juego.Inicializador;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcela.*;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.juego.Juego;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class DefensaTest {
    /*
    *  TrampaArenosa
    * */
    @Test
    public void construirUnaTrampaArenosaRestaVeinticincoCreditos() throws IOException, ParseException, FormatoMapaInvalidoException, NoSePudoConstruirException {
        String rutaMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        Inicializador ini = new Inicializador(rutaMapa);
        ini.agregarJugador("Roberto");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        assertEquals( 100, jugador.obtenerCantidadDeCreditos() );
        jugador.generarConstruccion( new TrampaArenosa() , new Coordenadas( 7, 4 ), juego.obtenerMapa() );
        assertEquals( 75, jugador.obtenerCantidadDeCreditos() );
    }

    @Test
    public void trampaArenosaSoloSePuedeConstruirEnUnaPasarelaQueNoSeaNiLargadaNiMeta() throws IOException, ParseException, FormatoMapaInvalidoException, NoSePudoConstruirException {
        String rutaMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        Inicializador ini = new Inicializador(rutaMapa);
        ini.agregarJugador("Roberto");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();
        Mapa mapa = juego.obtenerMapa();
        Coordenadas coordenadasTierra = new Coordenadas( 3, 4 );
        Coordenadas coordenadasRocoso = new Coordenadas( 5, 3 );
        Coordenadas coordenadasLargada = mapa.getCoordenadasLargada();
        Coordenadas coordenadasMeta = mapa.getCoordenadasMeta();
        Coordenadas coordenadasPasarela = new Coordenadas( 5, 2 );

        assertThat( mapa.obtenerCelda( coordenadasTierra ) , instanceOf( Tierra.class ) );
        assertThrows( NoSePudoConstruirException.class, () -> jugador.generarConstruccion( new TrampaArenosa() , coordenadasTierra , juego.obtenerMapa() ) );
        assertThat( mapa.obtenerCelda( coordenadasRocoso ) , instanceOf( Rocoso.class ) );
        assertThrows( NoSePudoConstruirException.class, () -> jugador.generarConstruccion( new TrampaArenosa() , coordenadasRocoso , juego.obtenerMapa() ) );
        assertThat( mapa.obtenerCelda( coordenadasLargada ) , instanceOf( PasarelaLargada.class ) );
        assertThrows( NoSePudoConstruirException.class, () -> jugador.generarConstruccion( new TrampaArenosa() , coordenadasLargada , juego.obtenerMapa() ) );
        assertThat( mapa.obtenerCelda( coordenadasMeta ) , instanceOf( PasarelaMeta.class ) );
        assertThrows( NoSePudoConstruirException.class, () -> jugador.generarConstruccion( new TrampaArenosa() , coordenadasMeta , juego.obtenerMapa() ) );
        assertThat( mapa.obtenerCelda( coordenadasPasarela ) , instanceOf( Pasarela.class ) );
        assertDoesNotThrow( () -> jugador.generarConstruccion( new TrampaArenosa() , coordenadasPasarela , juego.obtenerMapa() ) );

    }


}
