package edu.fiuba.algo3.view;

import java.util.HashMap;
import java.util.List;

import edu.fiuba.algo3.modelo.enemigo.Arania;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import edu.fiuba.algo3.modelo.parcela.Parcela;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
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
    
    List<Enemigo> enemigos = parcela.obtener();

    if( enemigos.size() > 0 ) {
      Enemigo primerEnemigo = enemigos.get(0);
      Image img = null;
      if( primerEnemigo instanceof Arania){
        img = new Image(getClass().getResourceAsStream("arania.png"));
      } else if( primerEnemigo instanceof Hormiga){
        img = new Image(getClass().getResourceAsStream("hormiga.png"));
      }
        ImagePattern imagePattern = new ImagePattern(img);
        this.setFill(imagePattern);
      }
    }
    
  }

