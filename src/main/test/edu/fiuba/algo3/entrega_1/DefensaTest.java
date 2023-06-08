package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.exceptions.*;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class DefensaTest {
    /*
        CASO de USO 2
    */
    @Test
    public void construirTorreBlancaTardaLoIndicadoEnConstruirseYRecienEstaOperativaAlTerminarDeConstruirse() throws NoDisponibleParaConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        Inicializador ini = new Inicializador();
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();
        Defensa torreBlanca = new TorreBlanca();
        Coordenadas coordenadas = new Coordenadas(20, 50);

        jugador.generarConstruccion(torreBlanca, coordenadas);

        assert( torreBlanca.estadoDefensa().tiempoDeConstruccion() > 0);
        juego.avanzarTurno();
        assert( torreBlanca.estadoDefensa().tiempoDeConstruccion() == 0);
    }

    @Test
    public void construirTorrePlateadaTardaLoIndicadoYRecienEstaOperativaAlTerminarDeConstruirse() throws NoDisponibleParaConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        Inicializador ini = new Inicializador();
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();
        Defensa torrePlateada = new TorrePlateada();
        Coordenadas coordenadas = new Coordenadas(20, 50);

        jugador.generarConstruccion(torrePlateada, coordenadas);
        juego.avanzarTurno();

        assert( torrePlateada.estadoDefensa().tiempoDeConstruccion() > 0);
        juego.avanzarTurno();
        assert( torrePlateada.estadoDefensa().tiempoDeConstruccion() == 0);
    }
    /*
        CASO de USO 4 - Verificar solo se pueda construir defensas sobre tierra (y verificar lo contrario)
     */
    @Test
    public void defensaPuedeConstruirseSobreTierra() {
        // Arrange
        Defensa torreBlanca = new TorreBlanca();
        Coordenadas coordenadas = new Coordenadas(10,33);
        Parcela tierra = new Tierra(coordenadas);

        //Act, Assert
        assertDoesNotThrow(() -> {
            tierra.construir(torreBlanca);
        });
    }


    @Test
    public void defensaNoPuedeConstruirseSobreRoca() {
        // Arrange
        Defensa torreBlanca = new TorreBlanca();
        Coordenadas coordenadas = new Coordenadas(55,62);
        Parcela rocoso = new Rocoso(coordenadas);

        //Act, Assert
        assertThrows(NoDisponibleParaConstruirException.class, () -> {
            rocoso.construir(torreBlanca);
        });

    }

    @Test
    public void defensaNoPuedeConstruirseSobrePasarela() {
        // Arrange
        Defensa torreBlanca = new TorreBlanca();
        Coordenadas coordenadas = new Coordenadas(55,62);
        Parcela pasarela = new Pasarela(coordenadas);
        //Act, Assert
        assertThrows(NoDisponibleParaConstruirException.class, () -> {
            pasarela.construir(torreBlanca);
        });
    }

    @Test
    public void defensaNoPuedeConstruirseSobrePasarelaLargada() {
        // Arrange
        Defensa torreBlanca = new TorreBlanca();
        Coordenadas coordenadas = new Coordenadas(55,62);
        Parcela pasarelaLargada = new PasarelaLargada(coordenadas);
        //Act, Assert
        assertThrows(NoDisponibleParaConstruirException.class, () -> {
            pasarelaLargada.construir(torreBlanca);
        });
    }
    @Test
    public void defensaNoPuedeConstruirseSobrePasarelaMeta() {
        // Arrange
        Defensa torreBlanca = new TorreBlanca();
        Coordenadas coordenadas = new Coordenadas(55,62);
        Parcela pasarelaMeta = new PasarelaMeta(coordenadas);
        //Act, Assert
        assertThrows(NoDisponibleParaConstruirException.class, () -> {
            pasarelaMeta.construir(torreBlanca);
        });
    }

    /*
        CASO de USO 5 - Verificar que las defensas ataquen dentro del rango esperado (y verificar lo contrario)
     */

    @Test
    public void defensaTorreBlancaPuedeAtacarDentroDelRangoEsperado() throws NoDisponibleParaConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        //Arrange
        Inicializador ini = new Inicializador();
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Defensa torreBlanca = new TorreBlanca();
        jugador.generarConstruccion(torreBlanca, coordenadasTorre);
        juego.avanzarTurno();
        Enemigo hormiga = new Hormiga(coordenadasHormiga);

        //Act, Assert
        assertDoesNotThrow( () -> torreBlanca.atacarEnemigo(hormiga) );
    }

    @Test
    public void defensaTorrePlateadaPuedeAtacarDentroDelRangoEsperado() throws NoDisponibleParaConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        //Arrange
        Inicializador ini = new Inicializador();
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Defensa torrePlateada = new TorrePlateada();
        jugador.generarConstruccion(torrePlateada, coordenadasTorre);
        juego.avanzarTurno();
        juego.avanzarTurno();
        Enemigo hormiga = new Hormiga(coordenadasHormiga);

        //Act, Assert
        assertDoesNotThrow( () -> torrePlateada.atacarEnemigo(hormiga) );
    }

    @Test
    public void defensaTorreBlancaIntentaAtacarEnemigoFueraDelRangoNoCausaNingunDanio() throws NoDisponibleParaConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        //Arrange
        Inicializador ini = new Inicializador();
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Coordenadas coordenadasTorre = new Coordenadas(2,2); // rango 3
        Coordenadas coordenadasHormiga = new Coordenadas(30,100);
        Defensa torreBlanca = new TorreBlanca();
        jugador.generarConstruccion(torreBlanca, coordenadasTorre);
        juego.avanzarTurno();
        Enemigo hormiga = new Hormiga(coordenadasHormiga);  // 1 punto de energia

        //Act, Assert
        assertThrows( FueraDeRangoException.class, () -> torreBlanca.atacarEnemigo(hormiga) );
    }

    @Test
    public void defensaTorrePlateadaIntentaAtacarEnemigoFueraDelRangoNoCausaNingunDanio() throws NoDisponibleParaConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        //Arrange
        Inicializador ini = new Inicializador();
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(30,100);
        Defensa torrePlateada = new TorrePlateada();
        jugador.generarConstruccion(torrePlateada, coordenadasTorre);
        juego.avanzarTurno();
        juego.avanzarTurno();
        Enemigo hormiga = new Hormiga(coordenadasHormiga);  // 1 punto de energia

        //Act, Assert
        assertThrows( FueraDeRangoException.class, () -> torrePlateada.atacarEnemigo(hormiga) );
    }

}
