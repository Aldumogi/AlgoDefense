package edu.fiuba.algo3;

public class Hormiga extends Enemigo {


    public Hormiga() {
        this.velocidad(1);
        this.dañoCausado(1);
        this.energia(1);
        this.creditosOtorgados(1);
        this.coordenadas = this.getCoordenadasLargada();
    }
    public Hormiga(Coordenadas coordenadas) {
        this.velocidad(1);
        this.dañoCausado(1);
        this.energia(1);
        this.creditosOtorgados(1);
        this.coordenadas = coordenadas;
    }

    public int cantidadCreditosOtorgados() {
        
        return 0;
    }

    private Coordenadas getCoordenadasLargada() {
        // Al mapa le pedira las coordenadas de la parcela de largada
        return new Coordenadas(3,1);
    }
}



