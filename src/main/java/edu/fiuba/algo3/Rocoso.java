package edu.fiuba.algo3;
import edu.fiuba.algo3.exceptions.*;

public class Rocoso implements Parcela {
    private Coordenadas coordenadas;
    private EstadoParcela disponibilidad;
    public Rocoso(Coordenadas coordenadas){
        this.disponibilidad = new ParcelaOcupada();
        this.coordenadas = coordenadas;
    }
    public void construir(Defensa defensa) throws NoDisponibleParaConstruirException {
        throw new NoDisponibleParaConstruirException();
    }

    public void recibirEnemigo(Enemigo enemigo){
        throw new NoEsPosibleRecibirEnemigosEnParcelaException();
    }
}
