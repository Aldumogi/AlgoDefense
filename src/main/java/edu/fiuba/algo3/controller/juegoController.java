package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.juego.Juego;

public class juegoController {
  private Juego juego;

  public juegoController(Juego juego){
    this.juego = juego;
  }

  public void avanzarTurno(){
    juego.avanzarTurno();
  }
}
