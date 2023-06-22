package edu.fiuba.algo3.modelo.parcela;

import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import javafx.scene.paint.Color;

public class PasarelaLargada extends Pasarela {
    public final Color color = Color.YELLOW;
    public PasarelaLargada(Coordenadas coordenadas){
        super(coordenadas);
    }

    public void construir(TrampaArenosa trampaArenosa) throws NoSePudoConstruirException {
        throw new NoSePudoConstruirException();
    }
    @Override
    public Coordenadas devolverCoordenadasLargada() {
        return this.coordenadas;
    }

    public Color obtenerColor() {
        return this.color;
    }
}
