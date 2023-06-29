package edu.fiuba.algo3;

import edu.fiuba.algo3.controller.JuegoController;
import edu.fiuba.algo3.modelo.exceptions.FormatoEnemigosInvalidoException;
import edu.fiuba.algo3.modelo.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.modelo.juego.Inicializador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.parcela.*;
import edu.fiuba.algo3.view.PanelDeConstruccion;
import edu.fiuba.algo3.view.VistaParcela;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(165,0,0,0));

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
        imageView.setTranslateY(30);
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


        InputStream imgBtnAboutStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/acerca_de_btn.png");
        Image imgButtonAbout = new Image(imgBtnAboutStream);

        InputStream hoverimgBtnAboutStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/acerca_de_btn_hover.png");
        Image hoverimgButtonAbout = new Image(hoverimgBtnAboutStream);

        ImageView imageViewAbout = new ImageView(imgButtonAbout);
        imageViewAbout.setFitWidth(200);
        imageViewAbout.setFitHeight(75);
        imageViewAbout.setTranslateY(30);
        imageViewAbout.setOnMouseClicked(e -> {
            playSound(BUTTON_SOUND_FILE_PATH, 1.1f, null);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Acerca de");
            alert.setHeaderText("AlgoDefense es un juego desarrollado en Java (11.0.19) y Javafx (15.0.1) por:");
            alert.setContentText("- Diego Di Grazia\n" + //
                    "- Nazarian Juan Martin\n" + //
                    "- Avalo Alejandro Valentin\n" + //
                    "- Joaquin Miranda Iglesias\n" + //
                    "- Aldana Mogilewski");
            alert.showAndWait();
        });
        imageViewAbout.setOnMouseEntered(e -> imageViewAbout.setImage(hoverimgButtonAbout));
        imageViewAbout.setOnMouseExited(e -> imageViewAbout.setImage(imgButtonAbout));


        InputStream imgBtnHowToPlayStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/como_jugar_btn.png");
        Image imageHowToPlay = new Image(imgBtnHowToPlayStream);

        InputStream hoverimgBtnHowToPlayStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/como_jugar_btn_hover.png");
        Image hoverimageHowToPlay = new Image(hoverimgBtnHowToPlayStream);

        ImageView imageViewHowToPlay = new ImageView(imageHowToPlay);
        imageViewHowToPlay.setFitWidth(200);
        imageViewHowToPlay.setFitHeight(75);
        imageViewHowToPlay.setTranslateY(30);
        imageViewHowToPlay.setOnMouseClicked(e -> {
            playSound(BUTTON_SOUND_FILE_PATH, 1.1f, null);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.getDialogPane().setMinWidth(500);
            alert.setTitle("Como Juagar");
            alert.setHeaderText("Instrucciones de AlgoDefense");
            alert.setContentText("- Para construir defensas arrastrar la defensa deseada desde el panel de la derecha hacia la parcela donde la queremos construir. La construccion de defensas consume creditos del jugador.\n\n- Para pasar de turno presionar el bóton \"Avanzar Turno\".\n\n- Los enemigos se desplegarán desde la parcela de largada y se dirigirán hacia la parcela de llegada. Cada vez que un enemigo llegue a la parcela de llegada, la energia del jugador disminuirá una cantidad que dependerá del enemigo.\n\n- Los numeros en las parcelas representa la cantidad de enemigos que estan actualmente en ella. Al hacer click en ella, podemos ver el detalle de los enemigos.\n\n- Los enemigos se desplazan por las parcelas excepto la lechuza.\n\n- Los topos no se pueden matar porque se desplazan por debajo de la tierra.\n\n- La lechuza al llegar a la parcela meta destruye una torre.");
            alert.showAndWait();
        });
        imageViewHowToPlay.setOnMouseEntered(e -> imageViewHowToPlay.setImage(hoverimageHowToPlay));
        imageViewHowToPlay.setOnMouseExited(e -> imageViewHowToPlay.setImage(imageHowToPlay));

        vbox.getChildren().addAll(messageLabel, imageView, imageViewAbout, imageViewHowToPlay);
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

        ImageView imageView = new ImageView(imgButton);
        imageView.setFitWidth(110);
        imageView.setFitHeight(30);
        imageView.setTranslateX(5);
        imageView.setOnMouseClicked(e -> {
            playSound(BUTTON_NEXT_SOUND_FILE_PATH, 0.5f, null);
            if(!juegoController.avanzarTurno()){
                mostrarDialogFinDeJuego(partida);
            }
        });
        imageView.setOnMouseEntered(e -> imageView.setImage(hoverImgButton));
        imageView.setOnMouseExited(e -> imageView.setImage(imgButton));

        PanelDeConstruccion panelDeConstruccion = new PanelDeConstruccion();
        GridPane panel =  panelDeConstruccion.generarPanel(medidaCelda);
        gridPane.add(panel, cantidadDeColumnas, cantidadDeFilas/2);


        gridPane.add(imageView, cantidadDeColumnas, cantidadDeFilas - 1);
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