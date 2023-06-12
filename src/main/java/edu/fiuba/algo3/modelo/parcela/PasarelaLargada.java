package edu.fiuba.algo3.modelo.parcela;

import edu.fiuba.algo3.modelo.mapa.Coordenadas;

public class PasarelaLargada extends Pasarela {
    public PasarelaLargada(Coordenadas coordenadas){
        super(coordenadas);
    }

    @Override
    public Coordenadas devolverCoordenadasLargada() {
        return this.coordenadas;
    }
}
