package edu.fiuba.algo3;

public class Tierra implements Parcela {
    private Coordenadas coordenadas;
    private DisponibilidadParcela disponibilidad;
    private Defensa contiene;

    public Tierra(Coordenadas coordenadas){
        this.disponibilidad = new ParcelaDisponible();
        this.coordenadas = coordenadas;
    }
    public Boolean construir(Defensa defensa) {
        return disponibilidad.agregar( defensa, this);
    }

    public Boolean ocupar(Defensa defensa){
        this.contiene = defensa;
        this.disponibilidad = new ParcelaOcupada();
        return true;
    }

}
