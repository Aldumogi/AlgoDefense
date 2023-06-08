package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.Coordenadas;
import edu.fiuba.algo3.Enemigo;
import edu.fiuba.algo3.Hormiga;
import edu.fiuba.algo3.Juego;
import edu.fiuba.algo3.Jugador;
import edu.fiuba.algo3.LoaderEnemigosJuego;
import edu.fiuba.algo3.Mapa;
import edu.fiuba.algo3.Parcela;
import edu.fiuba.algo3.Pasarela;
import edu.fiuba.algo3.Turno;
import edu.fiuba.algo3.exceptions.FormatoEnemigosInvalidoException;
import edu.fiuba.algo3.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.exceptions.NoSePudoBorrarElEnemigoException;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class EnemigoTest {
     /*
    * Tests adicionales
    * */
    @Test
    public void moverHormigaDesdePasarelaDeLargada() throws IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException, NoSePudoBorrarElEnemigoException {

        // Arrange
        Jugador jugador = new Jugador("Alberto");
        Mapa mapa = new Mapa("src/main/test/edu/fiuba/algo3/resources/mapaValido.json");
        ArrayList<Turno> turnos = LoaderEnemigosJuego.recuperarTurnosYEnemigos("src/main/test/edu/fiuba/algo3/resources/unaHormiga.json");

        Juego juego = new Juego(jugador, mapa, turnos);

        Parcela largada = mapa.obtenerCelda(new Coordenadas(1, 2));
        Enemigo enemigo = largada.obtener().get(0);

        // Coordenadas coordenadaInicial = enemigo.obtenerCoordenadas();

        // Act
        enemigo.mover(mapa);
        Coordenadas coordenadaSiguiente = enemigo.obtenerCoordenadas();
        
        
        // Coordenadas coordenadaEsperada = new Coordenadas(2,2);
        // Pasarela pasarelaEsperada = new Pasarela(coordenadaEsperada);
        // assertFalse(unMapa.esPorAca(cordenadaAChequearFalse, listaDeVisitados));
        
        // Assert
        assertTrue(coordenadaSiguiente.equals(new Coordenadas(2, 2)));
    }
    
}