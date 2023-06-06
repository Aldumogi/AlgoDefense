package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.Coordenadas;
import edu.fiuba.algo3.Mapa;
import edu.fiuba.algo3.Parcela;
import edu.fiuba.algo3.exceptions.FormatoMapaInvalidoException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class MapaTest {

    @Test
    public void elMapaSeCreaCorrectamente() throws IOException, ParseException, FormatoMapaInvalidoException {
        Mapa mapa = new Mapa();

        for(int i = 1; i <= mapa.obtenerCantidadDeFilas(); i++) {
            for(int j = 1; j <= mapa.obtenerCantidadDeColumnas(); j++) {
                assertThat(mapa.obtenerCelda(new Coordenadas(i, j)), instanceOf(Parcela.class));
            }
        }
    }
}
