package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.FormatoMapaInvalidoException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Mapa {
    private Map<Integer, HashMap<Integer, Parcela>> mapaDelJuego;

    public Mapa() throws IOException, ParseException, FormatoMapaInvalidoException {
        this.mapaDelJuego = LoaderMapaJuego.recuperarMapa(null);
    }
    public Mapa(String jsonFilePath) throws IOException, ParseException, FormatoMapaInvalidoException {
        this.mapaDelJuego = LoaderMapaJuego.recuperarMapa(jsonFilePath);
    }
    public Parcela obtenerCelda(Coordenadas coordenada) {
        return this.mapaDelJuego.get(coordenada.obtenerFila()).get(coordenada.obtenerColumna());
    }

    public int obtenerCantidadDeFilas() {
        return this.mapaDelJuego.size();
    }

    public int obtenerCantidadDeColumnas() {
        return this.mapaDelJuego.get(1).size();
    }
}
