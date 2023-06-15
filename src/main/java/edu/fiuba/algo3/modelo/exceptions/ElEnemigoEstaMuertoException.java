package edu.fiuba.algo3.modelo.exceptions;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class ElEnemigoEstaMuertoException extends Exception{
    public ElEnemigoEstaMuertoException() {
        super("No es posible atacar a un enemigo muerto");
        //logger.error("No es posible atacar a un enemigo muerto");
    }
}
