package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.exceptions.FormatoEnemigosInvalidoException;
import edu.fiuba.algo3.exceptions.FormatoMapaInvalidoException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MapaTest {
    /*
     * Caso de USO 16 - Verificar la lectura y posterior conversion a unidades
     * del modelo de dominio del JSON de enemigos
     * */
    @Test
    public void elMapaSeCreaCorrectamente() throws IOException, ParseException, FormatoMapaInvalidoException {
        Mapa mapa = new Mapa();

        for(int i = 1; i <= mapa.obtenerCantidadDeFilas(); i++) {
            for(int j = 1; j <= mapa.obtenerCantidadDeColumnas(); j++) {
                assertThat(mapa.obtenerCelda(new Coordenadas(i, j)), instanceOf(Parcela.class));
            }
        }
    }
    /*
    * Tests adicionales
    * */
    @Test
    public void esPorAcaTestBasico() throws IOException, ParseException, FormatoMapaInvalidoException {

        Mapa unMapa = new Mapa();
        Coordenadas coordenadaActual = new Coordenadas(3, 2);
        List<Coordenadas> listaDeVisitados = new ArrayList<>();
        listaDeVisitados.add(coordenadaActual);
        Coordenadas cordenadaAChequearVerdadera = new Coordenadas(4,2);
        Coordenadas cordenadaAChequearFalse = new Coordenadas(2,2);

        Boolean esPorAca = unMapa.esPorAca(cordenadaAChequearVerdadera, listaDeVisitados);

        assertFalse(unMapa.esPorAca(cordenadaAChequearFalse, listaDeVisitados));

        assertTrue(esPorAca);

    }
    @Test
    public void esPorAcaSaliendoDesdeLargadaTest() throws IOException, ParseException, FormatoMapaInvalidoException {

        Mapa unMapa = new Mapa();
        Coordenadas coordenadaActual = new Coordenadas(1, 2);
        List<Coordenadas> listaDeVisitados = new ArrayList<>();
        listaDeVisitados.add(coordenadaActual);
        Coordenadas cordenadaAChequearVerdadera = new Coordenadas(2,2);
        Coordenadas cordenadaAChequearFalse = new Coordenadas(2,3);

        Boolean esPorAcaVerdadero = unMapa.esPorAca(cordenadaAChequearVerdadera, listaDeVisitados);

        assertFalse(unMapa.esPorAca(cordenadaAChequearFalse, listaDeVisitados));

        assertTrue(esPorAcaVerdadero);
    }
    
    @Test
    public void devuelvoLaSiguientePasarelaMasCercanaALaMetaCorrectamente() throws IOException, ParseException, FormatoMapaInvalidoException {

        Mapa unMapa = new Mapa();
        Coordenadas coordenadaActual = new Coordenadas(4, 2);
        Coordenadas cordenadaEsperada = new Coordenadas(5, 2);

        Coordenadas ATestear = unMapa.devolverSiguientePasarela_(coordenadaActual);
        assertTrue(ATestear.equals(cordenadaEsperada));
    }

    @Test
    public void devuelvoLaSiguientesNPasarelasMasAdelanteCorrectamente() throws IOException, ParseException, FormatoMapaInvalidoException {

        Mapa unMapa = new Mapa();
        Coordenadas coordenadaActual = new Coordenadas(3, 2);
         Coordenadas cordenadaEsperada = new Coordenadas(5, 2);

         Coordenadas ATestear = unMapa.devolverSiguientePasarela(coordenadaActual, 2);
        assertTrue(ATestear.equals(cordenadaEsperada));
    }
    @Test
    public void devuelvoLaCordenadaDePasarelaMetaAunqueMePaseDeMovimientos() throws IOException, ParseException, FormatoMapaInvalidoException {

        Mapa unMapa = new Mapa();
        Coordenadas coordenadaActual = new Coordenadas(11, 13);
        Coordenadas cordenadaEsperada = new Coordenadas(11, 15);

        Coordenadas ATestear = unMapa.devolverSiguientePasarela(coordenadaActual, 3);
        assertTrue(ATestear.equals(cordenadaEsperada));
    }

    
    @Test
    public void devuevloLaCordenadaSiguienteSaliendoDesdeLargada() throws IOException, ParseException, FormatoMapaInvalidoException {

        Mapa unMapa = new Mapa();
        Coordenadas coordenadaActual = new Coordenadas(1, 2);
        Coordenadas cordenadaEsperada = new Coordenadas(2, 2);

        Coordenadas ATestear = unMapa.devolverSiguientePasarela(coordenadaActual, 1);
        assertTrue(ATestear.equals(cordenadaEsperada));
    }

    @Test
    public void devuevloLaCordenadaSiguienteSaliendoDesdeLargada_() throws IOException, ParseException, FormatoMapaInvalidoException {

        Mapa unMapa = new Mapa();
        Coordenadas coordenadaActual = new Coordenadas(6, 2);
        Coordenadas cordenadaEsperada = new Coordenadas(7, 2);

        Coordenadas ATestear = unMapa.devolverSiguientePasarela(coordenadaActual, 1);
        assertTrue(ATestear.equals(cordenadaEsperada));
    }

    @Test
    public void devolverPasarelaAlSumarDeADosEnLaCoordenada52() throws IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException, FormatoEnemigosInvalidoException {
        String fileMapa = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        String fileEnemigos = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
        Inicializador inicio = new Inicializador(fileEnemigos, fileMapa);
        inicio.agregarJugador("NombreDelJugador");
        Juego juego = inicio.obtenerJuego();
        Mapa unMapa = juego.obtenerMapa();Coordenadas coordenadaActual = new Coordenadas(5, 2);

        Coordenadas ATestear = unMapa.devolverSiguientePasarela(coordenadaActual, 2);
        Parcela parcela = unMapa.obtenerCelda(ATestear);
        assertThat(parcela, instanceOf(Pasarela.class));
    }
}
