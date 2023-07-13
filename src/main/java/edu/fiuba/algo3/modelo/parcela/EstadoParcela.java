package edu.fiuba.algo3.modelo.parcela;

import edu.fiuba.algo3.modelo.defensa.Torre;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.defensa.Defensa;

public interface EstadoParcela {
    EstadoParcela construir() throws NoSePudoConstruirException;
}

