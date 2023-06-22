package edu.fiuba.algo3.modelo.exceptions;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class NoEsPosibleRecibirEnemigosEnParcelaException extends RuntimeException{
    public NoEsPosibleRecibirEnemigosEnParcelaException() {
        super();
        //logger.error("La parcela no puede alojar enemigos");
    }
}