package edu.fiuba.algo3.modelo.parcela;

import edu.fiuba.algo3.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.defensa.Defensa;

public class ParcelaDisponible implements EstadoParcela {

    public EstadoParcela construir(Defensa defensa, Tierra tierra) throws NoSePudoConstruirException {
        defensa.construir(tierra);
        return new ParcelaOcupada();
    }
}
