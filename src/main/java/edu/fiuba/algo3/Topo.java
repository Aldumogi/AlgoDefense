package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;

import java.util.ArrayList;

import static edu.fiuba.algo3.Inicializador.logger;

public class Topo extends Enemigo{
    public Topo() {
        int energia = 100;
        this.velocidad = 1 ;
        this.dañoCausado = 2;
        this.creditosOtorgados = 0;
        this.coordenadas = getCoordenadasLargada();
        this.estado = new Vivo( energia );
        this.cantidadDeMovimientosRealizados = 0;
        logger.info("Se creó un topo");
    }
    public Topo(Coordenadas coordenadas) {
        int energia = 100;
        this.velocidad = 1 ;
        this.dañoCausado = 2;
        this.creditosOtorgados = 0;
        this.coordenadas = coordenadas;
        this.estado = new Vivo( energia );

        logger.info("Se creó un topo");
    }
    private Coordenadas getCoordenadasLargada() {
        return new Coordenadas(3, 2);
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
}
