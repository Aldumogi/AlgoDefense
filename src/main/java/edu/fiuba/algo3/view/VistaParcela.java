package edu.fiuba.algo3.view;

import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import edu.fiuba.algo3.controller.ControladorMouse;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.parcela.Parcela;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class VistaParcela extends StackPane implements Observer {
  private Parcela parcela;
  private Text numeroEnemigos;

  private final HashMap<String, Color> color = new HashMap<>() {{
        put("PLargada", Color.ORANGE);
        put("PNormal", Color.YELLOW);
        put("PMeta", Color.GREEN);
        put("R", Color.GREY);
        put("T", Color.BROWN);
    }};

  public VistaParcela (Parcela parcela, double medidaCelda) {
    super();
    this.parcela = parcela;
    this.parcela.addObserver(this);


    Rectangle rect = new Rectangle(medidaCelda, medidaCelda);
    rect.setFill( color.get( parcela.obtenerTipo() ) );
    rect.setStroke(Color.BLACK);
    rect.setStrokeWidth(1);

    rect.setWidth(medidaCelda);
    rect.setHeight(medidaCelda);

    numeroEnemigos = new Text(this.cantidadEnemigos());

    this.getChildren().addAll(rect, numeroEnemigos);

    ControladorMouse eventHandler = new ControladorMouse(parcela, this);
    this.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
  }

  public void actualizarNumeroEnemigos(){
    numeroEnemigos.setText(this.cantidadEnemigos());
  }

  private String cantidadEnemigos(){
    List<Enemigo> enemigos = this.parcela.obtener();
    return enemigos.size() == 0 ? "" : Integer.toString(enemigos.size());
  }

  @Override
  public void update(Observable o, Object arg) {
    this.actualizarNumeroEnemigos();
  }

}

