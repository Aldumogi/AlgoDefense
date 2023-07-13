package edu.fiuba.algo3.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;

import static edu.fiuba.algo3.view.SoundUtils.*;

public class VistaEnemigos {
  private int medidaImagen = 30;
  private Stage stage;
  private final HashMap<String, String> imgEnemigos = new HashMap<>() {{
        put("Hormiga", "src/main/java/edu/fiuba/algo3/view/images/enemigos/hormiga.png");
        put("Araña", "src/main/java/edu/fiuba/algo3/view/images/enemigos/arania.png");
        put("Topo", "src/main/java/edu/fiuba/algo3/view/images/enemigos/topo.png");
        put("Lechuza", "src/main/java/edu/fiuba/algo3/view/images/enemigos/lechuza.png");
    }};
  
  public VistaEnemigos(List<Enemigo> enemigos) throws FileNotFoundException {
    this.stage = new Stage();
    stage.setTitle("Enemigos en Parcela");

    GridPane root = new GridPane();
    Scene scene = new Scene(root, 300, 200);

    if( enemigos.size() > 0 ) {
      int fila = 0;
      int columna = 0;
      for (Enemigo enemigo : enemigos) {
        Rectangle rect = new Rectangle(medidaImagen, medidaImagen);
        rect.setStroke(Color.BLACK);
        rect.setStrokeWidth(1);
        InputStream imageStream = new FileInputStream(imgEnemigos.get(enemigo.obtenerNombre()));
        Image img = new Image(imageStream);
        ImagePattern imagePattern = new ImagePattern(img);

        rect.setFill(imagePattern);
        root.add(rect, columna, fila);

        columna = (columna == 4) ? 0 : columna + 1;
        fila = (columna == 0) ? fila + 1 : fila;
      }
    }

    playSound(BUTTON_OPEN_SOUND_FILE_PATH, 0.7f,null);
    stage.setScene(scene);
  }

  public void show(){
    this.stage.show();
  }
}
