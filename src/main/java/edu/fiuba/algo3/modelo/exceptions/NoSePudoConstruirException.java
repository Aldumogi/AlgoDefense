package edu.fiuba.algo3.modelo.exceptions;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class NoSePudoConstruirException extends Exception{
    public NoSePudoConstruirException() {
        super();
        //logger.error("No fue posible construir");
    }
}