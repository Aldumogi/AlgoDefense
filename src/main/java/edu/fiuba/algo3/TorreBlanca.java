package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;

public class TorreBlanca extends Defensa {

    // private Tierra tierra;
    // private Coodenada coordenada;

    public TorreBlanca() {
        this.nombre("Torre Blanca");
        this.costo(10);
        this.tiempoDeConstruccion(1);
        this.rangoDeAtaque(3);
        this.danio(1);
    }

    public Boolean atacarEnemigo(Enemigo enemigo) {
        return true;
    }
    public boolean construir(Coordenadas coordenadas) {
        Parcela tierra = new Tierra(coordenadas);
        try {
            tierra.construir(this);
        }
        catch(NoDisponibleParaConstruirException e) {
            return false;
        }
        this.estado = new EnConstruccion();
        return true;
    }


}
