package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.Terminada;
import edu.fiuba.algo3.modelo.defensa.TorreBlanca;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.juego.Inicializador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Turno;
import edu.fiuba.algo3.modelo.enemigo.Topo;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
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

    @Test
    public void torreBlancaNoPuedeAtacarAlTopo() throws IOException, ParseException, FormatoMapaInvalidoException, NoSePudoConstruirException {
        Inicializador ini = new Inicializador();
        ini.agregarJugador("Roberto");
        Juego juego = ini.obtenerJuego();
        Topo topo = new Topo(juego.obtenerMapa().getCoordenadasLargada());
        juego.agregarEnemigo(topo);
        Jugador jugador = juego.obtenerJugador();
        TorreBlanca torreBlanca = new TorreBlanca();

        jugador.generarConstruccion( torreBlanca, new Coordenadas(2,1), juego.obtenerMapa() );
        juego.avanzarTurno();

        assertThat( torreBlanca.estadoDefensa() , instanceOf( Terminada.class ) );
        assertEquals(100, topo.obtenerEnergia() );
        juego.avanzarTurno();
        assertEquals(100, topo.obtenerEnergia() );
        juego.avanzarTurno();
        assertEquals(100, topo.obtenerEnergia() );
    }

    @Test
    public void torrePlateadaNoPuedeAtacarAlTopo() throws IOException, ParseException, FormatoMapaInvalidoException, NoSePudoConstruirException {
        Inicializador ini = new Inicializador();
        ini.agregarJugador("Roberto");
        Juego juego = ini.obtenerJuego();
        Topo topo = new Topo(juego.obtenerMapa().getCoordenadasLargada());
        juego.agregarEnemigo(topo);
        Jugador jugador = juego.obtenerJugador();
        TorrePlateada torrePlateada = new TorrePlateada();

        jugador.generarConstruccion( torrePlateada, new Coordenadas(2,1), juego.obtenerMapa() );
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertThat( torrePlateada.estadoDefensa() , instanceOf( Terminada.class ) );
        assertEquals(100, topo.obtenerEnergia() );
        juego.avanzarTurno();
        assertEquals(100, topo.obtenerEnergia() );
        juego.avanzarTurno();
        assertEquals(100, topo.obtenerEnergia() );
    }
}
