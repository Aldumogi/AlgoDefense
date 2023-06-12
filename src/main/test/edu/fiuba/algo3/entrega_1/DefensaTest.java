package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.defensa.Torre;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import edu.fiuba.algo3.modelo.exceptions.FormatoEnemigosInvalidoException;
import edu.fiuba.algo3.modelo.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.modelo.exceptions.FueraDeRangoException;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.juego.Inicializador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.parcela.*;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class DefensaTest {
    /*
        CASO de USO 2
    */
    @Test
    public void construirTorreBlancaTardaLoIndicadoEnConstruirseYRecienEstaOperativaAlTerminarDeConstruirse() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();
        Defensa torreBlanca = new TorreBlanca();
        Coordenadas coordenadasTierra = new Coordenadas(2, 1);

        jugador.generarConstruccion(torreBlanca, coordenadasTierra, juego.obtenerMapa());

        assert( torreBlanca.estadoDefensa().tiempoDeConstruccion() > 0);
        juego.avanzarTurno();
        assert( torreBlanca.estadoDefensa().tiempoDeConstruccion() == 0);
    }

    @Test
    public void construirTorrePlateadaTardaLoIndicadoYRecienEstaOperativaAlTerminarDeConstruirse() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();
        Defensa torrePlateada = new TorrePlateada();
        Coordenadas coordenadasTierra = new Coordenadas(2, 1);

        jugador.generarConstruccion(torrePlateada, coordenadasTierra, juego.obtenerMapa());
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
        Torre torreBlanca = new TorreBlanca();
        Coordenadas coordenadasTierra = new Coordenadas(2,1);
        Parcela tierra = new Tierra(coordenadasTierra);

        //Act, Assert
        assertDoesNotThrow(() -> {
            tierra.construir(torreBlanca);
        });
    }


    @Test
    public void defensaNoPuedeConstruirseSobreRoca() {
        // Arrange
        Torre torreBlanca = new TorreBlanca();
        Coordenadas coordenadas = new Coordenadas(55,62);
        Parcela rocoso = new Rocoso(coordenadas);

        //Act, Assert
        assertThrows(NoSePudoConstruirException.class, () -> {
            rocoso.construir(torreBlanca);
        });

    }

    @Test
    public void defensaNoPuedeConstruirseSobrePasarela() {
        // Arrange
        Torre torreBlanca = new TorreBlanca();
        Coordenadas coordenadas = new Coordenadas(55,62);
        Parcela pasarela = new Pasarela(coordenadas);
        //Act, Assert
        assertThrows(NoSePudoConstruirException.class, () -> {
            pasarela.construir(torreBlanca);
        });
    }

    @Test
    public void defensaNoPuedeConstruirseSobrePasarelaLargada() {
        // Arrange
        Torre torreBlanca = new TorreBlanca();
        Coordenadas coordenadas = new Coordenadas(55,62);
        Parcela pasarelaLargada = new PasarelaLargada(coordenadas);
        //Act, Assert
        assertThrows(NoSePudoConstruirException.class, () -> {
            pasarelaLargada.construir(torreBlanca);
        });
    }
    @Test
    public void defensaNoPuedeConstruirseSobrePasarelaMeta() {
        // Arrange
        Torre torreBlanca = new TorreBlanca();
        Coordenadas coordenadas = new Coordenadas(55,62);
        Parcela pasarelaMeta = new PasarelaMeta(coordenadas);
        //Act, Assert
        assertThrows(NoSePudoConstruirException.class, () -> {
            pasarelaMeta.construir(torreBlanca);
        });
    }

    /*
        CASO de USO 5 - Verificar que las defensas ataquen dentro del rango esperado (y verificar lo contrario)
     */

    @Test
    public void defensaTorreBlancaPuedeAtacarDentroDelRangoEsperado() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        //Arrange
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Coordenadas coordenadasTorre = new Coordenadas(2,1);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Defensa torreBlanca = new TorreBlanca();
        jugador.generarConstruccion(torreBlanca, coordenadasTorre, juego.obtenerMapa());
        juego.avanzarTurno();
        Enemigo hormiga = new Hormiga(coordenadasHormiga);

        //Act, Assert
        assertDoesNotThrow( () -> torreBlanca.atacarEnemigo(hormiga) );
    }

    @Test
    public void defensaTorrePlateadaPuedeAtacarDentroDelRangoEsperado() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        //Arrange
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Coordenadas coordenadasTorre = new Coordenadas(2,1);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Defensa torrePlateada = new TorrePlateada();
        jugador.generarConstruccion(torrePlateada, coordenadasTorre, juego.obtenerMapa());
        juego.avanzarTurno();
        juego.avanzarTurno();
        Enemigo hormiga = new Hormiga(coordenadasHormiga);

        //Act, Assert
        assertDoesNotThrow( () -> torrePlateada.atacarEnemigo(hormiga) );
    }

    @Test
    public void defensaTorreBlancaIntentaAtacarEnemigoFueraDelRangoNoCausaNingunDanio() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        //Arrange
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Coordenadas coordenadasTorre = new Coordenadas(2,1); // rango 3
        Coordenadas coordenadasHormiga = new Coordenadas(30,100);
        Defensa torreBlanca = new TorreBlanca();
        jugador.generarConstruccion(torreBlanca, coordenadasTorre, juego.obtenerMapa());
        juego.avanzarTurno();
        Enemigo hormiga = new Hormiga(coordenadasHormiga);  // 1 punto de energia

        //Act, Assert
        assertThrows( FueraDeRangoException.class, () -> torreBlanca.atacarEnemigo(hormiga) );
    }

    @Test
    public void defensaTorrePlateadaIntentaAtacarEnemigoFueraDelRangoNoCausaNingunDanio() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        //Arrange
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Coordenadas coordenadasTorre = new Coordenadas(2,1);
        Coordenadas coordenadasHormiga = new Coordenadas(30,100);
        Defensa torrePlateada = new TorrePlateada();
        jugador.generarConstruccion(torrePlateada, coordenadasTorre, juego.obtenerMapa());
        juego.avanzarTurno();
        juego.avanzarTurno();
        Enemigo hormiga = new Hormiga(coordenadasHormiga);  // 1 punto de energia

        //Act, Assert
        assertThrows( FueraDeRangoException.class, () -> torrePlateada.atacarEnemigo(hormiga) );
    }

}
