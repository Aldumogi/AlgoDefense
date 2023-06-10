package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.enemigo.LoaderEnemigosJuego;
import edu.fiuba.algo3.modelo.juego.Turno;
import edu.fiuba.algo3.exceptions.FormatoEnemigosInvalidoException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LoaderEnemigosJuegoTest {
    /*
    * Caso de USO 15 - Verificar la lectura y posterior conversion a unidades
    * del modelo de dominio del JSON de enemigos
    * */
    @Test
    public void readJSONTest() throws IOException, ParseException, FormatoEnemigosInvalidoException {

        ArrayList<Turno> turnos = LoaderEnemigosJuego.recuperarTurnosYEnemigos("src/main/test/edu/fiuba/algo3/resources/enemigosValido.json", null);

        assert(turnos.size() > 0);

    }
    /*
     * Caso de USO 13 - Verificar el formato valido del JSON de enemigos
     * */
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
