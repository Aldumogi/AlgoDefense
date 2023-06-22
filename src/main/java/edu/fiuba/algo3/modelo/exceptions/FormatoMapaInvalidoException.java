package edu.fiuba.algo3.modelo.exceptions;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class FormatoMapaInvalidoException extends Exception {
    public FormatoMapaInvalidoException() {
        super();
        //logger.error("El formato del archivo del mapa es inválido");
    }
}
