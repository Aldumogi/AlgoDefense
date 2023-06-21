package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.defensa.Torre;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.enemigo.Arania;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.juego.Inicializador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

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
        ArrayList<Hormiga> hormigasAsesinadas = new ArrayList<>();

        Coordenadas coordenadasTorre = new Coordenadas(2,1);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Torre unaDefensa = new TorreBlanca();
        jugador.generarConstruccion(unaDefensa, coordenadasTorre, juego.obtenerMapa());
        juego.avanzarTurno();

        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaHormiga, hormigasAsesinadas) );
        assertThrows( ElEnemigoEstaMuertoException.class, () -> unaDefensa.atacarEnemigo(unaHormiga, hormigasAsesinadas) );
    }
    @Test
    public void unaTorreBlancaAtacaNoPuedeAtacarAunaHormigaDosVecesPorqueEstaMuerta() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();
        ArrayList<Hormiga> hormigasAsesinadas = new ArrayList<>();

        Coordenadas coordenadasTorre = new Coordenadas(2,1);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Torre unaDefensa = new TorreBlanca();
        jugador.generarConstruccion(unaDefensa, coordenadasTorre, juego.obtenerMapa());
        juego.avanzarTurno();

        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaHormiga, hormigasAsesinadas) );
        assertThrows( ElEnemigoEstaMuertoException.class, () -> unaDefensa.atacarEnemigo(unaHormiga, hormigasAsesinadas) );
    }
    @Test
    public void unaTorreBlancaAtacaAunaAraniaUnaVezYNoLaMata() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();
        ArrayList<Hormiga> hormigasAsesinadas = new ArrayList<>();

        Coordenadas coordenadasTorre = new Coordenadas(2,1);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Torre unaDefensa = new TorreBlanca();
        jugador.generarConstruccion(unaDefensa, coordenadasTorre, juego.obtenerMapa());
        juego.avanzarTurno();

        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaArania, hormigasAsesinadas) );
        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaArania, hormigasAsesinadas) );
        assertThrows( ElEnemigoEstaMuertoException.class, () -> unaDefensa.atacarEnemigo(unaArania, hormigasAsesinadas) );
    }
    @Test
    public void unaTorreBlancaAtacaAunaAraniaDosVecesYLaMata() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();
        ArrayList<Hormiga> hormigasAsesinadas = new ArrayList<>();

        Coordenadas coordenadasTorre = new Coordenadas(2,1);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Torre unaDefensa = new TorreBlanca();
        jugador.generarConstruccion(unaDefensa, coordenadasTorre, juego.obtenerMapa());
        juego.avanzarTurno();

        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaArania, hormigasAsesinadas) );
        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaArania, hormigasAsesinadas) );
        assertThrows( ElEnemigoEstaMuertoException.class, () -> unaDefensa.atacarEnemigo(unaArania, hormigasAsesinadas) );
    }
    @Test
    public void unaTorrePlateadaAtacaAunaHormigaUnaVezYLaMata() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();
        ArrayList<Hormiga> hormigasAsesinadas = new ArrayList<>();

        Coordenadas coordenadasTorre = new Coordenadas(2,1);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Torre unaDefensa = new TorrePlateada();
        jugador.generarConstruccion(unaDefensa, coordenadasTorre, juego.obtenerMapa());
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaHormiga, hormigasAsesinadas) );
        assertThrows( ElEnemigoEstaMuertoException.class, () -> unaDefensa.atacarEnemigo(unaHormiga, hormigasAsesinadas) );
    }
    @Test
    public void unaTorrePlateadaAtacaAunaAraniaUnaVezYLaMata() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();
        ArrayList<Hormiga> hormigasAsesinadas = new ArrayList<>();

        Coordenadas coordenadasTorre = new Coordenadas(2,1);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Torre unaDefensa = new TorrePlateada();
        jugador.generarConstruccion(unaDefensa, coordenadasTorre, juego.obtenerMapa());
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaArania, hormigasAsesinadas) );
        assertThrows( ElEnemigoEstaMuertoException.class, () -> unaDefensa.atacarEnemigo(unaArania, hormigasAsesinadas) );
    }
    @Test
    public void unaTorrePlateadaNoPuedeAtacarDosVecesUnaArania() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador ini = new Inicializador(fileEnemigos, fileMapa);
        ini.agregarJugador("Patricia");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();
        ArrayList<Hormiga> hormigasAsesinadas = new ArrayList<>();

        Coordenadas coordenadasTorre = new Coordenadas(2,1);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Torre unaDefensa = new TorrePlateada();
        jugador.generarConstruccion(unaDefensa, coordenadasTorre, juego.obtenerMapa());
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertDoesNotThrow( () -> unaDefensa.atacarEnemigo(unaArania, hormigasAsesinadas) );
        assertThrows( ElEnemigoEstaMuertoException.class, () -> unaDefensa.atacarEnemigo(unaArania, hormigasAsesinadas) );
    }

    /*
    CASO DE USO 8
    los enemigos devuelven los creditos correctamente y el jugador, los
    cobra correctamente
    */
    @Test
    public void matoAUnaHormigaYLeSuma1CredAlJugador() throws NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String filepath = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        Inicializador inicio = new Inicializador(filepath);

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Mapa mapa = juego.obtenerMapa();
        Jugador jugador = juego.obtenerJugador();
        Coordenadas coordenadasLargada = mapa.getCoordenadasLargada();
        ArrayList<Hormiga> hormigasAsesinadas = new ArrayList<>();

        Hormiga unaHormiga = new Hormiga(coordenadasLargada);
        juego.agregarEnemigo(unaHormiga);
        Coordenadas coordenadas = new Coordenadas(3, 1);
        Torre torrePlateada = new TorrePlateada();

        jugador.generarConstruccion(torrePlateada, coordenadas, juego.obtenerMapa());
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertEquals(80, jugador.obtenerCantidadDeCreditos());
        juego.avanzarTurno();
        assertThrows( ElEnemigoEstaMuertoException.class, () -> torrePlateada.atacarEnemigo(unaHormiga, hormigasAsesinadas) );
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
       ArrayList<Hormiga> hormigasAsesinadas = new ArrayList<>();

       Arania unaArania = new Arania(coordenadasLargada);
        juego.agregarEnemigo(unaArania);
        Coordenadas coordenadas = new Coordenadas(3, 3);
        Torre unatorre = new TorrePlateada();
        jugador.generarConstruccion(unatorre, coordenadas, juego.obtenerMapa());
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertEquals(80, jugador.obtenerCantidadDeCreditos());
        unatorre.atacarEnemigo(unaArania, hormigasAsesinadas);
        juego.avanzarTurno();
        assert( jugador.obtenerCantidadDeCreditos() > 80);
    }

    @Test
    public void matoAOnceHormigasYElJugadorTieneLosCreditosCorrectos() throws ElEnemigoMurioDuranteElAtaqueException, FueraDeRangoException,
            ElEnemigoEstaMuertoException, DefensaEnConstruccionException, NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        Inicializador inicio = new Inicializador(fileMapa);

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Mapa mapa = juego.obtenerMapa();
        Jugador jugador = juego.obtenerJugador();
        Coordenadas coordenadasLargada = mapa.getCoordenadasLargada();
        ArrayList<Hormiga> hormigas = new ArrayList<>();
        for ( int i = 0; i < 11 ; i++ ) {
            hormigas.add(new Hormiga(coordenadasLargada));
            juego.agregarEnemigo( hormigas.get(i) );
        }

        Torre unatorre = new TorrePlateada();
        Coordenadas coordenadas = new Coordenadas(2,3);
        jugador.generarConstruccion(unatorre, coordenadas, juego.obtenerMapa());
        Torre otratorre = new TorrePlateada();
        Coordenadas coordenadasTorre2 = new Coordenadas(11,5);
        jugador.generarConstruccion(otratorre, coordenadasTorre2, juego.obtenerMapa());

        juego.avanzarTurno();
        juego.avanzarTurno();

        assertEquals(60, jugador.obtenerCantidadDeCreditos());
        juego.avanzarTurno();

        assertEquals(72, jugador.obtenerCantidadDeCreditos());
    }

}