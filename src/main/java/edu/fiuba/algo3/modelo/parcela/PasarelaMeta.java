package edu.fiuba.algo3.modelo.parcela;

import edu.fiuba.algo3.modelo.mapa.Coordenadas;

public class PasarelaMeta extends Pasarela {
    public PasarelaMeta(Coordenadas coordenadas){
        super(coordenadas);
    }
    @Override
    public Coordenadas devolverCoordenadasMeta() {
        return this.coordenadas;
    }
}
