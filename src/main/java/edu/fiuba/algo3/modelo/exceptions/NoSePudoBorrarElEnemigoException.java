package edu.fiuba.algo3.modelo.exceptions;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class NoSePudoBorrarElEnemigoException extends Exception {
    public NoSePudoBorrarElEnemigoException() {
        super();
        //logger.error("No es posible eliminar al enemigo");
    }
}
