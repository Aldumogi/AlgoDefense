package edu.fiuba.algo3;

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
    public void construir() {

    }


}
