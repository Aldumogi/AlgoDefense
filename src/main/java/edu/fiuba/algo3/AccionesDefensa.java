package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.DefensaEnConstruccionException;

public interface AccionesDefensa {
    Boolean atacarEnemigo(Enemigo enemigo, int rangoDeAtaque, int danio, Coordenadas coordenadasDefensa);
    void estaTerminada() throws DefensaEnConstruccionException;
}
