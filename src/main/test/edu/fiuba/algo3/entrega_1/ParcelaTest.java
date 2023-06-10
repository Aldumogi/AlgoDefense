package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import edu.fiuba.algo3.modelo.parcela.Pasarela;
import edu.fiuba.algo3.modelo.parcela.Rocoso;
import edu.fiuba.algo3.modelo.parcela.Tierra;
import edu.fiuba.algo3.exceptions.NoEsPosibleRecibirEnemigosEnParcelaException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParcelaTest {
    @Test
    public void unaPasarelaPuedeRecibirUnEnemigo() {

        Coordenadas coordenadaPasarela = new Coordenadas(1, 1);
        Hormiga hormiga = new Hormiga( coordenadaPasarela );
        Pasarela pasarela = new Pasarela(coordenadaPasarela);


        assertDoesNotThrow(() -> pasarela.recibir(hormiga));
    }

    @Test
    public void parcelaRocosoNoPuedeRecibirUnEnemigo() {

        Coordenadas coordenadaRocoso = new Coordenadas(1, 1);
        Hormiga hormiga = new Hormiga( coordenadaRocoso );
        Rocoso rocoso = new Rocoso(coordenadaRocoso);


        assertThrows(NoEsPosibleRecibirEnemigosEnParcelaException.class, 
        () -> rocoso.recibir(hormiga));
    }

    @Test
    public void parcelaTierraNoPuedeRecibirUnEnemigo() {

        Coordenadas coordenadaRocoso = new Coordenadas(1, 1);
        Hormiga hormiga = new Hormiga( coordenadaRocoso );
        Tierra tierra = new Tierra(coordenadaRocoso);


        assertThrows(NoEsPosibleRecibirEnemigosEnParcelaException.class, 
        () -> tierra.recibir(hormiga));
    }
}