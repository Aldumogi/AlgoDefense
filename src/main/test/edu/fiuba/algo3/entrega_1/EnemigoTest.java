package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemigoTest {
    @Test
    public void unaTorreBlancaAtacaAunaHormigaUnaVezYLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Defensa unaDefensa = new TorreBlanca();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa, 0);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaHormiga);

        assertFalse(unaHormiga.estaVivo());

    }
    @Test
    public void unaTorreBlancaAtacaNoPuedeAtacarAunaHormigaDosVecesPorqueEstaMuerta() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Defensa unaDefensa = new TorreBlanca();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa, 0);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaHormiga);
        boolean pudeAtacar = unaDefensa.atacarEnemigo(unaHormiga);

        assertFalse(pudeAtacar);

    }
    @Test
    public void unaTorreBlancaAtacaAunaAraniaYNoLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorreBlanca();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa, 0);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaArania);

        assertTrue(unaArania.estaVivo());

    }
    @Test
    public void unaTorreBlancaAtacaAunaAraniaDosVecesYLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorreBlanca();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa, 0);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaArania);
        unaDefensa.atacarEnemigo(unaArania);

        assertFalse(unaArania.estaVivo());

    }
    @Test
    public void unaTorrePlateadaAtacaAunaHormigaUnaVezYLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Defensa unaDefensa = new TorrePlateada();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa, 0);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaHormiga);

        assertFalse(unaHormiga.estaVivo());

    }
    @Test
    public void unaTorrePlateadaAtacaAunaAraniaUnaVezYLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorrePlateada();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa, 0);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaArania);

        assertFalse(unaArania.estaVivo());

    }
    @Test
    public void unaTorrePlateadaNoPuedeAtacarDosVecesUnaArania() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorrePlateada();

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa, 0);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaArania);
        boolean pudeAtacar = unaDefensa.atacarEnemigo(unaArania);
        assertFalse(pudeAtacar);

    }

    /*
    CASO DE USO 8
    los enemigos devuelven los creditos correctamente y el jugador, los
    cobra correctamente
    */
    @Test
    public void matoAUnaHormigaYLeSuma1CredAlJugador() throws NoDisponibleParaConstruirException{
        Inicializador inicio = new Inicializador();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Hormiga unaHormiga = new Hormiga();
        juego.agregarEnemigo(unaHormiga);
        Coordenadas coordenadas = new Coordenadas(3, 2);
        Defensa torrePlateada = new TorrePlateada();

        jugador.generarConstruccion(torrePlateada, coordenadas, juego.obtenerNumeroDeturno());
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertEquals(80, jugador.obtenerCantidadDeCreditos());
        torrePlateada.atacarEnemigo(unaHormiga);
        assertEquals(-1, unaHormiga.energia() );
        juego.avanzarTurno();
        assertEquals(81, jugador.obtenerCantidadDeCreditos());

    }

   @Test
    public void matoAUnaAraniaYLeSuma1CredAlJugador() {
        Inicializador inicio = new Inicializador();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Arania unaArania = new Arania();
        juego.agregarEnemigo(unaArania);
        Coordenadas coordenadas = new Coordenadas(3, 3);
        Defensa unatorre = new TorrePlateada();
        jugador.generarConstruccion(unatorre, coordenadas, juego.obtenerNumeroDeturno());
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertEquals(80, jugador.obtenerCantidadDeCreditos());
        unatorre.atacarEnemigo(unaArania);
        juego.avanzarTurno();
        assert( jugador.obtenerCantidadDeCreditos() > 80);
    }

    @Test
    public void matoAnceAraniasYElJugadorTieneLosCreditosCorrectos() {
        Inicializador inicio = new Inicializador();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Hormiga hormiga1 = new Hormiga();
        juego.agregarEnemigo(hormiga1);

        Hormiga hormiga2 = new Hormiga();
        juego.agregarEnemigo(hormiga2);

        Hormiga hormiga3 = new Hormiga();
        juego.agregarEnemigo(hormiga3);

        Hormiga hormiga4 = new Hormiga();
        juego.agregarEnemigo(hormiga4);
        Hormiga hormiga5 = new Hormiga();
        juego.agregarEnemigo(hormiga5);
        Hormiga hormiga6 = new Hormiga();
        juego.agregarEnemigo(hormiga6);
        Hormiga hormiga7 = new Hormiga();
        juego.agregarEnemigo(hormiga7);
        Hormiga hormiga8 = new Hormiga();
        juego.agregarEnemigo(hormiga8);

        Hormiga hormiga9 = new Hormiga();
        juego.agregarEnemigo(hormiga9);
        Hormiga hormiga10 = new Hormiga();
        juego.agregarEnemigo(hormiga10);
        Hormiga hormiga11 = new Hormiga();
        juego.agregarEnemigo(hormiga11);

        Defensa unatorre = new TorrePlateada();
        Coordenadas coordenadas = new Coordenadas(3,3);
        jugador.generarConstruccion(unatorre, coordenadas, juego.obtenerNumeroDeturno());
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertEquals(80, jugador.obtenerCantidadDeCreditos());
        unatorre.atacarEnemigo(hormiga1);
        juego.avanzarTurno();
        unatorre.atacarEnemigo(hormiga2);
        juego.avanzarTurno();
        unatorre.atacarEnemigo(hormiga3);
        juego.avanzarTurno();
        unatorre.atacarEnemigo(hormiga4);
        juego.avanzarTurno();
        unatorre.atacarEnemigo(hormiga5);
        juego.avanzarTurno();
        unatorre.atacarEnemigo(hormiga6);
        juego.avanzarTurno();
        unatorre.atacarEnemigo(hormiga7);
        juego.avanzarTurno();
        unatorre.atacarEnemigo(hormiga8);
        juego.avanzarTurno();
        unatorre.atacarEnemigo(hormiga9);
        juego.avanzarTurno();
        unatorre.atacarEnemigo(hormiga10);
        juego.avanzarTurno();
        unatorre.atacarEnemigo(hormiga11);
        juego.avanzarTurno();
        assertEquals(92, jugador.obtenerCantidadDeCreditos());
    }
}