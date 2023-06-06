package edu.fiuba.algo3;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoaderMapaJuego {

    public static Map<Integer, ArrayList<Parcela>> recuperarMapa() throws IOException, ParseException {
        String filePath = "src/main/java/edu/fiuba/algo3/resources/mapa.json";
        validarMapa(filePath);
        String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonString);

        Map<Integer, ArrayList<Parcela>> mapa = new HashMap<>();
        Map<String, ArrayList<String>> mapaDelArchivo =
                (Map<String, ArrayList<String>>) jsonObject.get("Mapa");

        for (String fila : mapaDelArchivo.keySet()) {
            ArrayList<String> columnas = mapaDelArchivo.get(fila);
            ArrayList<Parcela> parcelaArrayList = new ArrayList<>();

            for (int columna = 0; columna < columnas.size(); columna++) {
                Coordenadas coordenada = new Coordenadas(Integer.parseInt(fila), columna);
                String nombreParcela = columnas.get(columna);
                Parcela parcela;
                switch (nombreParcela) {
                    case ("Rocoso"):
                        parcela = new Rocoso(coordenada);
                        break;
                    case ("Pasarela"):
                        parcela = new Pasarela(coordenada);
                        break;
                    case ("Tierra"):
                        parcela = new Tierra(coordenada);
                        break;
                    case ("Largada"):
                        parcela = new PasarelaLargada(coordenada);
                        break;
                    case ("Meta"):
                        parcela = new PasarelaMeta(coordenada);
                        break;
                    default:
                        parcela = null;
                }
                parcelaArrayList.add(parcela);
            }
            mapa.put(Integer.parseInt(fila), parcelaArrayList);
        }
        return mapa;
    }
    public static void validarMapa(String filePath) {
        String JsonSchemaPath = "src/main/java/edu/fiuba/algo3/resources/schemas/mapaSchema.json";
        JsonValidator.validarJsonConSchema(filePath, JsonSchemaPath);
    }
}
