package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;
import edu.fiuba.algo3.exceptions.NoEsPosibleRecibirEnemigosEnParcelaException;

public class Tierra implements Parcela {
    private Coordenadas coordenadas;
    private EstadoParcela estado;

    public Tierra(Coordenadas coordenadas){
        this.estado = new ParcelaDisponible();
        this.coordenadas = coordenadas;
    }
    public void construir(Defensa defensa) throws NoDisponibleParaConstruirException {
        this.estado = this.estado.construir(defensa, this);
    }

    public void recibirEnemigo(Enemigo enemigo){
        throw new NoEsPosibleRecibirEnemigosEnParcelaException();
    }

    public Coordenadas obtenerCoordenadas(){
        return this.coordenadas;
    }
}
