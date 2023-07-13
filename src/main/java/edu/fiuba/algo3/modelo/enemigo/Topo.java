package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.modelo.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class Topo extends Enemigo {
    final String nombre = "Topo";

    public Topo(Coordenadas coordenadas) {
        int energia = 100;
        this.velocidad = 1 ;
        this.dañoCausado = 2;
        this.creditosOtorgados = 0;
        this.coordenadas = coordenadas;
        this.estado = new Vivo( energia , this.nombre);
        this.coeficienteDeRalentizacion = 1;
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
    public boolean equals(Object e2) {
        if ( e2 == this ) {
            return true;
        }
        if ( !(e2 instanceof Topo) ) {
            return false;
        }
        Topo e = (Topo) e2;
        return e.coordenadas == this.coordenadas && e.estado == this.estado;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public void realizarAtaque(Jugador jugador, int numeroDeTurno, Mapa mapa) {
        int danio = _calcularDanioSegunTurno(numeroDeTurno);
        logger.info( this.nombre + " llega a la meta, produce " + danio + " de daño al jugador" );
        jugador.restarEnergia( danio );
    }
    @Override
    public int obtenerDanioCausado (int numeroDeTurno) {
        return _calcularDanioSegunTurno(numeroDeTurno);
    }
    private int _calcularDanioSegunTurno(int numeroDeTurno) {
        int dañoEnTurnoImpar = 5;
        return ( numeroDeTurno % 2 == 0 ) ? this.dañoCausado : dañoEnTurnoImpar;
    }
}
