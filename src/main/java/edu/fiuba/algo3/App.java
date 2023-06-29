package edu.fiuba.algo3;

import edu.fiuba.algo3.controller.JuegoController;
import edu.fiuba.algo3.modelo.exceptions.FormatoEnemigosInvalidoException;
import edu.fiuba.algo3.modelo.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.modelo.juego.Inicializador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.parcela.*;
import edu.fiuba.algo3.view.VistaParcela;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;
import javax.sound.sampled.*;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import static edu.fiuba.algo3.view.SoundUtils.*;

public class App extends Application {

    private Stage primaryStage;
    static String MAP_RELATIVE_PATH = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
    static String ENEMIGOS_RELATIVE_PATH = "src/main/java/edu/fiuba/algo3/resources/enemigos.json"; //"src/main/test/edu/fiuba/algo3/resources/enemigos.json";
    private double medidaCelda = 30;
    private double height = 680, width = 520;
    private static final String TORRE_BLANCA = "src/main/java/edu/fiuba/algo3/view/images/defensas/torreBlanca.png";
    private Clip backgroundClip;
    @Override
    public void start(Stage primaryStage) throws IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        Inicializador partida = new Inicializador(ENEMIGOS_RELATIVE_PATH, MAP_RELATIVE_PATH);
        this.primaryStage = primaryStage;
        primaryStage.setTitle("AlgoDefense");

        StackPane root = new StackPane();
        InputStream iconStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/icon.png");
        Image icon = new Image(iconStream);
        primaryStage.getIcons().add(icon);

        InputStream imageStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/background_main1.png");
        Image backgroundImage = new Image(imageStream);
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false)
        );
        root.setBackground(new Background(background));
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, height, width);

        File cssFile = new File("src/main/java/edu/fiuba/algo3/view/css/styles.css");
        URL cssUrl = cssFile.toURI().toURL();
        scene.getStylesheets().add(cssUrl.toExternalForm());
        InputStream imgBtnStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/button_add_player.png");
        Image imgButton = new Image(imgBtnStream);

        InputStream hoverImgBtnStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/button_add_player_2.png");
        Image hoverImgButton = new Image(hoverImgBtnStream);

        ImageView imageView = new ImageView(imgButton);
        imageView.setFitWidth(200);
        imageView.setFitHeight(75);
        imageView.setTranslateY(75);
        imageView.setOnMouseClicked(e -> {
            try {
                playSound(BUTTON_SOUND_FILE_PATH, 1.1f,null);
                mostrarDialogoIngresarNombre(partida);
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        imageView.setOnMouseEntered(e -> imageView.setImage(hoverImgButton));
        imageView.setOnMouseExited(e -> imageView.setImage(imgButton));

        root.getChildren().add(imageView);

        playBackground(HOME_MUSIC_FILE_PATH, 0.7f);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarDialogoIngresarNombre(Inicializador partida) throws MalformedURLException, FileNotFoundException {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Ingresar Nombre");
        dialog.setContentText("...........");

        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.setHeaderText(null);
        dialogPane.setGraphic(null);
        dialogPane.setPrefWidth(400);

        InputStream imageStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/background_input_name.png");
        Image backgroundImage = new Image(imageStream);
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false)
        );
        dialogPane.setBackground(new Background(background));
        dialogPane.setPadding(new Insets(5));
        dialogPane.getStyleClass().add("my-dialog-pane");
        dialogPane.setStyle("-fx-font-size: 20px;");

        Button cancelButton = (Button) dialogPane.lookupButton(ButtonType.CANCEL);
        cancelButton.getStyleClass().add("my-cancel-button");

        Button okButton = (Button) dialogPane.lookupButton(ButtonType.OK);
        okButton.getStyleClass().add("my-ok-button");
        TextField textField = dialog.getEditor();
        textField.getStyleClass().add("my-text-field; -fx-text-fill: white; ");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            playSound(BUTTON_SOUND_FILE_PATH, 1.1f,null);
            String nombre = result.get();
            if (nombre.length() >= 6) {
                partida.agregarJugador(nombre);
                mostrarPantallaIniciarPartida(partida);
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Nombre de usuario inválido");
                alert.setHeaderText("El nombre debe tener al menos 6 caracteres");
                alert.showAndWait();
            }
        }
    }

    private void mostrarPantallaIniciarPartida(Inicializador partida) throws FileNotFoundException {
        StackPane root = new StackPane();

        InputStream imageStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/background_start_game.png");
        Image backgroundImage = new Image(imageStream);
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false)
        );
        root.setBackground(new Background(background));
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, height, width);

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        Label messageLabel = new Label("¡Bienvenido, " + partida.obtenerJuego().obtenerJugador().obtenerNombre() + "!");
        messageLabel.setFont(Font.font("Cambria", FontWeight.BOLD, 26));
        messageLabel.setTextFill(Color.ORANGE);

        InputStream imgBtnStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/start_game_btn.png");
        Image imgButton = new Image(imgBtnStream);

        InputStream hoverImgBtnStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/start_game_btn_hover.png");
        Image hoverImgButton = new Image(hoverImgBtnStream);

        ImageView imageView = new ImageView(imgButton);
        imageView.setFitWidth(200);
        imageView.setFitHeight(75);
        imageView.setTranslateY(60);
        imageView.setOnMouseClicked(e -> {
            playSound(BUTTON_SOUND_FILE_PATH, 1.1f, null);
            try {
                mostrarPantallaConMapa(partida);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        });
        imageView.setOnMouseEntered(e -> imageView.setImage(hoverImgButton));
        imageView.setOnMouseExited(e -> imageView.setImage(imgButton));

        vbox.getChildren().addAll(messageLabel, imageView);
        root.getChildren().add(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarPantallaConMapa(Inicializador partida) throws FileNotFoundException {

        StackPane root = new StackPane();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        root.getChildren().add(gridPane);

        InputStream imageStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/background_playing.png");
        Image backgroundImage = new Image(imageStream);
        BackgroundImage background = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false)
        );
        root.setBackground(new Background(background));
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, height, width);

        int cantidadDeFilas = partida.obtenerJuego().obtenerMapa().obtenerCantidadDeFilas();
        int cantidadDeColumnas = partida.obtenerJuego().obtenerMapa().obtenerCantidadDeColumnas();

        Juego juego = partida.obtenerJuego();
        JuegoController juegoController = new JuegoController(juego);

        for(int fila = 1; fila <= cantidadDeFilas; fila++) {
            for(int columna = 1; columna <= cantidadDeColumnas; columna++) {
                Parcela parcela = partida.obtenerJuego().obtenerMapa().obtenerCelda(new Coordenadas(fila, columna));
                VistaParcela vista = new VistaParcela(parcela, medidaCelda, juego, juegoController);
                juegoController.agregarObservable(parcela, vista);
                gridPane.add(vista, columna - 1, fila - 1);
            }
        }

        InputStream imgBtnStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/next_round.png");
        Image imgButton = new Image(imgBtnStream);

        InputStream hoverImgBtnStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/next_round_hover.png");
        Image hoverImgButton = new Image(hoverImgBtnStream);

        InputStream imgEndGameStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/game_over.png");
        Image imgEndGame = new Image(imgEndGameStream);

        ImageView imageView = new ImageView(imgButton);
        imageView.setFitWidth(110);
        imageView.setFitHeight(30);
        imageView.setTranslateX(5);
        imageView.setOnMouseClicked(e -> {
            playSound(BUTTON_NEXT_SOUND_FILE_PATH, 0.5f, null);
            if(!juegoController.avanzarTurno()){
                mostrarDialogFinDeJuego(partida);
                ImageView imageViewEndGame = new ImageView(imgEndGame);
                imageViewEndGame.setFitWidth(200);
                imageViewEndGame.setFitHeight(75);
                root.getChildren().add(imageViewEndGame);
                root.setDisable(true);
            }
        });
        imageView.setOnMouseEntered(e -> imageView.setImage(hoverImgButton));
        imageView.setOnMouseExited(e -> imageView.setImage(imgButton));
        gridPane.add(imageView, cantidadDeColumnas, cantidadDeFilas - 1);

        Rectangle torreBlancaRect = new Rectangle(medidaCelda, medidaCelda);
        torreBlancaRect.setStroke(Color.BLACK);
        torreBlancaRect.setStrokeWidth(1);
        InputStream torreBlanca = new FileInputStream(TORRE_BLANCA);
        Image torreBlancaImg = new Image(torreBlanca);
        ImagePattern torreBlancaIP = new ImagePattern(torreBlancaImg);

        torreBlancaRect.setFill(torreBlancaIP);
        gridPane.add(torreBlancaRect, cantidadDeColumnas, cantidadDeFilas - 2);

        torreBlancaRect.setOnMouseClicked(e -> playSound(CLICK_DEFENSE_SOUND_FILE_PATH, 1.1f, null) );
        torreBlancaRect.setOnDragDetected((MouseEvent event) -> {
            Dragboard db = torreBlancaRect.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString("torre blanca");
            db.setContent(content);
            playSound(CLICK_DEFENSE_BUILDING_SOUND_FILE_PATH, 1.1f, null);
        });
        torreBlancaRect.setOnMouseDragged((MouseEvent event) -> {
            event.setDragDetect(true);
        });

        playBackground(START_GAME_MUSIC_FILE_PATH, 0.4f);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void mostrarDialogFinDeJuego(Inicializador partida){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if(partida.obtenerJuego().juegoTerminado() && partida.obtenerJuego().obtenerJugador().estaVivo()) {
            alert.setTitle("GANASTE LA PARTIDA!");
            alert.setHeaderText(null);
            alert.setContentText("GANASTE!");
        } else if(partida.obtenerJuego().juegoTerminado() && !partida.obtenerJuego().obtenerJugador().estaVivo() ){
            alert.setTitle("PERDISTE LA PARTIDA!");
            alert.setHeaderText(null);
            alert.setContentText("Game over");
        }
        alert.showAndWait();
    }
    private void playBackground(String url, float volume) {
        try {
            stopSound(backgroundClip);
            backgroundClip = AudioSystem.getClip();
            playSound(url, volume, backgroundClip );
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}