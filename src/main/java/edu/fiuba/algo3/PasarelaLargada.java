package edu.fiuba.algo3;

public class PasarelaLargada extends Pasarela {
    public PasarelaLargada(Coordenadas coordenadas){
        super(coordenadas);
    }
    @Override
    public Coordenadas devolverCoordenadasLargada() {
        return this.coordenadas;
    }
}
