package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;

public interface Parcela {
    void construir(Defensa defensa, int numeroDeTurno) throws NoDisponibleParaConstruirException;
    void ocupar(Defensa defensa) throws NoDisponibleParaConstruirException;
}
