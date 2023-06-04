package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoEstaVivoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;

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
    public void verSiEstaMuerto() throws ElEnemigoEstaVivoException {}

    public int contarMuerto() {
        return 1;
    }
    public void agregarIndiceDeEnemigoMuerto(List<Integer> indicesEnemigosMuertos, int posicionActual) {
        indicesEnemigosMuertos.add( posicionActual );
    }
}
