package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.*;
import edu.fiuba.algo3.exceptions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DefensaTest {
    /*
        CASO de USO 4 - Verificar solo se pueda construir defensas sobre tierra (y verificar lo contrario)
     */
    @Test
    public void defensaPuedeConstruirseSobreTierra() {
        // Arrange
        Defensa torreBlanca = new TorreBlanca();
        Coordenadas coordenadas = new Coordenadas(10,33);
        Parcela tierra = new Tierra(coordenadas);

        //Act, Assert
        assertDoesNotThrow(() -> {
            tierra.construir(torreBlanca);
        });
    }


    @Test
    public void defensaNoPuedeConstruirseSobreRoca() {
        // Arrange
        Defensa torreBlanca = new TorreBlanca();
        Coordenadas coordenadas = new Coordenadas(55,62);
        Parcela rocoso = new Rocoso(coordenadas);

        //Act, Assert
        assertThrows(NoDisponibleParaConstruirException.class, () -> {
            rocoso.construir(torreBlanca);
        });

    }

    @Test
    public void defensaNoPuedeConstruirseSobrePasarela() {
        // Arrange
        Defensa torreBlanca = new TorreBlanca();
        Coordenadas coordenadas = new Coordenadas(55,62);
        Parcela pasarela = new Pasarela(coordenadas);
        //Act, Assert
        assertThrows(NoDisponibleParaConstruirException.class, () -> {
            pasarela.construir(torreBlanca);
        });
    }

    @Test
    public void defensaNoPuedeConstruirseSobrePasarelaLargada() {
        // Arrange
        Defensa torreBlanca = new TorreBlanca();
        Coordenadas coordenadas = new Coordenadas(55,62);
        Parcela pasarelaLargada = new PasarelaLargada(coordenadas);
        //Act, Assert
        assertThrows(NoDisponibleParaConstruirException.class, () -> {
            pasarelaLargada.construir(torreBlanca);
        });
    }
    @Test
    public void defensaNoPuedeConstruirseSobrePasarelaMeta() {
        // Arrange
        Defensa torreBlanca = new TorreBlanca();
        Coordenadas coordenadas = new Coordenadas(55,62);
        Parcela pasarelaMeta = new PasarelaMeta(coordenadas);
        //Act, Assert
        assertThrows(NoDisponibleParaConstruirException.class, () -> {
            pasarelaMeta.construir(torreBlanca);
        });
    }

    /*
        CASO de USO 5 - Verificar que las defensas ataquen dentro del rango esperado (y verificar lo contrario)
     */

    @Test
    public void defensaTorreBlancaPuedeAtacarDentroDelRangoEsperado() throws NoDisponibleParaConstruirException {
        //Arrange
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Defensa torreBlanca = new TorreBlanca();
        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(torreBlanca); // daño 1 punto, rango 3
        torreBlanca.terminarDeConstruir();
        Enemigo hormiga = new Hormiga(coordenadasHormiga);

        //Act, Assert
        assertEquals( true, torreBlanca.atacarEnemigo(hormiga) );

    }

    @Test
    public void defensaTorrePlateadaPuedeAtacarDentroDelRangoEsperado() throws NoDisponibleParaConstruirException {
        //Arrange
        Coordenadas coordenadasTorre = new Coordenadas(2,2);
        Coordenadas coordenadasHormiga = new Coordenadas(3,1);
        Defensa torrePlateada = new TorrePlateada();
        Tierra tierra = new Tierra(coordenadasTorre);
        tierra.construir(torrePlateada); // daño 2 punto, rango 5
        torrePlateada.terminarDeConstruir();
        Enemigo hormiga = new Hormiga(coordenadasHormiga);

        //Act, Assert
        assertEquals( true, torrePlateada.atacarEnemigo(hormiga) );

    }



}
