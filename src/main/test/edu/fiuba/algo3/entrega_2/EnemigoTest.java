package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.enemigo.LoaderEnemigosJuego;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcela.Parcela;
import edu.fiuba.algo3.modelo.juego.Turno;
import edu.fiuba.algo3.modelo.exceptions.FormatoEnemigosInvalidoException;
import edu.fiuba.algo3.modelo.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoBorrarElEnemigoException;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class EnemigoTest {
    /*
    Caso de Uso 9 - Verificar que al pasar un turno las unidades se hayan movido segun sus capacidades
   */
    @Test
    public void moverHormigaDesdePasarelaDeLargada() throws IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException, NoSePudoBorrarElEnemigoException {

        // Arrange
        Jugador jugador = new Jugador("Alberto");
        Mapa mapa = new Mapa("src/main/test/edu/fiuba/algo3/resources/mapaValido.json");
        ArrayList<Turno> turnos = LoaderEnemigosJuego.recuperarTurnosYEnemigos("src/main/test/edu/fiuba/algo3/resources/unaHormiga.json", mapa.getCoordenadasLargada());

        Juego juego = new Juego(jugador, mapa, turnos);

        Parcela largada = mapa.obtenerCelda(new Coordenadas(1, 2));
        Enemigo enemigo = largada.obtener().get(0);

        // Act
        enemigo.mover(mapa);
        Coordenadas coordenadaSiguiente = enemigo.obtenerCoordenadas();

        // Assert
        assertTrue(coordenadaSiguiente.equals(new Coordenadas(2, 2)));
    }

    @Test
    public void moverAraniaDesdePasarelaDeLargada() throws IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException, NoSePudoBorrarElEnemigoException {

        // Arrange
        Jugador jugador = new Jugador("Alberto");
        Mapa mapa = new Mapa("src/main/test/edu/fiuba/algo3/resources/mapaValido.json");
        ArrayList<Turno> turnos = LoaderEnemigosJuego.recuperarTurnosYEnemigos("src/main/test/edu/fiuba/algo3/resources/unaArania.json", mapa.getCoordenadasLargada());

        Juego juego = new Juego(jugador, mapa, turnos);

        Parcela largada = mapa.obtenerCelda( mapa.getCoordenadasLargada() );
        Enemigo enemigo = largada.obtener().get(0);

        // Act
        enemigo.mover(mapa);
        Coordenadas coordenadaSiguiente = enemigo.obtenerCoordenadas();
        
        // Assert
        assertTrue(coordenadaSiguiente.equals(new Coordenadas(3, 2)));
    }

    @Test
    public void moverHormigaDesdePasarelaDeLargadaNoDebeEstarEnRocosoOTierraOInicial() throws IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException, NoSePudoBorrarElEnemigoException {

        // Arrange
        Jugador jugador = new Jugador("Alberto");
        Mapa mapa = new Mapa("src/main/test/edu/fiuba/algo3/resources/mapaValido.json");
        ArrayList<Turno> turnos = LoaderEnemigosJuego.recuperarTurnosYEnemigos("src/main/test/edu/fiuba/algo3/resources/unaHormiga.json", mapa.getCoordenadasLargada());

        Juego juego = new Juego(jugador, mapa, turnos);

        Parcela largada = mapa.obtenerCelda(new Coordenadas(1, 2));
        Enemigo enemigo = largada.obtener().get(0);

        // Act
        enemigo.mover(mapa);
        Coordenadas coordenadaSiguiente = enemigo.obtenerCoordenadas();

        // Assert
        assertFalse(coordenadaSiguiente.equals(new Coordenadas(1, 1)));
        assertFalse(coordenadaSiguiente.equals(new Coordenadas(1, 3)));
        assertFalse(coordenadaSiguiente.equals(new Coordenadas(2, 1)));
        assertFalse(coordenadaSiguiente.equals(new Coordenadas(2, 3)));
    }
    
}