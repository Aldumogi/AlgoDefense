package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.DefensaEnConstruccionException;

public class EnConstruccion implements AccionesDefensa {
    public Boolean atacarEnemigo(Enemigo enemigo, int rangoDeAtaque, int danio, Coordenadas coordenadasDefensa) {
        return false;
    }
    public void estaTerminada() throws DefensaEnConstruccionException {
        throw new DefensaEnConstruccionException();
    }
}
