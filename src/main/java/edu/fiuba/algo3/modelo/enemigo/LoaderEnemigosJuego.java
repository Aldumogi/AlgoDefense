package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.exceptions.FormatoEnemigosInvalidoException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.utils.JsonValidator;
import edu.fiuba.algo3.modelo.juego.Turno;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class LoaderEnemigosJuego {

    public static ArrayList<Turno> recuperarTurnosYEnemigos(String filePath, Coordenadas coordenadasLargada) throws IOException, ParseException, FormatoEnemigosInvalidoException {
        validarJsonEnemigos(filePath);
        String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONArray jsonArray = (JSONArray) new JSONParser().parse(jsonString);

        ArrayList<Turno> turnos = new ArrayList<>();

        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;

            Integer turnoId = Integer.parseInt(jsonObject.get("turno").toString());
            JSONObject enemigos = (JSONObject) jsonObject.get("enemigos");
            Integer cantidadHormigas = Integer.parseInt(enemigos.get("hormiga").toString());
            Integer cantidadAranas = Integer.parseInt(enemigos.get("arana").toString());

            Turno turno = new Turno (turnoId);
            turno.agregarEnemigos(cantidadHormigas, cantidadAranas, coordenadasLargada);
            turnos.add(turno);
        }

        logger.info("Lectura y carga del archivo de enemigos");
        return turnos;
    }

    public static void validarJsonEnemigos(String filePath) throws FormatoEnemigosInvalidoException {
        try {
            String JsonSchemaPath = "src/main/java/edu/fiuba/algo3/resources/schemas/enemigosSchema.json";
            JsonValidator.validarJsonConSchema(filePath, JsonSchemaPath);
        } catch (Exception e) {
            throw new FormatoEnemigosInvalidoException();
        }
    }
}
