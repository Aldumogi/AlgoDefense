package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Arania;
import edu.fiuba.algo3.Coordenadas;
import edu.fiuba.algo3.Hormiga;
import edu.fiuba.algo3.Mapa;
import edu.fiuba.algo3.Pasarela;
import edu.fiuba.algo3.Rocoso;
import edu.fiuba.algo3.Tierra;
import edu.fiuba.algo3.TorreBlanca;
import edu.fiuba.algo3.TorrePlateada;
import edu.fiuba.algo3.exceptions.NoEsPosibleRecibirEnemigosEnParcelaException;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MapaTest {
    @Test
    public void esPorAcaTestBasico() throws IOException, ParseException {    

        Mapa unMapa = new Mapa();
        Coordenadas coordenadaActual = new Coordenadas(3, 1);
        List<Coordenadas> listaDeVisitados = new ArrayList<>();
        listaDeVisitados.add(coordenadaActual);
        Coordenadas cordenadaAChequearVerdadera = new Coordenadas(4,1);
        Coordenadas cordenadaAChequearFalse = new Coordenadas(2,1);

        Boolean esPorAca = unMapa.esPorAca(cordenadaAChequearVerdadera, listaDeVisitados);

        assertFalse(unMapa.esPorAca(cordenadaAChequearFalse, listaDeVisitados));

        assertTrue(esPorAca);

    }
    @Test
    public void esPorAcaSaliendoDesdeLargadaTest() throws IOException, ParseException {    

        Mapa unMapa = new Mapa();
        Coordenadas coordenadaActual = new Coordenadas(0, 1);
        List<Coordenadas> listaDeVisitados = new ArrayList<>();
        listaDeVisitados.add(coordenadaActual);
        Coordenadas cordenadaAChequearVerdadera = new Coordenadas(1,1);
        Coordenadas cordenadaAChequearFalse = new Coordenadas(1,2);

        Boolean esPorAca = unMapa.esPorAca(cordenadaAChequearVerdadera, listaDeVisitados);

        assertFalse(unMapa.esPorAca(cordenadaAChequearFalse, listaDeVisitados));

        assertTrue(esPorAca);
    }
    
    @Test
    public void devuelvoLaSiguientePasarelaMasCercanaALaMetaCorrectamente() {    

        Mapa unMapa = new Mapa();
        Coordenadas coordenadaActual = new Coordenadas(3, 1);
        Coordenadas cordenadaEsperada = new Coordenadas(4, 1);

        Coordenadas ATestear = unMapa.devolverSiguientePasarela(coordenadaActual);
        assertTrue(ATestear.equals(cordenadaEsperada));
    }
}
