package edu.fiuba.algo3.controller;


import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.fabrica.FabricaDeDefensas;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.parcela.Parcela;
import edu.fiuba.algo3.view.VistaParcela;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;


public class ControladorMouseDragged {
  VistaParcela vistaParcela;
  
  public ControladorMouseDragged(VistaParcela vistaParcela, Juego juego, JuegoController juegoController, Parcela parcela) {
    this.vistaParcela = vistaParcela;

    this.vistaParcela.setOnDragDropped((DragEvent event) -> {
      Dragboard db = event.getDragboard();
        if (db.hasString()) {
            FabricaDeDefensas fabrica = new FabricaDeDefensas();
            Defensa defensa =  fabrica.crearDefensa(db.getString());
            vistaParcela.agregarDefensa(defensa);
            defensa.addObserver(vistaParcela);
            juegoController.agregarObservable(defensa, vistaParcela);
            try {
              juego.construirDefensa(defensa, parcela.obtenerCoordenadas(), juego.obtenerMapa());
              defensa.notifyObservers(this);
            } catch (NoSePudoConstruirException e) {
            }
            event.setDropCompleted(true);
        } else {
            event.setDropCompleted(false);
        }
        event.consume();
    });
    
    vistaParcela.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getGestureSource() != this && event.getDragboard().hasString()) {
                    event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                }

                event.consume();
            }
    });
  }

}
