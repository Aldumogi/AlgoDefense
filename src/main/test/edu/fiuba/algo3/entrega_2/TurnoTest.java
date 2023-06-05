package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.Turno;
import edu.fiuba.algo3.modelo.Message;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnoTest {
    @Test
    public void elTurnoSeCreaCorrectamente() {
        Turno turno = new Turno(1);
        turno.agregarEnemigos(2, 1);

        assertEquals(1, turno.getTurnoId());
        assertEquals(3, turno.getListaEnemigos().toArray().length);
    }
}
