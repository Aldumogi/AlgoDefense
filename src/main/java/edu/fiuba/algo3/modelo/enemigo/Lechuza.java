package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.exceptions.NoSePudoBorrarElEnemigoException;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcela.Parcela;

import java.util.ArrayList;
import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class Lechuza extends Enemigo {
        final String nombre = "Lechuza";

        public Lechuza(Coordenadas coordenadas) {
                int energia = 5;
                this.velocidad = 5 ;
                this.dañoCausado = 0;
                this.coordenadas = coordenadas;
                this.estado = new Vivo( energia , this.nombre );
                this.coeficienteDeRalentizacion = 1;
                logger.info("Se creó una Lechuza");
        }

        @Override
        public int cantidadCreditosOtorgados(int cantidadDeMuertosDeUnTipoDeEnemigo) {
                return 0;
        }

        public void acumularMuertos(ArrayList<Hormiga> hormigasMuertas) { }

        protected void _actualizarVelocidadSegunCantidadDeMovimientos() {  }

        public void mover(Mapa mapa) throws NoSePudoBorrarElEnemigoException{
                // Pedir a mapa pasarela actual y eliminar enemigo
                Parcela pasarela = mapa.obtenerCelda(this.coordenadas);
                pasarela.borrarObjeto(this);

                // Mover a la siguiente parsela
                double velocidad = this.velocidad;
                Coordenadas coordenadaSiguiente = mapa.devolverSiguienteCoordenadaEnL(this.coordenadas, (int)velocidad);
                if(this.estado.obtenerEnergia() <= 2){
                        coordenadaSiguiente = mapa.devolverSiguientesNCoordenadaUsandoDiagonalesMasCercanaALaMeta(this.coordenadas, (int)velocidad);
                }
                Parcela pasarelaSiguiente  = mapa.obtenerCelda(coordenadaSiguiente);
                pasarelaSiguiente.recibir(this);

                this.coordenadas = coordenadaSiguiente;
  
                
        }

        public void realizarAtaque(Jugador jugador, int numeroDeTurno, Mapa mapa) {
                jugador.destruirPrimeraTorre(mapa);
                logger.info( this.nombre + " llega a la meta y destruye la primera torre construida si es que existía");
        }
        public boolean equals(Object e2) {
                if ( e2 == this ) {
                return true;
                }
                if ( !(e2 instanceof Lechuza) ) {
                return false;
                }
                Lechuza e = (Lechuza) e2;
                return e.coordenadas == this.coordenadas && e.estado == this.estado;
        }

        public String obtenerNombre() {
                return this.nombre;
        }

        public int obtenerDanioCausado (int numeroDeTurno) {
                return this.dañoCausado;
        }

}
