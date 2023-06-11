package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.modelo.juego.Inicializador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Turno;
import edu.fiuba.algo3.modelo.enemigo.Topo;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class EnemigoTest {
    /*
    * TOPO
    * */
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

    @Test
    public void laVelocidadDelTopoEsDosEntreSusMovimientosSeisYDiez() throws IOException, ParseException, FormatoMapaInvalidoException {
        Inicializador ini = new Inicializador();
        ini.agregarJugador("Roberto");
        Juego juego = ini.obtenerJuego();
        Topo topo = new Topo(juego.obtenerMapa().getCoordenadasLargada());
        juego.agregarEnemigo(topo);

        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertEquals(2, topo.obtenerVelocidad() );
        juego.avanzarTurno();
        assertEquals(2, topo.obtenerVelocidad() );
        juego.avanzarTurno();
        assertEquals(2, topo.obtenerVelocidad() );
        juego.avanzarTurno();
        assertEquals(2, topo.obtenerVelocidad() );
        juego.avanzarTurno();
        assertEquals(2, topo.obtenerVelocidad() );
        juego.avanzarTurno();
        assertNotEquals(2, topo.obtenerVelocidad());
    }

    @Test
    public void laVelocidadDelTopoAPartirDelMovimientoOnceQuedaDefinitivamenteEnTres() throws IOException, ParseException, FormatoMapaInvalidoException {
        Inicializador ini = new Inicializador();
        ini.agregarJugador("Roberto");
        Juego juego = ini.obtenerJuego();
        Topo topo = new Topo(juego.obtenerMapa().getCoordenadasLargada());
        juego.agregarEnemigo(topo);

        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertEquals(3, topo.obtenerVelocidad() );
        juego.avanzarTurno();
        assertEquals(3, topo.obtenerVelocidad() );
        juego.avanzarTurno();
        assertEquals(3, topo.obtenerVelocidad() );
        juego.avanzarTurno();
        assertEquals(3, topo.obtenerVelocidad() );
        juego.avanzarTurno();
        assertEquals(3, topo.obtenerVelocidad() );
        juego.avanzarTurno();
        juego.avanzarTurno();
        assertEquals(3, topo.obtenerVelocidad() );
    }

    @Test
    public void elTopoCausaCincoPuntosDeDanioEnTurnosImparesYDosEnTurnosPares() throws IOException, ParseException, FormatoMapaInvalidoException {
        ArrayList<Turno> turnos = new ArrayList<Turno>();
        for ( int i = 0 ; i < 6 ; i++ ) {
            turnos.add( new Turno( i + 1 ) );
        }
        Inicializador ini = new Inicializador(turnos);
        ini.agregarJugador("Roberto");
        Juego juego = ini.obtenerJuego();
        Topo topo = new Topo(juego.obtenerMapa().getCoordenadasLargada());
        juego.agregarEnemigo(topo);


        assert( juego.obtenerNumeroDeturno() % 2 != 0 );
        assertEquals(5, topo.obtenerDanioCausado( juego.obtenerNumeroDeturno() ) );
        juego.avanzarTurno();
        assert( juego.obtenerNumeroDeturno() % 2 == 0 );
        assertEquals(2, topo.obtenerDanioCausado( juego.obtenerNumeroDeturno() ));
        juego.avanzarTurno();
        assert( juego.obtenerNumeroDeturno() % 2 != 0 );
        assertEquals(5, topo.obtenerDanioCausado( juego.obtenerNumeroDeturno() ) );
        juego.avanzarTurno();
        assert( juego.obtenerNumeroDeturno() % 2 == 0 );
        assertEquals(2, topo.obtenerDanioCausado( juego.obtenerNumeroDeturno() ));
    }
}
