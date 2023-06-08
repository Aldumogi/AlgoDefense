package edu.fiuba.algo3;

import java.util.ArrayList;

import static edu.fiuba.algo3.Inicializador.logger;

public class Hormiga extends Enemigo {

    public Hormiga() {
        this.velocidad = 1;
        this.dañoCausado = 1;
        this.energiaInicial = 1;
        this.creditosOtorgados = 1;
        this.coordenadas = this.getCoordenadasLargada();
        this.estado = new Vivo(this.energiaInicial);

        logger.info("Se creó una hormiga");
    }
    public Hormiga(Coordenadas coordenadas) {
        this.velocidad = 1;
        this.dañoCausado = 1;
        this.energiaInicial = 1;
        this.creditosOtorgados = 1;
        this.coordenadas = coordenadas;
        this.estado = new Vivo(this.energiaInicial);

        logger.info("Se creó una hormiga");
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
    public void acumularMuertos(ArrayList<Hormiga> hormigasMuertas) {
        this.estado.acumularHormigasMuertas(hormigasMuertas, this);
    }
    @Override
    public boolean equals(Object e2) {
        if ( e2 == this ) {
            return true;
        }
        if ( !(e2 instanceof Hormiga) ) {
            return false;
        }
        Hormiga e = (Hormiga) e2;
        return e.coordenadas == this.coordenadas && e.estado == this.estado;
    }
}



