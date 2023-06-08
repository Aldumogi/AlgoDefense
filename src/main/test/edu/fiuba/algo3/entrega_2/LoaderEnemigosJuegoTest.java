package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.LoaderEnemigosJuego;
import edu.fiuba.algo3.LoaderMapaJuego;
import edu.fiuba.algo3.Turno;
import edu.fiuba.algo3.exceptions.FormatoEnemigosInvalidoException;
import edu.fiuba.algo3.exceptions.FormatoMapaInvalidoException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LoaderEnemigosJuegoTest {
    @Test
    public void readJSONTest() throws IOException, ParseException, FormatoEnemigosInvalidoException {

        ArrayList<Turno> turnos = LoaderEnemigosJuego.recuperarTurnosYEnemigos();

        assert(turnos.size() > 0);

    }

    @Test
    public void validarFormatoEnemigosValido(){
        String filePath = "src/main/test/edu/fiuba/algo3/resources/enemigosValido.json";

        assertDoesNotThrow(() -> {
            LoaderEnemigosJuego.validarJsonEnemigos(filePath);
        });
    }

    @Test
    public void validarFormatoEnemigosInvalidoJsonTest() {
        String filePath = "src/main/test/edu/fiuba/algo3/resources/enemigosInvalido.json";

        assertThrows(FormatoEnemigosInvalidoException.class, () -> {
            LoaderEnemigosJuego.validarJsonEnemigos(filePath);
        });

    }
}
