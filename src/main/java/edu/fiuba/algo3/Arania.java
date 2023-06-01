package edu.fiuba.algo3;

import java.util.Random;

public class Arania extends Enemigo {

    public Arania() {
        this.velocidad(2) ;
        this.dañoCausado(2);
        this.energia (2);
        this.creditosOtorgados(0);
    }

    public Arania(Coordenadas coordenadas) {
        this.velocidad(2) ;
        this.dañoCausado(2);
        this.energia (2);
        this.creditosOtorgados(0);
        this.coordenadas = coordenadas;
    }

    public int cantidadCreditosOtorgados() {
        Random random = new Random();
        this.creditosOtorgados(random.nextInt(11));
        return this.creditosOtorgados();
    }



}
