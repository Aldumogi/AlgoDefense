package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.exceptions.FormatoEnemigosInvalidoException;
import edu.fiuba.algo3.modelo.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.modelo.juego.Inicializador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcela.Parcela;
import edu.fiuba.algo3.modelo.parcela.Pasarela;
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
    @Test
    public void devuelvoLaSiguienteCordenadaEnLDesdeLargada() throws IOException, ParseException, FormatoMapaInvalidoException {

        Mapa unMapa = new Mapa();
        Coordenadas coordenadaActual = new Coordenadas(1, 2);
        Coordenadas cordenadaEsperada = new Coordenadas(1, 7);

        Coordenadas ATestear = unMapa.devolverSiguienteCordenadaEnL(coordenadaActual, 5);
        assertTrue(ATestear.equals(cordenadaEsperada));
    }
    @Test
    public void devuelvoLaSiguienteCordenadaEnLCorrectamenteDesdeLargadaHastaMeta() throws IOException, ParseException, FormatoMapaInvalidoException {

        Mapa unMapa = new Mapa();
        //PrimerMovimiento
        Coordenadas coordenadaActual1 = new Coordenadas(1, 2);
        Coordenadas cordenadaEsperada1 = new Coordenadas(1, 7);

        Coordenadas ATestear = unMapa.devolverSiguienteCordenadaEnL(coordenadaActual1, 5);
        assertTrue(ATestear.equals(cordenadaEsperada1));
        //SegundoMovimiento
        Coordenadas coordenadaActual2 = new Coordenadas(1, 7);
        Coordenadas cordenadaEsperada2 = new Coordenadas(1, 12);

        Coordenadas ATestear2 = unMapa.devolverSiguienteCordenadaEnL(coordenadaActual2, 5);
        assertTrue(ATestear2.equals(cordenadaEsperada2));
        //tercerMovimiento
        Coordenadas coordenadaActual3 = new Coordenadas(1, 12);
        Coordenadas cordenadaEsperada3 = new Coordenadas(3, 15);

        Coordenadas ATestear3 = unMapa.devolverSiguienteCordenadaEnL(coordenadaActual3, 5);
        assertTrue(ATestear3.equals(cordenadaEsperada3));
        //cuartoMovimiento-
        Coordenadas coordenadaActual4 = new Coordenadas(3, 15);
        Coordenadas cordenadaEsperada4 = new Coordenadas(8, 15);

        Coordenadas ATestear4 = unMapa.devolverSiguienteCordenadaEnL(coordenadaActual4, 5);
        assertTrue(ATestear4.equals(cordenadaEsperada4));
        //quintoMovimiento - Llega A Meta
        Coordenadas coordenadaActual5 = new Coordenadas(8, 15);
        Coordenadas cordenadaEsperada5 = new Coordenadas(11, 15);

        Coordenadas ATestear5 = unMapa.devolverSiguienteCordenadaEnL(coordenadaActual5, 5);
        assertTrue(ATestear5.equals(cordenadaEsperada5));
    }
    @Test
    public void devuelvoLaSiguienteCordenadaEnDiagonalDesdeLargadaMasCercanaAMeta() throws IOException, ParseException, FormatoMapaInvalidoException {

        Mapa unMapa = new Mapa();
        Coordenadas coordenadaActual = new Coordenadas(1, 2);
        Coordenadas cordenadaEsperada = new Coordenadas(2, 3);

        Coordenadas ATestear = unMapa.devolverSiguienteCordenadaUsandoDiagonalesMasCercanaALaMeta(coordenadaActual);
        assertTrue(ATestear.equals(cordenadaEsperada));
    }   
    @Test
    public void devuelvoLaSiguientesNCordenadaEnDiagonalDesdeLargadaMasCercanaAMeta() throws IOException, ParseException, FormatoMapaInvalidoException {

        Mapa unMapa = new Mapa();
        Coordenadas coordenadaActual = new Coordenadas(1, 2);
        Coordenadas cordenadaEsperada = new Coordenadas(5, 6);

        Coordenadas ATestear = unMapa.devolverSiguientesNCordenadaUsandoDiagonalesMasCercanaALaMeta(coordenadaActual, 4);
        assertTrue(ATestear.equals(cordenadaEsperada));
    }
    @Test
    public void devuelvoLaSiguientesNCordenadaEnDiagonalDesdeLargadaHastaMeta() throws IOException, ParseException, FormatoMapaInvalidoException {
        // Funciona Aunque me pase de movimientos
        Mapa unMapa = new Mapa();
        Coordenadas coordenadaActual = new Coordenadas(1, 2);
        Coordenadas cordenadaEsperada = new Coordenadas(11, 15);

        Coordenadas ATestear = unMapa.devolverSiguientesNCordenadaUsandoDiagonalesMasCercanaALaMeta(coordenadaActual, 13);
        assertTrue(ATestear.equals(cordenadaEsperada));
       
    }
}
