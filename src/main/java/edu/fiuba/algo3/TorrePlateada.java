package edu.fiuba.algo3;

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

    public void construir() {}
}
