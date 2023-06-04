package edu.fiuba.algo3;

import java.util.Random;

public class Arania extends Enemigo {

    public Arania() {
        this.velocidad(2) ;
        this.dañoCausado(2);
        this.energia (2);
        this.creditosOtorgados(0);
        this.coordenadas = getCoordenadasLargada();
        this.estado = new Vivo();
    }

    public Arania(Coordenadas coordenadas) {
        this.velocidad(2) ;
        this.dañoCausado(2);
        this.energia (2);
        this.creditosOtorgados(0);
        this.coordenadas = coordenadas;
        this.estado = new Vivo();
    }

    public int cantidadCreditosOtorgados(int cantidadDeAraniasMuertas) {
        Random random = new Random();
        this.creditosOtorgados(random.nextInt(10) + 1);
        return this.creditosOtorgados();
    }

    private Coordenadas getCoordenadasLargada() {
        // Al mapa le pedira las coordenadas de la parcela de largada
        return new Coordenadas(3,2);
    }
    public boolean recibirDanio(int unDanio){
        if (estaVivo()){
            this.energia = this.energia - unDanio;
            return true;
        }
        return false;
    }
    public boolean esUnaHormiga() {
        return false;
    }

}
