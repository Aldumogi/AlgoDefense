package edu.fiuba.algo3.exceptions;

public class ElEnemigoEstaMuertoException extends Exception{
    public ElEnemigoEstaMuertoException() { super("No es posible atacar a un enemigo muerto"); }
}
