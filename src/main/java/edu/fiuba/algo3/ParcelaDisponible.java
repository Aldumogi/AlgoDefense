package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;

public class ParcelaDisponible implements EstadoParcela {

    public EstadoParcela construir(Defensa defensa, Tierra tierra) throws NoDisponibleParaConstruirException {
        defensa.construir(tierra);
        return new ParcelaOcupada();
    }
}
