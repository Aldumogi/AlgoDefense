package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.ElEnemigoEstaVivoException;

public class Hormiga extends Enemigo {

    public Hormiga() {
        this.velocidad = 1;
        this.dañoCausado = 1;
        this.energiaInicial = 1;
        this.creditosOtorgados = 1;
        this.coordenadas = this.getCoordenadasLargada();
        this.estado = new Vivo(this.energiaInicial);
    }
    public Hormiga(Coordenadas coordenadas) {
        this.velocidad = 1;
        this.dañoCausado = 1;
        this.energiaInicial = 1;
        this.creditosOtorgados = 1;
        this.coordenadas = coordenadas;
        this.estado = new Vivo(this.energiaInicial);
    }

    public int cantidadCreditosOtorgados(int cantidadDeHormigasMuertas) {
        int creditosOtorgados = ( cantidadDeHormigasMuertas < 11 ) ? 1:2 ;
        return this.estado.creditosOtorgados(creditosOtorgados);
    }

    private Coordenadas getCoordenadasLargada() {
        // Al mapa le pedira las coordenadas de la parcela de largada
        return new Coordenadas(3,1);
    }

    private Coordenadas getCoordenadasMeta() {
        // Al mapa le pedira las coordenadas de la parcela de largada
        return new Coordenadas(5,2);
    }
    public int contarHormigaMuerta() {
        return this.estado.contarMuerto();
    }

}



