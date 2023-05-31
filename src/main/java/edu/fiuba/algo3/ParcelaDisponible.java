package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;

public class ParcelaDisponible implements DisponibilidadParcela{

    public void agregar(Defensa defensa, Parcela parcela) throws NoDisponibleParaConstruirException {
        parcela.ocupar(defensa);
    }
}
