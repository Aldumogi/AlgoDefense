package edu.fiuba.algo3;

import java.util.ArrayList;

import static edu.fiuba.algo3.Inicializador.logger;

public class Hormiga extends Enemigo {
    public Hormiga(Coordenadas coordenadas) {
        int energia = 1;
        this.velocidad = 1;
        this.dañoCausado = 1;
        this.creditosOtorgados = 0;
        this.coordenadas = coordenadas;
        this.estado = new Vivo( energia );
        this.coeficienteDeRalentizacion = 1;
        logger.info("Se creó una hormiga");
    }

    public int cantidadCreditosOtorgados(int cantidadDeHormigasMuertas) {
        int creditosOtorgados = ( cantidadDeHormigasMuertas < 11 ) ? 1:2 ;
        this.creditosOtorgados = this.estado.creditosOtorgados(creditosOtorgados);
        return this.creditosOtorgados;
    }
    public void acumularMuertos(ArrayList<Hormiga> hormigasMuertas) {
        this.estado.acumularHormigasMuertas(hormigasMuertas, this);
    }

    protected void _actualizarVelocidadSegunCantidadDeMovimientos() {  }

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



