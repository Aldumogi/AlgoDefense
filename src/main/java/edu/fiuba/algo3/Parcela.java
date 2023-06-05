package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;
import edu.fiuba.algo3.exceptions.NoEsPosibleRecibirEnemigosEnParcelaException;

public interface Parcela {
    void construir(Defensa defensa) throws NoDisponibleParaConstruirException;
    void recibirEnemigo(Enemigo enemigo) throws NoEsPosibleRecibirEnemigosEnParcelaException;
}
