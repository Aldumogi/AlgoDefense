package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;

import java.util.ArrayList;
import java.util.List;

public class Muerto implements EstadoEnemigo {
    public void mover(Enemigo enemigo) {

    }
    public EstadoEnemigo recibirDanio(int danio) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException {
        throw new ElEnemigoEstaMuertoException();
    }
    public int creditosOtorgados(int creditos) {
        return creditos;
    }

    public void acumularHormigasMuertas(ArrayList<Hormiga> hormigasMuertas, Hormiga enemigo) {
        hormigasMuertas.add(enemigo);
    }
    public void agregarIndiceDeEnemigoMuerto(List<Integer> indicesEnemigosMuertos, int posicionActual) {
        indicesEnemigosMuertos.add( posicionActual );
    }
}
