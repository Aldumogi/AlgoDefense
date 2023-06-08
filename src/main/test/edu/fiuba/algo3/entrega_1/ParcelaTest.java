package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.Arania;
import edu.fiuba.algo3.Coordenadas;
import edu.fiuba.algo3.Hormiga;
import edu.fiuba.algo3.Pasarela;
import edu.fiuba.algo3.Rocoso;
import edu.fiuba.algo3.Tierra;
import edu.fiuba.algo3.TorreBlanca;
import edu.fiuba.algo3.TorrePlateada;
import edu.fiuba.algo3.exceptions.NoEsPosibleRecibirEnemigosEnParcelaException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParcelaTest {
    @Test
    public void unaPasarelaPuedeRecibirUnEnemigo() {

        Hormiga hormiga = new Hormiga();
        Coordenadas coordenadaPasarela = new Coordenadas(1, 1);
        Pasarela pasarela = new Pasarela(coordenadaPasarela);


        assertDoesNotThrow(() -> pasarela.recibir(hormiga));
    }

    @Test
    public void parcelaRocosoNoPuedeRecibirUnEnemigo() {

        Hormiga hormiga = new Hormiga();
        Coordenadas coordenadaRocoso = new Coordenadas(1, 1);
        Rocoso rocoso = new Rocoso(coordenadaRocoso);


        assertThrows(NoEsPosibleRecibirEnemigosEnParcelaException.class, 
        () -> rocoso.recibir(hormiga));
    }

    @Test
    public void parcelaTierraNoPuedeRecibirUnEnemigo() {

        Hormiga hormiga = new Hormiga();
        Coordenadas coordenadaRocoso = new Coordenadas(1, 1);
        Tierra tierra = new Tierra(coordenadaRocoso);


        assertThrows(NoEsPosibleRecibirEnemigosEnParcelaException.class, 
        () -> tierra.recibir(hormiga));
    }
}