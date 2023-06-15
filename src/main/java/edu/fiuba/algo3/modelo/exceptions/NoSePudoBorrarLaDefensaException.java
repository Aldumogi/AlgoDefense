package edu.fiuba.algo3.modelo.exceptions;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class NoSePudoBorrarLaDefensaException extends Exception {
    public NoSePudoBorrarLaDefensaException() {
        super();
        //logger.error("No es posible eliminar la defensa");
    }
}
