package edu.fiuba.algo3;

public class TorrePlateada {
    private String nombre;
    private int costo;
    private int tiempoDeConstruccion;
    private int rangoDeAtaque;
    private int danio;
    // private Tierra tierra;
    // private Coodenada coordenada;

    public void TorreBlanca() {
        this.nombre = "Torre Plateada";
        this.costo = 20;
        this.tiempoDeConstruccion = 2;
        this.rangoDeAtaque = 5;
        this.danio = 2;
    }

    public void atacarEnemigo() {}

    public void construirTorre() {}
}
