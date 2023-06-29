package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.defensa.*;
import edu.fiuba.algo3.modelo.enemigo.*;
import edu.fiuba.algo3.modelo.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.juego.*;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcela.Parcela;
import edu.fiuba.algo3.modelo.parcela.PasarelaNormal;
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
        String filepath = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        Inicializador ini = new Inicializador(filepath);
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
        String filepath = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        Inicializador ini = new Inicializador(filepath);
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
        String filepath = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        Inicializador ini = new Inicializador(filepath);
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
        String filepath = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        Inicializador ini = new Inicializador(filepath);
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
        String filepath = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        Inicializador ini = new Inicializador(filepath);
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

    @Test
    public void elTopoEsRalentizadoSiHayUnaTrampaArenosa() throws IOException, ParseException, FormatoMapaInvalidoException, NoSePudoConstruirException {
        String filepath = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        Inicializador ini = new Inicializador(filepath);
        ini.agregarJugador("Roberto");
        Juego juego = ini.obtenerJuego();
        Topo topo = new Topo(juego.obtenerMapa().getCoordenadasLargada());
        juego.agregarEnemigo(topo);
        Jugador jugador = juego.obtenerJugador();
        TrampaArenosa trampa = new TrampaArenosa();

        jugador.generarConstruccion(trampa, new Coordenadas(2,2), juego.obtenerMapa());
        juego.avanzarTurno();

        assertThat( trampa.estadoDefensa(), instanceOf(Terminada.class) );
        assertEquals(1, topo.obtenerVelocidadReal() );
        assertEquals( new Coordenadas(2,2), topo.obtenerCoordenadas());
        juego.avanzarTurno();

        assertEquals( new Coordenadas(2,2), topo.obtenerCoordenadas());
        juego.avanzarTurno();

        assertEquals( new Coordenadas(2,2), topo.obtenerCoordenadas());
        juego.avanzarTurno();

        assertEquals( new Coordenadas(2,2), topo.obtenerCoordenadas());
        juego.avanzarTurno();

        assertEquals( new Coordenadas(3,2), topo.obtenerCoordenadas());

    }

    @Test
    public void laHormigaEsRalentizadaSiHayUnaTrampaArenosa() throws IOException, ParseException, FormatoMapaInvalidoException, NoSePudoConstruirException {
        String filepath = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        Inicializador ini = new Inicializador(filepath);
        ini.agregarJugador("Roberto");
        Juego juego = ini.obtenerJuego();
        Hormiga hormiga = new Hormiga(juego.obtenerMapa().getCoordenadasLargada());
        juego.agregarEnemigo(hormiga);
        Jugador jugador = juego.obtenerJugador();
        TrampaArenosa trampa = new TrampaArenosa();

        jugador.generarConstruccion(trampa, new Coordenadas(2,2), juego.obtenerMapa());
        juego.avanzarTurno();

        assertThat( trampa.estadoDefensa(), instanceOf(Terminada.class) );
        assertEquals(1, hormiga.obtenerVelocidadReal() );
        assertEquals( new Coordenadas(2,2), hormiga.obtenerCoordenadas());
        juego.avanzarTurno();

        assertEquals( new Coordenadas(2,2), hormiga.obtenerCoordenadas());
        juego.avanzarTurno();

        assertEquals( new Coordenadas(2,2), hormiga.obtenerCoordenadas());
        juego.avanzarTurno();

        assertEquals( new Coordenadas(2,2), hormiga.obtenerCoordenadas());
        juego.avanzarTurno();

        assertEquals( new Coordenadas(3,2), hormiga.obtenerCoordenadas());

    }

    @Test
    public void laArañaEsRalentizadaSiHayUnaTrampaArenosa() throws IOException, ParseException, FormatoMapaInvalidoException, NoSePudoConstruirException {
        String filepath = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        Inicializador ini = new Inicializador(filepath);
        ini.agregarJugador("Roberto");
        Juego juego = ini.obtenerJuego();
        Arania arania = new Arania(juego.obtenerMapa().getCoordenadasLargada());
        juego.agregarEnemigo(arania);
        Jugador jugador = juego.obtenerJugador();
        TrampaArenosa trampa = new TrampaArenosa();

        jugador.generarConstruccion(trampa, new Coordenadas(3,2), juego.obtenerMapa());
        juego.avanzarTurno();

        assertThat( trampa.estadoDefensa(), instanceOf(Terminada.class) );
        assertEquals(2, arania.obtenerVelocidadReal() );
        assertEquals( new Coordenadas(3,2), arania.obtenerCoordenadas());
        juego.avanzarTurno();

        assertEquals( new Coordenadas(4,2), arania.obtenerCoordenadas());
        juego.avanzarTurno();

        assertEquals( new Coordenadas(6,2), arania.obtenerCoordenadas());
        juego.avanzarTurno();

        assertEquals(2, arania.obtenerVelocidadReal() );
        assertEquals( new Coordenadas(7,3), arania.obtenerCoordenadas());
        juego.avanzarTurno();

        assertEquals(2, arania.obtenerVelocidadReal() );
        assertEquals( new Coordenadas(7,5), arania.obtenerCoordenadas());

    }

    @Test
    public void laLechuzaNoEsRalentizadaPorLaTrampaArenosa() throws IOException, ParseException, FormatoMapaInvalidoException, NoSePudoConstruirException {
        String filepath = "src/main/test/edu/fiuba/algo3/resources/mapaValido.json";
        Inicializador ini = new Inicializador(filepath);
        ini.agregarJugador("Roberto");
        Juego juego = ini.obtenerJuego();
        Lechuza lechuza = new Lechuza( new Coordenadas(1,2) );
        juego.agregarEnemigo(lechuza);
        Jugador jugador = juego.obtenerJugador();
        TrampaArenosa trampa = new TrampaArenosa();
        jugador.generarConstruccion(trampa, new Coordenadas(1,7), juego.obtenerMapa());

        juego.avanzarTurno();
        assertThat( juego.obtenerMapa().obtenerCelda(new Coordenadas(1,7)), instanceOf(PasarelaNormal.class) );
        assertEquals( new Coordenadas(1,7), lechuza.obtenerCoordenadas() );

        juego.avanzarTurno();
        assertEquals( new Coordenadas(1,12), lechuza.obtenerCoordenadas());
    }
    /*
    * LECHUZA
    * */
    @Test
    public void CuandoTieneTodaLaVidaSeMueveEnL() throws IOException, ParseException, FormatoMapaInvalidoException {
        String filepath = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        Inicializador ini = new Inicializador(filepath);
        ini.agregarJugador("Roberto");
        Juego juego = ini.obtenerJuego();
        Lechuza lechuza = new Lechuza(juego.obtenerMapa().getCoordenadasLargada());
        juego.agregarEnemigo(lechuza);
        // un movimiento
        juego.avanzarTurno();
        Coordenadas cordenadaEsperada = new Coordenadas(1, 7);
        assertEquals(lechuza.obtenerCoordenadas(), cordenadaEsperada);
        // dos movimientos
        juego.avanzarTurno();
        Coordenadas cordenadaEsperada1 = new Coordenadas(1, 12);
        assertEquals(lechuza.obtenerCoordenadas(), cordenadaEsperada1);
        // tres movimientos
        juego.avanzarTurno();
        Coordenadas cordenadaEsperada3 = new Coordenadas(3, 15);
        assertEquals(lechuza.obtenerCoordenadas(), cordenadaEsperada3);
    }
    
    @Test
    public void CuandoMenosDeLaMitadDeLaVidaSeMuevePorDiagonales() throws IOException, ParseException, FormatoMapaInvalidoException, NoSePudoConstruirException {
        String rutaMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        Inicializador ini = new Inicializador(rutaMapa);
        ini.agregarJugador("Roberto");
        Juego juego = ini.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();
        Mapa mapa = juego.obtenerMapa();
        //Construyo La torre Que Ataca la Lechuza
        jugador.generarConstruccion(new TorrePlateada(), new Coordenadas(1, 3), mapa);
        juego.avanzarTurno();        
        juego.avanzarTurno();
        
        Lechuza lechuza = new Lechuza(juego.obtenerMapa().getCoordenadasLargada());
        juego.agregarEnemigo(lechuza);
        // un movimiento
        juego.avanzarTurno();
        Coordenadas cordenadaEsperada1 = new Coordenadas(1, 7);
        assertEquals(lechuza.obtenerCoordenadas(), cordenadaEsperada1);
        // dos movimientos - Aca se deberiaMoverEnDiagonal
        juego.avanzarTurno();
        Coordenadas cordenadaEsperada2 = new Coordenadas(6, 12);
        assertEquals(lechuza.obtenerCoordenadas(), cordenadaEsperada2);
        // dos movimientos - Aca se deberiaMoverEnDiagonal
        juego.avanzarTurno();
        Coordenadas cordenadaEsperada3 = new Coordenadas(11, 15);
        assertEquals(lechuza.obtenerCoordenadas(), cordenadaEsperada3);

    }
}
