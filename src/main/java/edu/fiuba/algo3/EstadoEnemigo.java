package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.ElEnemigoEstaVivoException;

public interface EstadoEnemigo {
    void mover(Enemigo enemigo);
    void verSiEstaMuerto() throws ElEnemigoEstaVivoException;
}
