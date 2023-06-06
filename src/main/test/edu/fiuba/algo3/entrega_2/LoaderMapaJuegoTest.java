package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.LoaderEnemigosJuego;
import edu.fiuba.algo3.LoaderMapaJuego;
import edu.fiuba.algo3.Parcela;
import edu.fiuba.algo3.Turno;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoaderMapaJuegoTest {
    @Test
    public void readJSONTest() throws IOException, ParseException {

        Map<Integer, HashMap<Integer, Parcela>> mapa = LoaderMapaJuego.recuperarMapa();

        assert(mapa.size() > 0);
    }
}
