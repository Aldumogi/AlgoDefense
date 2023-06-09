package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.defensa.Torre;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TorrePlateada;
import edu.fiuba.algo3.modelo.enemigo.Arania;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
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

public class JuegoTest {
    @Test
    public void juegoConDosEnemigosNoDeberiaEstarTerminado() throws IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        // Arrange
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador inicio = new Inicializador(fileEnemigos, fileMapa);


        inicio.agregarJugador("NombreDelJugador");
        Juego juego = inicio.obtenerJuego();
        Mapa mapa = juego.obtenerMapa();

        juego.agregarEnemigo(new Arania(mapa.getCoordenadasLargada()));
        juego.agregarEnemigo(new Hormiga(mapa.getCoordenadasLargada()));

        // Act
        boolean terminado =  juego.juegoTerminado();

        // Assert
        assertFalse(terminado);
    }
    @Test
    public void juegoSinEnemigosDeberiaEstarTerminado() throws IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        // Arrange
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        Inicializador inicio = new Inicializador(fileMapa);

        inicio.agregarJugador("NombreDelJugador");
        Juego juego = inicio.obtenerJuego();

        // Act
        boolean terminado =  juego.juegoTerminado();

        // Assert
        assertTrue(terminado);
    }

    @Test
    public void caso11() throws ElEnemigoEstaMuertoException, ElEnemigoMurioDuranteElAtaqueException, FueraDeRangoException, DefensaEnConstruccionException, NoSePudoConstruirException, IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        Inicializador inicio = new Inicializador(fileMapa);
        ArrayList<Hormiga> hormigasAsesinadas = new ArrayList<>();

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Jugador jugador = juego.obtenerJugador();

        Torre torrePlateada = new TorrePlateada();
        Coordenadas coordDefensa = new Coordenadas(4, 3);
        jugador.generarConstruccion(torrePlateada, coordDefensa, juego.obtenerMapa());

        juego.avanzarTurno();
        juego.avanzarTurno();

        Enemigo enemigo = new Arania(new Coordenadas(5,2));
        Enemigo enemigo1 = new Arania(new Coordenadas(5,2));
        Enemigo enemigo2 = new Arania(new Coordenadas(5,2));
        Enemigo enemigo3 = new Arania(new Coordenadas(5,2));
        Enemigo enemigo4 = new Arania(new Coordenadas(5,2));
        juego.agregarEnemigo(enemigo);

        try {
            torrePlateada.atacarEnemigo(enemigo, hormigasAsesinadas);
            torrePlateada.atacarEnemigo(enemigo1, hormigasAsesinadas);
            torrePlateada.atacarEnemigo(enemigo2, hormigasAsesinadas);
            torrePlateada.atacarEnemigo(enemigo3, hormigasAsesinadas);
            torrePlateada.atacarEnemigo(enemigo4, hormigasAsesinadas);
        }
        catch(ElEnemigoMurioDuranteElAtaqueException e) {}

        Enemigo enemigo5 = new Arania(new Coordenadas(5, 2));
        Enemigo enemigo6 = new Arania(new Coordenadas(5, 2));
        Enemigo enemigo7 = new Arania(new Coordenadas(5, 2));
        Enemigo enemigo8 = new Arania(new Coordenadas(5, 2));
        Enemigo enemigo9 = new Arania(new Coordenadas(5, 2));

        juego.avanzarTurno();

        boolean terminado =  juego.juegoTerminado();

        assertTrue(jugador.estaVivo());
        assertTrue(terminado);
    }

    @Test
    public void caso12() throws IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/test/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/test/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador inicio = new Inicializador(fileEnemigos, fileMapa);

        inicio.agregarJugador("Alberto");
        Juego juego = inicio.obtenerJuego();
        Mapa mapa = juego.obtenerMapa();
        Jugador jugador = juego.obtenerJugador();
        for( int i = 0; i < 7 ; i++ ){
            juego.agregarEnemigo( new Arania( mapa.getCoordenadasLargada() ) );
            juego.agregarEnemigo( new Hormiga( mapa.getCoordenadasLargada() ) );
        }

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
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertFalse(jugador.estaVivo());
    }
}
