package edu.fiuba.algo3.modelo.exceptions;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class FormatoEnemigosInvalidoException extends Exception {
    public FormatoEnemigosInvalidoException() {
        super();
        //logger.error("El formato del archivo de enemigos es inválido");
    }
}
