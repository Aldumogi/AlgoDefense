package edu.fiuba.algo3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static edu.fiuba.algo3.Inicializador.logger;

public class LoaderEnemigosJuego {

    public static ArrayList<Turno> recuperarTurnosYEnemigos() throws IOException, ParseException {

        String filePath = "src/main/java/edu/fiuba/algo3/resources/enemigos.json";
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
            turno.agregarEnemigos(cantidadHormigas, cantidadAranas);
            turnos.add(turno);
        }

        logger.info("Lectura y carga del archivo de enemigos");
        return turnos;
    }
}
