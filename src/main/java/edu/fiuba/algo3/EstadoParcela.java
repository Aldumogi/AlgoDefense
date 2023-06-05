package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;

public interface EstadoParcela {
    EstadoParcela construir(Defensa defensa, Tierra tierra) throws NoDisponibleParaConstruirException;
}

