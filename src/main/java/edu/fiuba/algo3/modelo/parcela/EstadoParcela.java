package edu.fiuba.algo3.modelo.parcela;

import edu.fiuba.algo3.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.defensa.Defensa;

public interface EstadoParcela {
    EstadoParcela construir(Defensa defensa, Tierra tierra) throws NoSePudoConstruirException;
}

