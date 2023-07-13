package edu.fiuba.algo3.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class VistaDefensa {
  Image defensaImg;

  private final HashMap<String, String> imgDefensa = new HashMap<>() {{
        put("Torre Blanca", "src/main/java/edu/fiuba/algo3/view/images/defensas/torreBlanca.png");
        put("Torre Blanca const", "src/main/java/edu/fiuba/algo3/view/images/defensas/torreBlancaConst.png");
        put("Torre Plateada", "src/main/java/edu/fiuba/algo3/view/images/defensas/torreNegra.png");
        put("Torre Plateada const", "src/main/java/edu/fiuba/algo3/view/images/defensas/torreNegraConst.png");
        put("Trampa arenosa", "src/main/java/edu/fiuba/algo3/view/images/defensas/trampaArenosa.png");
        put("Trampa arenosa const", "src/main/java/edu/fiuba/algo3/view/images/defensas/trampaArenosaConst.png");
    }};
  
  public VistaDefensa(Defensa defensa) throws FileNotFoundException {
    try {
      String enConstruccion = defensa.enConstruccion() ? " const" : "";
      InputStream torreBlancaIS;
      torreBlancaIS = new FileInputStream(imgDefensa.get(defensa.getNombre() + enConstruccion));
      this.defensaImg = new Image(torreBlancaIS);
    } catch (Exception e) {
    }

  }

  public ImageView obtenerVistaDeImagen(){
    return new ImageView(defensaImg);
  }
  
}
