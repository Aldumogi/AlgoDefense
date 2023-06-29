package edu.fiuba.algo3.view;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import edu.fiuba.algo3.controller.ControladorMouse;
import edu.fiuba.algo3.controller.ControladorMouseDragged;
import edu.fiuba.algo3.controller.JuegoController;
import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.parcela.Parcela;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import edu.fiuba.algo3.modelo.juego.Juego;


public class VistaParcela extends StackPane implements Observer {
  private Parcela parcela;
  private Label indicador;
  private Defensa defensa;

  private final HashMap<String, Color> color = new HashMap<>() {{
        put("PLargada", Color.ORANGE);
        put("PNormal", Color.YELLOW);
        put("PMeta", Color.GREEN);
        put("R", Color.GREY);
        put("T", Color.BROWN);
    }};

  public VistaParcela (Parcela parcela, double medidaCelda, Juego juego, JuegoController juegoController) throws FileNotFoundException {
    super();
    this.parcela = parcela;
    this.parcela.addObserver(this);


    Rectangle rect = new Rectangle(medidaCelda, medidaCelda);
    rect.setFill( color.get( parcela.obtenerTipo() ) );
    rect.setStroke(Color.BLACK);
    rect.setStrokeWidth(1);

    rect.setWidth(medidaCelda);
    rect.setHeight(medidaCelda);

    indicador = new Label(this.cantidadEnemigos());

    this.getChildren().addAll(rect, indicador);

    ControladorMouse eventHandler = new ControladorMouse(parcela);
    this.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);

    new ControladorMouseDragged(this, juego, juegoController, parcela);

  }

  public void agregarDefensa(Defensa defensa){
    this.defensa = defensa;
  }

  public void actualizarNumeroEnemigos(){
    indicador.setText(this.cantidadEnemigos());
  }

  private String cantidadEnemigos(){
    List<Enemigo> enemigos = this.parcela.obtener();
    return enemigos.size() == 0 ? "" : Integer.toString(enemigos.size());
  }

  @Override
  public void update(Observable o, Object arg) {
    this.actualizarNumeroEnemigos();

    if( this.defensa != null){
      VistaDefensa vd;
      try {
        vd = new VistaDefensa(this.defensa);
        indicador.setGraphic(vd.obtenerVistaDeImagen());
      } catch (FileNotFoundException e) {
      }
    }
  }

}

