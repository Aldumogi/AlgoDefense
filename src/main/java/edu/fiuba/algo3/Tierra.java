package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;
import edu.fiuba.algo3.exceptions.NoEsPosibleRecibirEnemigosEnParcelaException;

public class Tierra implements Parcela {
    private Coordenadas coordenadas;
    private DisponibilidadParcela disponibilidad;

    public Tierra(Coordenadas coordenadas){
        this.disponibilidad = new ParcelaDisponible();
        this.coordenadas = coordenadas;
    }
    public void construir(Defensa defensa, int numeroDeTurno) throws NoDisponibleParaConstruirException {
        try{
            this.disponibilidad.verSiEstaDisponible();
        }
        catch(NoDisponibleParaConstruirException e) {
            throw new NoDisponibleParaConstruirException();
        }
        defensa.construir(this, numeroDeTurno);
    }

    public void ocupar(Defensa defensa){
        defensa.construir(this, 0);
        this.disponibilidad = new ParcelaOcupada();
    }

    public void recibirEnemigo(Enemigo enemigo){
        throw new NoEsPosibleRecibirEnemigosEnParcelaException();
    }

    public Coordenadas obtenerCoordenadas(){
        return this.coordenadas;
    }
}
