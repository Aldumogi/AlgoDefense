package edu.fiuba.algo3;

import edu.fiuba.algo3.controller.JuegoController;
import edu.fiuba.algo3.modelo.exceptions.FormatoEnemigosInvalidoException;
import edu.fiuba.algo3.modelo.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.modelo.juego.Inicializador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.parcela.*;
import edu.fiuba.algo3.view.VistaParcela;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class App extends Application {

    private Stage primaryStage;
    static String MAP_RELATIVE_PATH = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
    static String ENEMIGOS_RELATIVE_PATH = "src/main/test/edu/fiuba/algo3/resources/enemigos.json";
    private double medidaCelda = 30;
    private double height = 680, width = 520;

    @Override
    public void start(Stage primaryStage) throws IOException, ParseException, FormatoMapaInvalidoException, FormatoEnemigosInvalidoException {
        Inicializador partida = new Inicializador(ENEMIGOS_RELATIVE_PATH, MAP_RELATIVE_PATH);
        this.primaryStage = primaryStage;
        primaryStage.setTitle("AlgoDefense");

        StackPane root = new StackPane();

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

        InputStream imgBtnStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/button_add_player.png");
        Image imgButton = new Image(imgBtnStream);

        InputStream hoverImgBtnStream = new FileInputStream("src/main/java/edu/fiuba/algo3/view/images/button_add_player_2.png");
        Image hoverImgButton = new Image(hoverImgBtnStream);

        ImageView imageView = new ImageView(imgButton);
        imageView.setFitWidth(200);
        imageView.setFitHeight(75);
        imageView.setTranslateY(75);
        imageView.setOnMouseClicked(e -> mostrarDialogoIngresarNombre(partida));
        imageView.setOnMouseEntered(e -> imageView.setImage(hoverImgButton));
        imageView.setOnMouseExited(e -> imageView.setImage(imgButton));

        root.getChildren().add(imageView);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarDialogoIngresarNombre(Inicializador partida) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Ingresar Nombre");
        dialog.setHeaderText("Por favor ingrese su nombre de usuario");
        dialog.setContentText("Nombre:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
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

    private void mostrarPantallaIniciarPartida(Inicializador partida) {
        StackPane root = new StackPane();
        root.setPadding(new Insets(20));
        root.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, null, null)));
        Scene scene = new Scene(root, height, width);

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        Label messageLabel = new Label("¡Bienvenido, " + partida.obtenerJuego().obtenerJugador().obtenerNombre() + "!");
        messageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        Button iniciarPartidaButton = new Button("Iniciar Partida");
        iniciarPartidaButton.setOnAction(e -> mostrarPantallaConMapa(partida));
        vbox.getChildren().addAll(iniciarPartidaButton, messageLabel);
        root.getChildren().add(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void mostrarPantallaConMapa(Inicializador partida) {
        GridPane root = new GridPane();
        Scene scene = new Scene(root, height, width);

        int cantidadDeFilas = partida.obtenerJuego().obtenerMapa().obtenerCantidadDeFilas();
        int cantidadDeColumnas = partida.obtenerJuego().obtenerMapa().obtenerCantidadDeColumnas();

        Juego juego = partida.obtenerJuego();
        JuegoController juegoController = new JuegoController(juego);

        for(int fila = 1; fila <= cantidadDeFilas; fila++) {
            for(int columna = 1; columna <= cantidadDeColumnas; columna++) {
                Parcela parcela = partida.obtenerJuego().obtenerMapa().obtenerCelda(new Coordenadas(fila, columna));
                VistaParcela vista = new VistaParcela(parcela, medidaCelda);
                juegoController.agregarObservable(parcela, vista);
                root.add(vista, columna - 1, fila - 1);
            }
        }

        double offsetX = (scene.getWidth() - (cantidadDeColumnas * medidaCelda)) / 2;
        double offsetY = (scene.getHeight() - (cantidadDeFilas * medidaCelda)) / 2;

        root.setTranslateX(offsetX);
        root.setTranslateY(offsetY);

        Button avanzarTurno = new Button("Avanzar Turno");
        avanzarTurno.setOnAction(e -> juegoController.avanzarTurno());

        root.add(avanzarTurno, cantidadDeColumnas, cantidadDeFilas - 1);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}