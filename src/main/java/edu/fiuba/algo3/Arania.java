package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.Random;

public class Arania extends Enemigo {

    public Arania() {
        this.velocidad = 2 ;
        this.dañoCausado = 2;
        this.energiaInicial = 2;
        this.creditosOtorgados = 0;
        this.coordenadas = getCoordenadasLargada();
        this.estado = new Vivo(this.energiaInicial);
    }

    public Arania(Coordenadas coordenadas) {
        this.velocidad = 2 ;
        this.dañoCausado = 2;
        this.energiaInicial = 2;
        this.creditosOtorgados = 0;
        this.coordenadas = coordenadas;
        this.estado = new Vivo(this.energiaInicial);
    }

    public int cantidadCreditosOtorgados(int cantidadDeAraniasMuertas) {
        Random random = new Random();
        int creditosOtorgados = random.nextInt(10) + 1;
        return this.estado.creditosOtorgados( creditosOtorgados );
    }

    private Coordenadas getCoordenadasLargada() {
        // Al mapa le pedira las coordenadas de la parcela de largada
        return new Coordenadas(3,2);
    }
    public void acumularMuertos(ArrayList<Hormiga> hormigasMuertas) { }

}
