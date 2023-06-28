package edu.fiuba.algo3.modelo.parcela;

import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import javafx.scene.paint.Color;

public class PasarelaLargada extends Pasarela {
    public final String tipo = "PLargada";
    public PasarelaLargada(Coordenadas coordenadas){
        super(coordenadas);
    }

    public void construir(TrampaArenosa trampaArenosa) throws NoSePudoConstruirException {
        throw new NoSePudoConstruirException();
    }

    public String obtenerTipo() {
        return this.tipo;
    }
}
