package edu.fiuba.algo3.modelo.parcela;
import edu.fiuba.algo3.exceptions.*;
import edu.fiuba.algo3.modelo.defensa.Defensa;

public class ParcelaOcupada implements EstadoParcela {
    public EstadoParcela construir(Defensa defensa, Tierra tierra) throws NoSePudoConstruirException {
        throw new NoSePudoConstruirException();
    }
 }
