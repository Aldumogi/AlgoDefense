package edu.fiuba.algo3;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Mapa {
    private Map<Integer, ArrayList<Parcela>> mapaDelJuego;

    public Mapa() throws IOException, ParseException {
        this.mapaDelJuego = LoaderMapaJuego.recuperarMapa();
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
