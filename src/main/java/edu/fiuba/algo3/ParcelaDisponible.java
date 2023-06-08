package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.NoSePudoConstruirException;

public class ParcelaDisponible implements EstadoParcela {

    public EstadoParcela construir(Defensa defensa, Tierra tierra) throws NoSePudoConstruirException {
        defensa.construir(tierra);
        return new ParcelaOcupada();
    }
}
