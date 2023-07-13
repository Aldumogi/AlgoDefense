package edu.fiuba.algo3.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import static edu.fiuba.algo3.view.SoundUtils.*;

public class PanelDeConstruccion {
  private static final String TORRE_BLANCA = "src/main/java/edu/fiuba/algo3/view/images/defensas/torreBlancaCosto.png";
  private static final String TORRE_PLATEADA = "src/main/java/edu/fiuba/algo3/view/images/defensas/torreNegraCosto.png";
  private static final String TRAMPA_ARENOSA = "src/main/java/edu/fiuba/algo3/view/images/defensas/trampaArenosaCosto.png";
  private int creditosTemp;
  public PanelDeConstruccion() {
  }

  public GridPane generarPanel(double medidaCelda, int creditos, Label creditosLabel) throws FileNotFoundException{
    creditosTemp = creditos;
    GridPane panelDeConstruccion = new GridPane();
    Rectangle torreBlancaRect = new Rectangle(medidaCelda, medidaCelda);
    torreBlancaRect.setStroke(Color.BLACK);
    torreBlancaRect.setStrokeWidth(1);
    InputStream torreBlanca = new FileInputStream(TORRE_BLANCA);
    Image torreBlancaImg = new Image(torreBlanca);
    ImagePattern torreBlancaIP = new ImagePattern(torreBlancaImg);
  
    torreBlancaRect.setFill(torreBlancaIP);
    
    torreBlancaRect.setOnMouseClicked(e -> playSound(CLICK_DEFENSE_SOUND_FILE_PATH, 1.1f, null) );
    torreBlancaRect.setOnDragDetected((MouseEvent event) -> {
        if((creditosTemp - 10) < 0 ) {
            playSound(CLICK_DEFENSE_DENIED_SOUND_FILE_PATH, 1.1f, null);
        }else{
            creditosTemp = creditosTemp - 10;
            Dragboard db = torreBlancaRect.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString("torre blanca");
            db.setContent(content);
            playSound(CLICK_DEFENSE_BUILDING_SOUND_FILE_PATH, 1.1f, null);
        }
        creditosLabel.setText("Creditos: " + (creditosTemp <= 0 ? 0: creditosTemp));
    });
    torreBlancaRect.setOnMouseDragged((MouseEvent event) -> {
        event.setDragDetect(true);
    });
  
    panelDeConstruccion.add(torreBlancaRect, 0, 1);



    Rectangle torrePlateadaRect = new Rectangle(medidaCelda, medidaCelda);
    torrePlateadaRect.setStroke(Color.BLACK);
    torrePlateadaRect.setStrokeWidth(1);
    InputStream torrePlateada = new FileInputStream(TORRE_PLATEADA);
    Image torrePlateadaImg = new Image(torrePlateada);
    ImagePattern torrePlateadaIP = new ImagePattern(torrePlateadaImg);
  
    torrePlateadaRect.setFill(torrePlateadaIP);
    
    torrePlateadaRect.setOnMouseClicked(e -> playSound(CLICK_DEFENSE_SOUND_FILE_PATH, 1.1f, null) );
    torrePlateadaRect.setOnDragDetected((MouseEvent event) -> {
        if((creditosTemp - 20) < 0 ) {
            playSound(CLICK_DEFENSE_DENIED_SOUND_FILE_PATH, 1.1f, null);
        }else{
            creditosTemp = creditosTemp - 20;
            Dragboard db = torrePlateadaRect.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString("torre plateada");
            db.setContent(content);
            playSound(CLICK_DEFENSE_BUILDING_SOUND_FILE_PATH, 1.1f, null);
        }
        creditosLabel.setText("Creditos: " + (creditosTemp <= 0 ? 0: creditosTemp));
    });
    torrePlateadaRect.setOnMouseDragged((MouseEvent event) -> {
        event.setDragDetect(true);
    });
    
    panelDeConstruccion.add(torrePlateadaRect, 1, 1);

  
    Rectangle trampaArenosaRect = new Rectangle(medidaCelda, medidaCelda);
    trampaArenosaRect.setStroke(Color.BLACK);
    trampaArenosaRect.setStrokeWidth(1);
    InputStream trampaArenosa = new FileInputStream(TRAMPA_ARENOSA);
    Image trampaArenosaImg = new Image(trampaArenosa);
    ImagePattern trampaArenosaIP = new ImagePattern(trampaArenosaImg);
  
    trampaArenosaRect.setFill(trampaArenosaIP);
    
    trampaArenosaRect.setOnMouseClicked(e -> playSound(CLICK_DEFENSE_SOUND_FILE_PATH, 1.1f, null) );
    trampaArenosaRect.setOnDragDetected((MouseEvent event) -> {
        if((creditosTemp - 25) < 0 ) {
            playSound(CLICK_DEFENSE_DENIED_SOUND_FILE_PATH, 1.1f, null);
        }else {
            creditosTemp = creditosTemp - 25;
            Dragboard db = trampaArenosaRect.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString("trampa arenosa");
            db.setContent(content);
            playSound(CLICK_DEFENSE_BUILDING_SOUND_FILE_PATH, 1.1f, null);
        }
        creditosLabel.setText("Creditos: " + (creditosTemp <= 0 ? 0: creditosTemp));
    });
    trampaArenosaRect.setOnMouseDragged((MouseEvent event) -> {
        event.setDragDetect(true);
    });
    
    panelDeConstruccion.add(trampaArenosaRect, 2, 1);
    return panelDeConstruccion;
  }

}
