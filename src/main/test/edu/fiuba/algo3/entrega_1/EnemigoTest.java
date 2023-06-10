package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.exceptions.*;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class EnemigoTest {
    @Test
    public void unaTorreBlancaAtacaAunaHormigaUnaVezYLaMata() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Defensa unaDefensa = new TorreBlanca();
        jugador.generarConstruccion(unaDefensa, coordenadasTorre);
        juego.avanzarTurno();

        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaHormiga) );
        assertThrows( ElEnemigoEstaMuertoException.class, () -> unaDefensa.atacarEnemigo(unaHormiga) );
    }
    @Test
    public void unaTorreBlancaAtacaNoPuedeAtacarAunaHormigaDosVecesPorqueEstaMuerta() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Defensa unaDefensa = new TorreBlanca();
        jugador.generarConstruccion(unaDefensa, coordenadasTorre);
        juego.avanzarTurno();

        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaHormiga) );
        assertThrows( ElEnemigoEstaMuertoException.class, () -> unaDefensa.atacarEnemigo(unaHormiga) );
    }
    @Test
    public void unaTorreBlancaAtacaAunaAraniaUnaVezYNoLaMata() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorreBlanca();
        jugador.generarConstruccion(unaDefensa, coordenadasTorre);
        juego.avanzarTurno();

        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaArania) );
        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaArania) );
        assertThrows( ElEnemigoEstaMuertoException.class, () -> unaDefensa.atacarEnemigo(unaArania) );
    }
    @Test
    public void unaTorreBlancaAtacaAunaAraniaDosVecesYLaMata() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorreBlanca();
        jugador.generarConstruccion(unaDefensa, coordenadasTorre);
        juego.avanzarTurno();

        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaArania) );
        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaArania) );
        assertThrows( ElEnemigoEstaMuertoException.class, () -> unaDefensa.atacarEnemigo(unaArania) );
    }
    @Test
    public void unaTorrePlateadaAtacaAunaHormigaUnaVezYLaMata() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Defensa unaDefensa = new TorrePlateada();
        jugador.generarConstruccion(unaDefensa, coordenadasTorre);
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaHormiga) );
        assertThrows( ElEnemigoEstaMuertoException.class, () -> unaDefensa.atacarEnemigo(unaHormiga) );
    }
    @Test
    public void unaTorrePlateadaAtacaAunaAraniaUnaVezYLaMata() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorrePlateada();
        jugador.generarConstruccion(unaDefensa, coordenadasTorre);
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaArania) );
        assertThrows( ElEnemigoEstaMuertoException.class, () -> unaDefensa.atacarEnemigo(unaArania) );
    }
    @Test
    public void unaTorrePlateadaNoPuedeAtacarDosVecesUnaArania() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorrePlateada();
        jugador.generarConstruccion(unaDefensa, coordenadasTorre);
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaArania) );
        assertThrows( ElEnemigoEstaMuertoException.class, () -> unaDefensa.atacarEnemigo(unaArania) );
    }

    /*
    CASO DE USO 8
    los enemigos devuelven los creditos correctamente y el jugador, los
    cobra correctamente
    */
    @Test
    public void matoAUnaHormigaYLeSuma1CredAlJugador() throws NoSePudoConstruirException, ElEnemigoMurioDuranteElAtaqueException,
            FueraDeRangoException, ElEnemigoEstaMuertoException, DefensaEnConstruccionException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador inicio = new Inicializador(fileEnemigos, fileMapa);

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Mapa mapa = juego.obtenerMapa();
        Jugador jugador = juego.obtenerJugador();
        Coordenadas coordenadasLargada = mapa.getCoordenadasLargada();

        Hormiga unaHormiga = new Hormiga(coordenadasLargada);
        juego.agregarEnemigo(unaHormiga);
        Coordenadas coordenadas = new Coordenadas(3, 2);
        Defensa torrePlateada = new TorrePlateada();

        jugador.generarConstruccion(torrePlateada, coordenadas);
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertEquals(80, jugador.obtenerCantidadDeCreditos());
        torrePlateada.atacarEnemigo(unaHormiga);
        assertThrows( ElEnemigoEstaMuertoException.class, () -> torrePlateada.atacarEnemigo(unaHormiga) );
        juego.avanzarTurno();
        assertEquals(81, jugador.obtenerCantidadDeCreditos());

    }

   @Test
    public void matoAUnaAraniaYLeSuma1CredAlJugador() throws ElEnemigoMurioDuranteElAtaqueException, FueraDeRangoException,
           ElEnemigoEstaMuertoException, DefensaEnConstruccionException, NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador inicio = new Inicializador(fileEnemigos, fileMapa);

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Mapa mapa = juego.obtenerMapa();
        Jugador jugador = juego.obtenerJugador();
        Coordenadas coordenadasLargada = mapa.getCoordenadasLargada();

        Arania unaArania = new Arania(coordenadasLargada);
        juego.agregarEnemigo(unaArania);
        Coordenadas coordenadas = new Coordenadas(3, 3);
        Defensa unatorre = new TorrePlateada();
        jugador.generarConstruccion(unatorre, coordenadas);
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertEquals(80, jugador.obtenerCantidadDeCreditos());
        unatorre.atacarEnemigo(unaArania);
        juego.avanzarTurno();
        assert( jugador.obtenerCantidadDeCreditos() > 80);
    }

    @Test
    public void matoAOnceHormigasYElJugadorTieneLosCreditosCorrectos() throws ElEnemigoMurioDuranteElAtaqueException, FueraDeRangoException,
            ElEnemigoEstaMuertoException, DefensaEnConstruccionException, NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador inicio = new Inicializador(fileEnemigos, fileMapa);

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Mapa mapa = juego.obtenerMapa();
        Jugador jugador = juego.obtenerJugador();
        Coordenadas coordenadasLargada = mapa.getCoordenadasLargada();

        Hormiga hormiga1 = new Hormiga(coordenadasLargada);
        juego.agregarEnemigo(hormiga1);

        Hormiga hormiga2 = new Hormiga(coordenadasLargada);
        juego.agregarEnemigo(hormiga2);

        Hormiga hormiga3 = new Hormiga(coordenadasLargada);
        juego.agregarEnemigo(hormiga3);

        Hormiga hormiga4 = new Hormiga(coordenadasLargada);
        juego.agregarEnemigo(hormiga4);
        Hormiga hormiga5 = new Hormiga(coordenadasLargada);
        juego.agregarEnemigo(hormiga5);
        Hormiga hormiga6 = new Hormiga(coordenadasLargada);
        juego.agregarEnemigo(hormiga6);
        Hormiga hormiga7 = new Hormiga(coordenadasLargada);
        juego.agregarEnemigo(hormiga7);
        Hormiga hormiga8 = new Hormiga(coordenadasLargada);
        juego.agregarEnemigo(hormiga8);

        Hormiga hormiga9 = new Hormiga(coordenadasLargada);
        juego.agregarEnemigo(hormiga9);
        Hormiga hormiga10 = new Hormiga(coordenadasLargada);
        juego.agregarEnemigo(hormiga10);
        Hormiga hormiga11 = new Hormiga(coordenadasLargada);
        juego.agregarEnemigo(hormiga11);

        Defensa unatorre = new TorrePlateada();
        Coordenadas coordenadas = new Coordenadas(2,3);
        jugador.generarConstruccion(unatorre, coordenadas);
        Defensa otratorre = new TorrePlateada();
        Coordenadas coordenadasTorre2 = new Coordenadas(11,5);
        jugador.generarConstruccion(otratorre, coordenadasTorre2);

        juego.avanzarTurno();
        juego.avanzarTurno();

        assertEquals(60, jugador.obtenerCantidadDeCreditos());
        unatorre.atacarEnemigo(hormiga1);
        juego.avanzarTurno();
        unatorre.atacarEnemigo(hormiga2);
        juego.avanzarTurno();
        unatorre.atacarEnemigo(hormiga3);
        juego.avanzarTurno();
        unatorre.atacarEnemigo(hormiga4);
        juego.avanzarTurno();
        otratorre.atacarEnemigo(hormiga5);
        juego.avanzarTurno();
        otratorre.atacarEnemigo(hormiga6);
        juego.avanzarTurno();
        otratorre.atacarEnemigo(hormiga7);
        juego.avanzarTurno();
        otratorre.atacarEnemigo(hormiga8);
        juego.avanzarTurno();
        otratorre.atacarEnemigo(hormiga9);
        juego.avanzarTurno();
        otratorre.atacarEnemigo(hormiga10);
        juego.avanzarTurno();
        otratorre.atacarEnemigo(hormiga11);
        juego.avanzarTurno();
        assertEquals(72, jugador.obtenerCantidadDeCreditos());
    }

}