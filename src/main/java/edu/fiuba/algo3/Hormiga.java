package edu.fiuba.algo3;

public class Hormiga extends Enemigo {

    private int velocidad;
    private int dañoCausado;
    private int energia;
    private int creditosOtorgados;

    public Hormiga() {
        this.velocidad = 1;
        this.dañoCausado = 1;
        this.energia = 1;
        this.creditosOtorgados = 1;
    }

    public int cantidadCreditosOtorgados() {
        return 0;
    }

    public boolean estaVivo() {
        return (this.energia > 0) ? true : false;
    }
}
