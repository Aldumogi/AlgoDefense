package edu.fiuba.algo3;
import edu.fiuba.algo3.exceptions.*;

public class ParcelaOcupada implements EstadoParcela {
    public EstadoParcela construir(Defensa defensa, Tierra tierra) throws NoSePudoConstruirException {
        throw new NoSePudoConstruirException();
    }
 }
