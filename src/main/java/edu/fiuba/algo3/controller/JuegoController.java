package edu.fiuba.algo3.controller;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.parcela.Parcela;
import edu.fiuba.algo3.view.VistaParcela;
import javafx.util.Pair;

public class JuegoController {
  private Juego juego;
  private List<Pair<Parcela, VistaParcela>> observables;

  public JuegoController(Juego juego){
    this.juego = juego;
    observables = new ArrayList<Pair<Parcela, VistaParcela>>();
  }

  public void agregarObservable(Parcela parcela, VistaParcela vista){
    Pair<Parcela, VistaParcela> observable = new Pair<Parcela, VistaParcela>(parcela, vista);
    observables.add(observable);
  }

  public void avanzarTurno(){
    juego.avanzarTurno();
    for(Pair<Parcela, VistaParcela> obs : observables){
      obs.getKey().notifyObservers(obs.getValue());
    }
  }
}
