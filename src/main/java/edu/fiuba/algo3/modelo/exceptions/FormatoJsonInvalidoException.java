package edu.fiuba.algo3.modelo.exceptions;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class FormatoJsonInvalidoException extends Exception {
    public FormatoJsonInvalidoException() {
        super();
        //logger.error("El formato del archivo es inválido");
    }
}
