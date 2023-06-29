package edu.fiuba.algo3.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.parcela.Parcela;
import edu.fiuba.algo3.view.VistaParcela;
import javafx.util.Pair;

public class JuegoController {
  private Juego juego;
  private List<Pair<Observable, Observer>> observables;

  public JuegoController(Juego juego){
    this.juego = juego;
    observables = new ArrayList<Pair<Observable, Observer>>();
  }

  public void agregarObservable(Observable modelo, Observer vista){
    Pair<Observable, Observer> observable = new Pair<Observable, Observer>(modelo, vista);
    observables.add(observable);
  }

  public boolean avanzarTurno(){
    juego.avanzarTurno();
    for(Pair<Observable, Observer> obs : observables){
      obs.getKey().notifyObservers(obs.getValue());
    }
    return (juego.juegoTerminado())? false: true;
  }
}
