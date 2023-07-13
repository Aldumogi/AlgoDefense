package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;

import java.util.ArrayList;
import java.util.Random;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class Arania extends Enemigo {
    final String nombre = "Araña";

    public Arania(Coordenadas coordenadas) {
        int energia = 2;
        this.velocidad = 2 ;
        this.dañoCausado = 2;
        this.creditosOtorgados = 0;
        this.coordenadas = coordenadas;
        this.estado = new Vivo( energia , this.nombre);
        this.coeficienteDeRalentizacion = 1;
    }

    public int cantidadCreditosOtorgados(int cantidadDeAraniasMuertas) {
        Random random = new Random();
        int creditosOtorgados = random.nextInt(10) + 1;
        this.creditosOtorgados = this.estado.creditosOtorgados( creditosOtorgados );
        return this.creditosOtorgados;
    }

    public void acumularMuertos(ArrayList<Hormiga> hormigasMuertas) { }

    protected void _actualizarVelocidadSegunCantidadDeMovimientos() { }

    public void realizarAtaque(Jugador jugador, int numeroDeTurno, Mapa mapa) {
        logger.info( this.nombre + " llega a la meta, produce " + this.dañoCausado + " de daño al jugador" );
        jugador.restarEnergia( this.dañoCausado );
    }

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

    public String obtenerNombre() {
        return this.nombre;
    }
}
