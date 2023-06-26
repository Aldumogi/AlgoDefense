package edu.fiuba.algo3.controller;

import java.util.List;

import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.parcela.Parcela;
import edu.fiuba.algo3.view.VistaEnemigos;
import edu.fiuba.algo3.view.VistaParcela;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class ControladorMouse implements EventHandler<MouseEvent> {
  
  private Parcela parcela;
  private VistaParcela vista;
  
  public ControladorMouse(Parcela parcela, VistaParcela vista) {
    this.parcela = parcela;
    this.vista = vista;
  }

  @Override 
  public void handle(MouseEvent e) { 
    this.parcela.notifyObservers(this.vista);
    List<Enemigo> enemigos = this.parcela.obtener(); 

    VistaEnemigos vistaEnemigos = new VistaEnemigos(enemigos);
    vistaEnemigos.show();
  }

}
