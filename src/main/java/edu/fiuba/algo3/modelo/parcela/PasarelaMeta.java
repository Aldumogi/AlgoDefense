package edu.fiuba.algo3.modelo.parcela;

import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import javafx.scene.paint.Color;

public class PasarelaMeta extends Pasarela {
    public final Color color = Color.YELLOW;

    public PasarelaMeta(Coordenadas coordenadas){
        super(coordenadas);
    }
    @Override
    public Coordenadas devolverCoordenadasMeta() {
        return this.coordenadas;
    }

    public Color obtenerColor() {
        return this.color;
    }

}
