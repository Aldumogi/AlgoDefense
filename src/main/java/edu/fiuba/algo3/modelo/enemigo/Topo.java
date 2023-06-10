package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.juego.Inicializador.logger;

public class Topo extends Enemigo{
    public Topo(Coordenadas coordenadas) {
        int energia = 100;
        this.velocidad = 1 ;
        this.dañoCausado = 2;
        this.creditosOtorgados = 0;
        this.coordenadas = coordenadas;
        this.estado = new Vivo( energia );
        this.coeficienteDeRalentizacion = 1;
        logger.info("Se creó un topo");
    }

    public int cantidadCreditosOtorgados(int cantidadDeMuertosDeUnTipoDeEnemigo) {
        return 0;
    }

    public void acumularMuertos(ArrayList<Hormiga> hormigasMuertas) { }
    @Override
    public void recibirDanio(int unDanio) throws ElEnemigoEstaMuertoException, ElEnemigoMurioDuranteElAtaqueException {}

    protected void _actualizarVelocidadSegunCantidadDeMovimientos() {
        if ( this.cantidadDeMovimientosRealizados >= 5 ) {
            this.velocidad = ( this.cantidadDeMovimientosRealizados < 10 ) ? 2 : 3;
        }
    }

    @Override
    public int obtenerDanioCausado (int numeroDeTurno) {
        int dañoEnTurnoImpar = 5;
        return ( numeroDeTurno % 2 == 0 ) ? this.dañoCausado : dañoEnTurnoImpar;
    }
    @Override
    public boolean equals(Object e2) {
        if ( e2 == this ) {
            return true;
        }
        if ( !(e2 instanceof Arania) ) {
            return false;
        }
        Topo e = (Topo) e2;
        return e.coordenadas == this.coordenadas && e.estado == this.estado;
    }
}
