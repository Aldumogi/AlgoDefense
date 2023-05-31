package edu.fiuba.algo3;
import edu.fiuba.algo3.exceptions.*;

public class Pasarela implements Parcela {
    protected Coordenadas coordenadas;
    protected DisponibilidadParcela disponibilidad;
    public Pasarela(Coordenadas coordenadas){
        this.disponibilidad = new ParcelaOcupada();
        this.coordenadas = coordenadas;
    }
    public void construir(Defensa defensa) throws NoDisponibleParaConstruirException {
        throw new NoDisponibleParaConstruirException();
    }
    public void ocupar(Defensa defensa) throws NoDisponibleParaConstruirException {}
}
