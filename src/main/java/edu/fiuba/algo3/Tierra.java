package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;

public class Tierra implements Parcela {
    private Coordenadas coordenadas;
    private DisponibilidadParcela disponibilidad;

    public Tierra(Coordenadas coordenadas){
        this.disponibilidad = new ParcelaDisponible();
        this.coordenadas = coordenadas;
    }
    public void construir(Defensa defensa) throws NoDisponibleParaConstruirException {
        disponibilidad.agregar( defensa, this);
    }

    public void ocupar(Defensa defensa){
        this.disponibilidad = new ParcelaOcupada();
    }

}
