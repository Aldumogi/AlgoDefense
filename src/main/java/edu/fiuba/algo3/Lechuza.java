package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;

import java.util.ArrayList;
import static edu.fiuba.algo3.Inicializador.logger;

public class Lechuza extends Enemigo{

        public Lechuza(Coordenadas coordenadas) {
                int energia = 5;
                this.velocidad = 5 ;
                this.dañoCausado = 0;
                this.coordenadas = coordenadas;
                this.estado = new Vivo( energia );
                this.coeficienteDeRalentizacion = 1;
                logger.info("Se creó una Lechuza");
        }

        public boolean atacaTorres(){
                return true;
        }

        @Override
        public int cantidadCreditosOtorgados(int cantidadDeMuertosDeUnTipoDeEnemigo) {
                return 0;
        }

        public void acumularMuertos(ArrayList<Hormiga> hormigasMuertas) { }

        protected void _actualizarVelocidadSegunCantidadDeMovimientos() {  }

        public int obtenerDanioCausado (int numeroDeTurno) {
                return this.dañoCausado;
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
}
