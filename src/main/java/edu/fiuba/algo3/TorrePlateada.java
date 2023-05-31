package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;

public class TorrePlateada extends Defensa {

    // private Tierra tierra;
    // private Coodenada coordenada;

    public TorrePlateada() {
        this.nombre("Torre Plateada");
        this.costo(20);
        this.tiempoDeConstruccion(2);
        this.rangoDeAtaque(5);
        this.danio(2);
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
