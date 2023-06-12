package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.mapa.LoaderMapaJuego;
import edu.fiuba.algo3.modelo.parcela.Parcela;
import edu.fiuba.algo3.modelo.exceptions.FormatoMapaInvalidoException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LoaderMapaJuegoTest {
    @Test
    public void readJSONTest() throws IOException, ParseException, FormatoMapaInvalidoException {

        Map<Integer, HashMap<Integer, Parcela>> mapa = LoaderMapaJuego.recuperarMapa("src/main/java/edu/fiuba/algo3/resources/mapa.json");

        assert(mapa.size() > 0);
    }

    @Test
    public void validarFormatoMapaValidoJsonTest() {

        String filePath = "src/main/test/edu/fiuba/algo3/resources/mapaValido.json";

        assertDoesNotThrow(() -> {
            LoaderMapaJuego.validarMapa(filePath);
        });
    }

   @Test
    public void validarFormatoMapaInvalidoJsonTest() {
        String filePath = "src/main/test/edu/fiuba/algo3/resources/mapaInvalido.json";

        assertThrows(FormatoMapaInvalidoException.class, () -> {
            LoaderMapaJuego.validarMapa(filePath);
        });

   }
}
