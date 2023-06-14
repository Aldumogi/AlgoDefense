package edu.fiuba.algo3.modelo.parcela;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;

public class PasarelaNormal extends Pasarela {

    public PasarelaNormal(Coordenadas coordenadas) {
        super(coordenadas);
    }

    public void construir(TrampaArenosa trampaArenosa) throws NoSePudoConstruirException {
        this.trampaArenosa = trampaArenosa;
        this.estado = new ParcelaOcupada();
    }

    @Override
    public void borrarObjeto(Defensa defensa) {
        this.trampaArenosa = null;
        this.estado = new ParcelaDisponible();
    }

}
