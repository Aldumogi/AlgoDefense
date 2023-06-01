package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Arania;
import edu.fiuba.algo3.Coordenadas;
import edu.fiuba.algo3.Defensa;
import edu.fiuba.algo3.Hormiga;
import edu.fiuba.algo3.Inicializador;
import edu.fiuba.algo3.Juego;
import edu.fiuba.algo3.Jugador;
import edu.fiuba.algo3.Tierra;
import edu.fiuba.algo3.TorreBlanca;
import edu.fiuba.algo3.TorrePlateada;
import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

    //Caso de uso 6, verifico que las unidades enemigas son dañadas acorde al
    //daño recibido

public class EnemigoTest {
    @Test
    public void unaTorreBlancaAtacaAunaHormigaUnaVezYLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Defensa unaDefensa = new TorreBlanca(new Jugador("carlos"));

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaHormiga);

        assertFalse(unaHormiga.estaVivo());

    }
    @Test
    public void unaTorreBlancaAtacaNoPuedeAtacarAunaHormigaDosVecesPorqueEstaMuerta() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Defensa unaDefensa = new TorreBlanca(new Jugador("carlos"));

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa);
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
        Defensa unaDefensa = new TorreBlanca(new Jugador("carlos"));

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaArania);

        assertTrue(unaArania.estaVivo());

    }
    @Test
    public void unaTorreBlancaAtacaaAunaAraniaDosVecesYLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorreBlanca(new Jugador("carlos"));

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaArania);
        unaDefensa.atacarEnemigo(unaArania);

        assertFalse(unaArania.estaVivo());

    }
    @Test
    public void unaTorrePlateadaaAtacaAunaHormigaUnaVezYLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Hormiga unaHormiga = new Hormiga(coordenadasHormiga);
        Defensa unaDefensa = new TorrePlateada(new Jugador("carlos"));

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaHormiga);

        assertFalse(unaHormiga.estaVivo());

    }
    @Test

    public void unaTorrePlateadaaAtacaAunaAraniaUnaVezYLaMata() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorrePlateada(new Jugador("carlos"));

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa);
        unaDefensa.terminarDeConstruir();

        unaDefensa.atacarEnemigo(unaArania);

        assertFalse(unaArania.estaVivo());

    }
    @Test
    public void unaTorrePlateadaaNoPuedeAtacarDosVecesUnaArania() throws NoDisponibleParaConstruirException {
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasArania = new Coordenadas(3,1);
        Arania unaArania = new Arania(coordenadasArania);
        Defensa unaDefensa = new TorrePlateada(new Jugador("carlos"));

        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(unaDefensa);
        unaDefensa.terminarDeConstruir();

    }
    @Test
    public void unaTorrePlateadaAtacaAunaAraniaUnaVezYLaMata() {
        Inicializador inicio = new Inicializador();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Arania unaArania = new Arania();
        Defensa unaDefensa = new TorrePlateada(jugador);
        unaDefensa.atacarEnemigo(unaArania);

        assertEquals( unaArania.estaVivo(), false );

    }
    @Test
    public void unaTorrePlateadaNoPuedeAtacarDosVecesUnaArania() {
        Inicializador inicio = new Inicializador();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Arania unaArania = new Arania();
        Defensa unaDefensa = new TorrePlateada(jugador);
        unaDefensa.atacarEnemigo(unaArania);
        boolean pudeAtacar = unaDefensa.atacarEnemigo(unaArania);
        assertFalse(pudeAtacar);

    }

    //caso 8, los enemigos devuelven los creditos correctamente y el jugador, los 
    //cobra correctamente
    @Test
    public void matoAUnaHormigaYLeSuma1CredAlJugador() {
        Inicializador inicio = new Inicializador();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Hormiga unaHormiga = new Hormiga();
        juego.agregarEnemigo(unaHormiga);
        Defensa unatorre = new TorrePlateada(jugador);
        jugador.generarConstruccion(unatorre);

        assertEquals(80, jugador.obtenerCantidadDeCreditos());  
        unatorre.atacarEnemigo(unaHormiga); 
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
        Defensa unatorre = new TorrePlateada(jugador);
        jugador.generarConstruccion(unatorre);

        assertEquals(80, jugador.obtenerCantidadDeCreditos());  
        unatorre.atacarEnemigo(unaArania); 
        boolean seSumoCreditos = (jugador.obtenerCantidadDeCreditos() != 80);
        assertTrue(seSumoCreditos);

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

        Defensa unatorre = new TorrePlateada(jugador);
        jugador.generarConstruccion(unatorre);

        assertEquals(80, jugador.obtenerCantidadDeCreditos());  
        unatorre.atacarEnemigo(hormiga1); 
        unatorre.atacarEnemigo(hormiga2);
        unatorre.atacarEnemigo(hormiga3); 
        unatorre.atacarEnemigo(hormiga4); 
        unatorre.atacarEnemigo(hormiga5); 
        unatorre.atacarEnemigo(hormiga6); 
        unatorre.atacarEnemigo(hormiga7); 
        unatorre.atacarEnemigo(hormiga8); 
        unatorre.atacarEnemigo(hormiga9); 
        unatorre.atacarEnemigo(hormiga10); 
        unatorre.atacarEnemigo(hormiga11); 
        assertEquals(93, jugador.obtenerCantidadDeCreditos());
    }
}