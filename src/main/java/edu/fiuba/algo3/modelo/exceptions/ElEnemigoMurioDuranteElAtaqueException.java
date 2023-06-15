package edu.fiuba.algo3.modelo.exceptions;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class ElEnemigoMurioDuranteElAtaqueException extends Exception{
    public ElEnemigoMurioDuranteElAtaqueException() {
        super();
        //logger.info("No es posible atacar a un enemigo muerto");
    }
}
