package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.modelo.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;

import java.util.ArrayList;
import java.util.List;

public class Muerto implements EstadoEnemigo {
    public EstadoEnemigo recibirDanio(int danio, Coordenadas coordenadas) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException {
        throw new ElEnemigoEstaMuertoException();
    }
    public int obtenerEnergia() { return 0; }
    public int creditosOtorgados(int creditos) {
        return creditos;
    }

    public void acumular(ArrayList<Hormiga> hormigasMuertas, Hormiga enemigo) {
        hormigasMuertas.add(enemigo);
    }

    public void agregarIndiceDeEnemigoMuerto(List<Integer> indicesEnemigosMuertos, int posicionActual) {
        indicesEnemigosMuertos.add( posicionActual );
    }
    @Override
    public boolean equals(Object o) {
        if ( o == this ) {
            return true;
        }
        if ( !(o instanceof Muerto) ) {
            return false;
        }
        return true;
    }
}
