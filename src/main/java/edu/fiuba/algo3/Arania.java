package edu.fiuba.algo3;

import java.util.Random;

public class Arania {
    private int velocidad;
    private int dañoCausado;
    private int energia;
    private int creditosOtorgados;

    public Arania() {
        this.velocidad = 2;
        this.dañoCausado = 2;
        this.energia = 2;
        this.creditosOtorgados = 0;
    }

    public int cantidadCreditosOtorgados() {
        Random random = new Random();
        return this.creditosOtorgados = random.nextInt(11);
    }

    public boolean estaVivo() {
        return (this.energia > 0) ? true : false;
    }
}
