package edu.fiuba.algo3;
import edu.fiuba.algo3.exceptions.*;

public class ParcelaOcupada implements DisponibilidadParcela{
    public void agregar(Defensa disponibilidad, Parcela parcela) throws NoDisponibleParaConstruirException {}
    public void verSiEstaDisponible() throws NoDisponibleParaConstruirException {
        throw new NoDisponibleParaConstruirException();
    }
}
