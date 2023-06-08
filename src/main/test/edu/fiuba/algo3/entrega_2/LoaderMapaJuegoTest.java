package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.LoaderEnemigosJuego;
import edu.fiuba.algo3.LoaderMapaJuego;
import edu.fiuba.algo3.Parcela;
import edu.fiuba.algo3.Turno;
import edu.fiuba.algo3.exceptions.FormatoJsonInvalidoException;
import edu.fiuba.algo3.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class LoaderMapaJuegoTest {
    @Test
    public void readJSONTest() throws IOException, ParseException, FormatoMapaInvalidoException {

        Map<Integer, HashMap<Integer, Parcela>> mapa = LoaderMapaJuego.recuperarMapa(null);

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
