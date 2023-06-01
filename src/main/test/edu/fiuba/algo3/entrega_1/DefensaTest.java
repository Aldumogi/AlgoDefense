package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.exceptions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DefensaTest {
    /*
        CASO de USO 2
    */
    @Test
    public void construirTorreBlancaTardaLoIndicadoEnConstruirseYRecienEstaOperativaAlTerminarDeConstruirse() {
        Inicializador ini = new Inicializador();
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();
        Defensa torreBlanca = new TorreBlanca();
        Coordenadas coordenadas = new Coordenadas(20, 50);

        jugador.generarConstruccion(torreBlanca, coordenadas, juego.obtenerNumeroDeturno());

        assertThrows(DefensaEnConstruccionException.class, () -> torreBlanca.accionesDefensa().estaTerminada() );
        juego.avanzarTurno();
        assertDoesNotThrow( () -> torreBlanca.accionesDefensa().estaTerminada() );
    }

    @Test
    public void construirTorrePlateadaTardaLoIndicadoYRecienEstaOperativaAlTerminarDeConstruirse() {
        Inicializador ini = new Inicializador();
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();
        Defensa torrePlateada = new TorrePlateada();
        Coordenadas coordenadas = new Coordenadas(20, 50);

        jugador.generarConstruccion(torrePlateada, coordenadas, juego.obtenerNumeroDeturno());
        juego.avanzarTurno();

        assertThrows( DefensaEnConstruccionException.class, () -> torrePlateada.accionesDefensa().estaTerminada() );
        juego.avanzarTurno();
        assertDoesNotThrow( () -> torrePlateada.accionesDefensa().estaTerminada() );
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
            tierra.construir(torreBlanca, 0);
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
            rocoso.construir(torreBlanca, 0);
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
            pasarela.construir(torreBlanca, 0);
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
            pasarelaLargada.construir(torreBlanca, 0);
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
            pasarelaMeta.construir(torreBlanca, 0);
        });
    }

    /*
        CASO de USO 5 - Verificar que las defensas ataquen dentro del rango esperado (y verificar lo contrario)
     */

    @Test
    public void defensaTorreBlancaPuedeAtacarDentroDelRangoEsperado() throws NoDisponibleParaConstruirException {
        //Arrange
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Defensa torreBlanca = new TorreBlanca();
        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(torreBlanca, 0); // daño 1 punto, rango 3
        torreBlanca.terminarDeConstruir();
        Enemigo hormiga = new Hormiga(coordenadasHormiga);

        //Act, Assert
        assertTrue(torreBlanca.atacarEnemigo(hormiga));
        assertFalse(hormiga.estaVivo());

    }

    @Test
    public void defensaTorrePlateadaPuedeAtacarDentroDelRangoEsperado() throws NoDisponibleParaConstruirException {
        //Arrange
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Defensa torrePlateada = new TorrePlateada();
        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(torrePlateada, 0); // daño 2 punto, rango 5
        torrePlateada.terminarDeConstruir();
        Enemigo hormiga = new Hormiga(coordenadasHormiga);

        //Act, Assert
        assertTrue(torrePlateada.atacarEnemigo(hormiga));
        assertFalse(hormiga.estaVivo());
    }

    @Test
    public void defensaTorreBlancaIntentaAtacarEnemigoFueraDelRangoNoCausaNingunDanio() throws NoDisponibleParaConstruirException {
        //Arrange
        Coordenadas coordenadasTorre = new Coordenadas(2,2); // rango 3
        Coordenadas coordenadasHormiga = new Coordenadas(30,100);
        Defensa torreBlanca = new TorreBlanca();
        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(torreBlanca, 0); // daño 1 punto, rango 3
        torreBlanca.terminarDeConstruir();
        Enemigo hormiga = new Hormiga(coordenadasHormiga);  // 1 punto de energia

        //Act, Assert
        assertFalse(torreBlanca.atacarEnemigo(hormiga));
        assertTrue(hormiga.estaVivo());
    }

    @Test
    public void defensaTorrePlateadaIntentaAtacarEnemigoFueraDelRangoNoCausaNingunDanio() throws NoDisponibleParaConstruirException {
        //Arrange
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(30,100);
        Defensa torrePlateada = new TorrePlateada();
        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(torrePlateada, 0); // daño 2 punto, rango 5
        torrePlateada.terminarDeConstruir();
        Enemigo hormiga = new Hormiga(coordenadasHormiga);  // 1 punto de energia

        //Act, Assert
        assertFalse(torrePlateada.atacarEnemigo(hormiga));
        assertTrue(hormiga.estaVivo());
    }

}
