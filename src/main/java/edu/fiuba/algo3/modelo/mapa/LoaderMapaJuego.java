package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.modelo.utils.JsonValidator;
import edu.fiuba.algo3.modelo.parcela.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static edu.fiuba.algo3.modelo.juego.Inicializador.logger;

public class LoaderMapaJuego {

    public static Map<Integer, HashMap<Integer, Parcela>> recuperarMapa(String filePath ) throws IOException, ParseException, FormatoMapaInvalidoException {
        validarMapa(filePath);
        String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonString);

        Map<Integer, HashMap<Integer, Parcela>> mapa = new HashMap<>();
        Map<String, ArrayList<String>> mapaDelArchivo =
                (Map<String, ArrayList<String>>) jsonObject.get("Mapa");

        for (String fila : mapaDelArchivo.keySet()) {
            ArrayList<String> columnas = mapaDelArchivo.get(fila);
            HashMap<Integer, Parcela> parcelaHashMap = new HashMap<>();

            for (int indice = 0; indice < columnas.size(); indice++) {
                // Sumo 1 por la diferencia entre el indice del Array y la primer coordenada de columna
                int columna = indice + 1;
                String nombreParcela = columnas.get(indice);
                Coordenadas coordenada = new Coordenadas(Integer.parseInt(fila), columna);
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
                parcelaHashMap.put(columna, parcela);
            }
            mapa.put(Integer.parseInt(fila), parcelaHashMap);
        }

        logger.info("Lectura y carga del archivo del mapa");
        return mapa;
    }
    public static void validarMapa(String filePath) throws FormatoMapaInvalidoException {
        try {
            String JsonSchemaPath = "src/main/java/edu/fiuba/algo3/resources/schemas/mapaSchema.json";
            JsonValidator.validarJsonConSchema(filePath, JsonSchemaPath);
        } catch (Exception e) {
            throw new FormatoMapaInvalidoException();
        }
    }
}
