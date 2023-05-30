package edu.fiuba.algo3;

public class Rocoso implements Parcela {
    private Coordenadas coordenadas;
    private DisponibilidadParcela disponibilidad;
    public Rocoso(Coordenadas coordenadas){
        this.disponibilidad = new ParcelaOcupada();
        this.coordenadas = coordenadas;
    }
    public Boolean construir(Defensa defensa) {
        return false;
    }
    public Boolean ocupar(Defensa defensa){
        return false;
    }
}
