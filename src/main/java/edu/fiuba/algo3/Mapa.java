package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.FormatoMapaInvalidoException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    //recibe una cordenada y chequea, que para ese lado este la meta. 
    //Tambien recibe una lista, que contenga la posicion actual del enemigo

    public boolean esPorAca(Coordenadas coordenadaAVerificar, List<Coordenadas> coordenadasVisitadas) {
        int filaActual = coordenadaAVerificar.fila();
        int columnaActual = coordenadaAVerificar.columna();
    
        Parcela celdaActual = this.obtenerCelda(coordenadaAVerificar);

        if (celdaActual.equals(new PasarelaLargada(coordenadaAVerificar))) {
            return false;
        }
        if (celdaActual.equals(new PasarelaMeta(coordenadaAVerificar))) {
            return true;
        }
        coordenadasVisitadas.add(coordenadaAVerificar);

        if (filaActual + 1 <= this.obtenerCantidadDeFilas()) {
            Coordenadas nuevaCoordenada = new Coordenadas(filaActual + 1, columnaActual);
            Parcela posArriba = this.obtenerCelda(nuevaCoordenada);
            if ((posArriba.equals(new PasarelaLargada(nuevaCoordenada)) || posArriba.equals(new Pasarela(nuevaCoordenada)) || posArriba.equals(new PasarelaMeta(nuevaCoordenada)))
                    && !(coordenadasVisitadas.contains(nuevaCoordenada))) {
                return esPorAca(nuevaCoordenada, coordenadasVisitadas);
            }
        }
        if ((filaActual - 1) > 0) {
            Coordenadas nuevaCoordenada = new Coordenadas(filaActual - 1, columnaActual);
            Parcela posAbajo = this.obtenerCelda(nuevaCoordenada);
            if ((posAbajo.equals(new PasarelaLargada(nuevaCoordenada)) || posAbajo.equals(new Pasarela(nuevaCoordenada)) || posAbajo.equals(new PasarelaMeta(nuevaCoordenada)))
                    && !(coordenadasVisitadas.contains(nuevaCoordenada))) {
                return esPorAca(nuevaCoordenada, coordenadasVisitadas);
            }
        }
        if ((columnaActual - 1) > 0) {
            Coordenadas nuevaCoordenada = new Coordenadas(filaActual, columnaActual - 1);
            Parcela posIzquierda = this.obtenerCelda(nuevaCoordenada);
            if ((posIzquierda.equals(new PasarelaLargada(nuevaCoordenada)) || posIzquierda.equals(new Pasarela(nuevaCoordenada)) || posIzquierda.equals(new PasarelaMeta(nuevaCoordenada)))
                    && !(coordenadasVisitadas.contains(nuevaCoordenada))) {
                return esPorAca(nuevaCoordenada, coordenadasVisitadas);
            }
        }
        if ((columnaActual + 1) <= this.obtenerCantidadDeColumnas()) {
            Coordenadas nuevaCoordenada = new Coordenadas(filaActual, columnaActual + 1);
            Parcela posDerecha = this.obtenerCelda(nuevaCoordenada);
            if ((posDerecha.equals(new PasarelaLargada(nuevaCoordenada)) || posDerecha.equals(new Pasarela(nuevaCoordenada)) || posDerecha.equals(new PasarelaMeta(nuevaCoordenada)))
                    && !(coordenadasVisitadas.contains(nuevaCoordenada))) {
                return esPorAca(nuevaCoordenada, coordenadasVisitadas);
            }
        }
        return false;
    }

    public Coordenadas devolverSiguientePasarela_(Coordenadas cordenadaActual){

        int fila = cordenadaActual.fila();
        int columna = cordenadaActual.columna();
        Parcela celdaActual = this.obtenerCelda(cordenadaActual);

        if(celdaActual.equals(new PasarelaMeta(cordenadaActual))){
            return cordenadaActual;
        }

        List<Coordenadas> visitados = new ArrayList<>();
        visitados.add(cordenadaActual);

        if((columna + 1) <= this.obtenerCantidadDeColumnas() && celdaActual.equals(new Pasarela(cordenadaActual))){
            Coordenadas posibleCordenada = new Coordenadas(fila, columna +1 );
            if(this.esPorAca(posibleCordenada, visitados)){
                return posibleCordenada;
            }
        }

        if((columna - 1) >= 0 && celdaActual.equals(new Pasarela(cordenadaActual))){
            Coordenadas posibleCordenada = new Coordenadas(fila, columna - 1);
            if(this.esPorAca(posibleCordenada, visitados)){
                return posibleCordenada;
            }
        }
        if((fila - 1) >= 0 && celdaActual.equals(new Pasarela(cordenadaActual))){
            Coordenadas posibleCordenada = new Coordenadas(fila  - 1, columna);
            if(this.esPorAca(posibleCordenada, visitados)){
                return posibleCordenada;
            }
        }
        if((fila +1) < this.obtenerCantidadDeFilas() && celdaActual.equals( new Pasarela(cordenadaActual))){
            Coordenadas posibleCordenada = new Coordenadas(fila + 1, columna);
            if(this.esPorAca(posibleCordenada, visitados)){
                return posibleCordenada;
            }
        }
        return cordenadaActual;
    }
    public Coordenadas devolverSiguientePasarela(Coordenadas cordenadaActual, int cantidadDeMovimientos){
        for(int i = 0; i < cantidadDeMovimientos; i ++ ){
            cordenadaActual = devolverSiguientePasarela_(cordenadaActual);
        }
        return cordenadaActual;
    };
    public int obtenerCantidadDeColumnas() {
        return this.mapaDelJuego.get(1).size();
    }

    public Coordenadas getCoordenadasMeta() {
        return new Coordenadas(5,2);
    }
}
    



