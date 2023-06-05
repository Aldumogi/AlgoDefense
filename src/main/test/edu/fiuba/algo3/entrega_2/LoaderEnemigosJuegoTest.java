package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.LoaderEnemigosJuego;
import edu.fiuba.algo3.Turno;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoaderEnemigosJuegoTest {
    @Test
    public void readJSONTest() throws IOException, ParseException {

        ArrayList<Turno> turnos = LoaderEnemigosJuego.recuperarTurnosYEnemigos();

        assert(turnos.size() > 0);

    }
}
