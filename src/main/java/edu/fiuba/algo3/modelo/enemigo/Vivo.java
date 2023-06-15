package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.modelo.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;
import java.util.ArrayList;
import java.util.List;

public class Vivo implements EstadoEnemigo {
    private int energia;
    private String nombre;

    public Vivo(int energia, String nombre) {
        this.nombre = nombre;
        this.energia = energia;
    }

    public EstadoEnemigo recibirDanio(int danio, Coordenadas coordenadas) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException {
        this.energia = this.energia - danio;
        if ( this.energia < danio ) {
            logger.info( "Se murió " + this.nombre + " en la posición (" + coordenadas.obtenerFila()
                    + ", " + coordenadas.obtenerColumna() + ")" );
            return new Muerto();
        }
        return this;
    }

    public int creditosOtorgados(int creditos) {
        return 0;
    }
    public int obtenerEnergia() { return this.energia; }
    public void mover(Enemigo enemigo) {}
    public void acumularHormigasMuertas(ArrayList<Hormiga> hormigasMuertas, Hormiga enemigo) {}
    public void agregarIndiceDeEnemigoMuerto(List<Integer> enemigosMuertos, int enemigo) {}

    @Override
    public boolean equals(Object o) {
        if ( o == this ) {
            return true;
        }
        if ( !(o instanceof Vivo) ) {
            return false;
        }
        Vivo e = (Vivo) o;
        return e.energia == this.energia;
    }
}
