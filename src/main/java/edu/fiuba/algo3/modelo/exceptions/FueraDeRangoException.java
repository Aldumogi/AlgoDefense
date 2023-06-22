package edu.fiuba.algo3.modelo.exceptions;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class FueraDeRangoException extends Exception{
    public FueraDeRangoException() {
        super();
        //logger.error("No se puede atacar porque el enemigo se encuentra fuera del rango de la defensa");
    }
}
