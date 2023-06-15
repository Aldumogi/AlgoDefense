package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.mapa.Coordenadas;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class Hormiga extends Enemigo {
    final String nombre = "hormiga";

    public Hormiga(Coordenadas coordenadas) {
        int energia = 1;
        this.velocidad = 1;
        this.dañoCausado = 1;
        this.creditosOtorgados = 0;
        this.coordenadas = coordenadas;
        this.estado = new Vivo( energia );
        this.coeficienteDeRalentizacion = 1;
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

    public String obtenerNombre() {
        return this.nombre;
    }
}



