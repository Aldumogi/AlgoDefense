package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.Random;

import static edu.fiuba.algo3.Inicializador.logger;

public class Arania extends Enemigo {

    public Arania() {
        int energia = 2;
        this.velocidad = 2 ;
        this.dañoCausado = 2;
        this.creditosOtorgados = 0;
        this.coordenadas = getCoordenadasLargada();
        this.estado = new Vivo( energia );

        logger.info("Se creó una araña");
    }

    public Arania(Coordenadas coordenadas) {
        int energia = 2;
        this.velocidad = 2 ;
        this.dañoCausado = 2;
        this.creditosOtorgados = 0;
        this.coordenadas = coordenadas;
        this.estado = new Vivo( energia );

        logger.info("Se creó una araña");
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

    protected void _actualizarVelocidadSegunCantidadDeMovimientos() { }

    @Override
    public boolean equals(Object e2) {
        if ( e2 == this ) {
            return true;
        }
        if ( !(e2 instanceof Arania) ) {
            return false;
        }
        Arania e = (Arania) e2;
        return e.coordenadas == this.coordenadas && e.estado == this.estado;
    }
}
