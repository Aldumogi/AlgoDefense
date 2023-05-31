package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Arania;
import edu.fiuba.algo3.Defensa;
import edu.fiuba.algo3.Hormiga;
import edu.fiuba.algo3.Inicializador;
import edu.fiuba.algo3.Juego;
import edu.fiuba.algo3.Jugador;
import edu.fiuba.algo3.TorreBlanca;
import edu.fiuba.algo3.TorrePlateada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemigoTest {
    @Test
    //Caso de uso 6, verifico que las unidades enemigas son dañadas acorde al
    //daño recibido
    public void unaTorreBlancaAtacaAunaHormigaUnaVezYLaMata() {
        Inicializador inicio = new Inicializador();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Hormiga unaHormiga = new Hormiga();
        Defensa unaDefensa = new TorreBlanca(jugador);
        unaDefensa.atacarEnemigo(unaHormiga);

        assertEquals( unaHormiga.estaVivo(), false );

    }
    @Test
    public void unaTorreBlancaAtacaNoPuedeAtacarAunaHormigaDosVecesPorqueEstaMuerta() {

        Inicializador inicio = new Inicializador();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Hormiga unaHormiga = new Hormiga();
        Defensa unaDefensa = new TorreBlanca(jugador);
        unaDefensa.atacarEnemigo(unaHormiga);
        boolean pudeAtacar = unaDefensa.atacarEnemigo(unaHormiga);

        assertEquals( pudeAtacar, false );

    }
    @Test
    public void unaTorreBlancaAtacaAunaAraniaYNoLaMata() {
        Inicializador inicio = new Inicializador();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Arania unaHormiga = new Arania();
        Defensa unaDefensa = new TorreBlanca(jugador);
        unaDefensa.atacarEnemigo(unaHormiga);

        assertEquals( unaHormiga.estaVivo(), true );

    }
    @Test
    public void unaTorreBlancaAtacaAunaAraniaDosVecesYLaMata() {      
        Inicializador inicio = new Inicializador();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();


        Arania unaArania = new Arania();
        Defensa unaDefensa = new TorreBlanca(jugador);
        unaDefensa.atacarEnemigo(unaArania);
        unaDefensa.atacarEnemigo(unaArania);

        assertEquals( unaArania.estaVivo(), false );

    }
    @Test
    public void unaTorrePlateadaAtacaAunaHormigaUnaVezYLaMata() {
        Inicializador inicio = new Inicializador();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Hormiga unaHormiga = new Hormiga();
        Defensa unaDefensa = new TorrePlateada(jugador);
        unaDefensa.atacarEnemigo(unaHormiga);

        assertEquals( unaHormiga.estaVivo(), false );

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
        assertEquals( pudeAtacar, false );

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
        unatorre.atacarEnemigo(unaHormiga);  //despues d atacar, la ho
        assertEquals(81, jugador.obtenerCantidadDeCreditos());

    }

}