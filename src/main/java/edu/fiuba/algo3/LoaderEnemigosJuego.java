package edu.fiuba.algo3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoaderEnemigosJuego {

    public static ArrayList<Turno> recuperarTurnosYEnemigos() throws IOException, ParseException {

        String filePath = "C:\\Users\\Aldu\\Documents\\FIUBA\\Algoritmos y Programacion III\\TP2\\AlgoDefense\\src\\main\\java\\edu\\fiuba\\algo3\\resources\\enemigos.json"; // Replace with the actual file path
        String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONArray jsonArray = (JSONArray) new JSONParser().parse(jsonString);

        ArrayList<Turno> turnos = new ArrayList<>();

        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;

            int turnoId = Integer.parseInt(jsonObject.get("turno").toString());
            JSONObject enemigos = (JSONObject) jsonObject.get("enemigos");
            int cantidadHormigas = Integer.parseInt(enemigos.get("hormiga").toString());
            int cantidadAranas = Integer.parseInt(enemigos.get("araña").toString());

            Turno turno = new Turno (turnoId);
            turno.agregarEnemigos(cantidadHormigas, cantidadAranas);
            turnos.add(turno);
        }
        return turnos;
    }
}
