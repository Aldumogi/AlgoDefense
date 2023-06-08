package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;

public interface DisponibilidadParcela {
    void agregar(Defensa defensa, Parcela parcela) throws NoDisponibleParaConstruirException;
    void verSiEstaDisponible() throws NoDisponibleParaConstruirException;
}

