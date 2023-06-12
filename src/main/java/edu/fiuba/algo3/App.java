package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.modelo.juego.Inicializador;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Optional;

public class App extends Application {

    private Stage primaryStage;
    static String MAP_RELATIVE_PATH = "src/main/java/edu/fiuba/algo3/resources/mapa.json";

    @Override
    public void start(Stage primaryStage) throws IOException, ParseException, FormatoMapaInvalidoException, FormatoMapaInvalidoException {
        Inicializador partida = new Inicializador();
        this.primaryStage = primaryStage;
        primaryStage.setTitle("AlgoDefense");

        StackPane root = new StackPane();
        root.setPadding(new Insets(20));
        Scene scene = new Scene(root, 640, 480);

        Button agregarJugadorButton = new Button("Agregar Jugador");
        agregarJugadorButton.setOnAction(e -> mostrarDialogoIngresarNombre(partida));

        root.getChildren().add(agregarJugadorButton);

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
        Scene scene = new Scene(root, 640, 480);

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

        Label messageLabel = new Label("¡Bienvenido, " + partida.obtenerJuego().obtenerJugador().obtenerNombre() + "!");
        messageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));

        Button iniciarPartidaButton = new Button("Iniciar Partida");
        vbox.getChildren().addAll(iniciarPartidaButton, messageLabel);
        root.getChildren().add(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}