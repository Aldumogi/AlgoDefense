package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.LoaderEnemigosJuego;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LoaderEnemigosJuegoTest {
    @Test
    public void readJSONTest() throws IOException, ParseException {

        LoaderEnemigosJuego.recuperarTurnosYEnemigos();

    }
}
