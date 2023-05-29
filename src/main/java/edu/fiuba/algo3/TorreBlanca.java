package edu.fiuba.algo3;

public class TorreBlanca extends Defensa {

    // private Tierra tierra;
    // private Coodenada coordenada;

    public void TorreBlanca() {
        this.nombre("Torre Blanca");
        this.costo(10);
        this.tiempoDeConstruccion(1);
        this.rangoDeAtaque(3);
        this.danio(1);
    }

    public void atacarEnemigo() {}
    public void construir() {}


}
