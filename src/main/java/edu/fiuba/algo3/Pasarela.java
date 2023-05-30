package edu.fiuba.algo3;

public class Pasarela implements Parcela {
    protected Coordenadas coordenadas;
    protected DisponibilidadParcela disponibilidad;
    public Pasarela(Coordenadas coordenadas){
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
