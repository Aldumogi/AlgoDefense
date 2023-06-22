package edu.fiuba.algo3.view;

import java.util.HashMap;

import edu.fiuba.algo3.modelo.parcela.Parcela;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

// import java.util.Observer;

public class VistaParcela extends Rectangle /*implements Observer */{

  private final HashMap<String, Color> color = new HashMap<>() {{
        put("PLargada", Color.ORANGE);
        put("PNormal", Color.YELLOW);
        put("PMeta", Color.GREEN);
        put("R", Color.GREY);
        put("T", Color.BROWN);
    }};

  public VistaParcela (Parcela parcela, double medidaCelda) {
    super(medidaCelda, medidaCelda);
    this.setFill( color.get( parcela.obtenerTipo() ) );
    this.setStroke(Color.BLACK);
    this.setStrokeWidth(1);

    this.setWidth(medidaCelda);
    this.setHeight(medidaCelda);
  }
}
