package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.modelo.juego.Inicializador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.enemigo.Topo;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EnemigoTest {
    @Test
    public void enSusPrimerosCincoMovimientosElTopoTieneUnoDeVelocidad() throws IOException, ParseException, FormatoMapaInvalidoException {
        Inicializador ini = new Inicializador();
        ini.agregarJugador("Roberto");
        Juego juego = ini.obtenerJuego();
        Topo topo = new Topo(juego.obtenerMapa().getCoordenadasLargada());
        juego.agregarEnemigo(topo);

        assertEquals(1, topo.obtenerVelocidad() );
        juego.avanzarTurno();
        assertEquals(1, topo.obtenerVelocidad() );
        juego.avanzarTurno();
        assertEquals(1, topo.obtenerVelocidad() );
        juego.avanzarTurno();
        assertEquals(1, topo.obtenerVelocidad() );
        juego.avanzarTurno();
        assertEquals(1, topo.obtenerVelocidad() );
        juego.avanzarTurno();
        assertNotEquals(1, topo.obtenerVelocidad());
    }
}
