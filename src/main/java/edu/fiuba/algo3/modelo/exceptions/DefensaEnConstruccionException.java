package edu.fiuba.algo3.modelo.exceptions;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class DefensaEnConstruccionException extends Exception {
    public DefensaEnConstruccionException() {
        super();
        //logger.error("La defensa aún se encuentra en construcción");
    }
}
