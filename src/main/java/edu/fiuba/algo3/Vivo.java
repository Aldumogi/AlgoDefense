package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.ElEnemigoEstaVivoException;

public class Vivo implements EstadoEnemigo {
    public void mover(Enemigo enemigo) {

    }
    public void verSiEstaMuerto() throws ElEnemigoEstaVivoException {
        throw new ElEnemigoEstaVivoException();
    }
}
