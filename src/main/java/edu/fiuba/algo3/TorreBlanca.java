package edu.fiuba.algo3;

public class TorreBlanca extends Defensa {
    private String nombre;
    private int costo;
    private int tiempoDeConstruccion;
    private int rangoDeAtaque;
    private int danio;
    // private Tierra tierra;
    // private Coodenada coordenada;

    public void TorreBlanca() {
        this.nombre = "Torre Blanca";
        this.costo = 10;
        this.tiempoDeConstruccion = 1;
        this.rangoDeAtaque = 3;
        this.danio = 1;
    }

    public void atacarEnemigo() {}

    public void construirTorre() {}
}
