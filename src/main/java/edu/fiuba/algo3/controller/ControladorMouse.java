package edu.fiuba.algo3.controller;

import java.util.List;

import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.parcela.Parcela;
import edu.fiuba.algo3.view.VistaEnemigos;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class ControladorMouse implements EventHandler<MouseEvent> {
  
  private Parcela parcela;
  
  public ControladorMouse(Parcela parcela) {
    this.parcela = parcela;
  }

  @Override 
  public void handle(MouseEvent e) { 
    List<Enemigo> enemigos = this.parcela.obtener(); 

    VistaEnemigos vistaEnemigos = new VistaEnemigos(enemigos);
    vistaEnemigos.show();
  }

}
