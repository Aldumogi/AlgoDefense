package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.juego.Turno;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnoTest {
    /*
     * Caso de USO 15 - Verificar la lectura y posterior conversion a unidades
     * del modelo de dominio del JSON de enemigos
     * */
    @Test
    public void elTurnoSeCreaCorrectamente() {
        Turno turno = new Turno(1);
        turno.agregarEnemigos(2, 1, new Coordenadas(1, 2));

        ArrayList<Enemigo> listaEnemigos = turno.getListaEnemigosAgregadosEnElTurno();

        for(Enemigo e: listaEnemigos) {
            assert(e instanceof Enemigo);
        }
        assertEquals(1, turno.getTurnoId());
        assertEquals(3, turno.getListaEnemigosAgregadosEnElTurno().size());
    }
}
