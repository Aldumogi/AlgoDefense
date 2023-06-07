package edu.fiuba.algo3;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Mapa {
    private List<List<String>> mapa;
    private int alto;
    private int ancho;


    public Mapa() throws IOException, ParseException {
        this.mapaDelJuego = LoaderMapaJuego.recuperarMapa();
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
    
        String posActual = this.mapa.get(filaActual).get(columnaActual);
        if (posActual.equals("PasarelaLargada")) {
            return false;
        }
        if (posActual.equals("PasarelaMeta")) {
            return true;
        }
        coordenadasVisitadas.add(coordenadaAVerificar);
        private Map<Integer, HashMap<Integer, Parcela>> mapaDelJuego;


        if (filaActual + 1 < this.alto) {
            String posArriba = this.mapa.get(filaActual + 1).get(columnaActual);
            Coordenadas nuevaCoordenada = new Coordenadas(filaActual + 1, columnaActual);
            if ((posArriba.equals("PasarelaLargada") || posArriba.equals("Pasarela") || posArriba.equals("PasarelaMeta"))
                    && !(coordenadasVisitadas.contains(nuevaCoordenada))) {
                return esPorAca(nuevaCoordenada, coordenadasVisitadas);
            }
        }
        if ((filaActual - 1) >= 0) {
            String posAbajo = this.mapa.get(filaActual - 1).get(columnaActual);
            Coordenadas nuevaCoordenada = new Coordenadas(filaActual - 1, columnaActual);
            if ((posAbajo.equals("PasarelaLargada") || posAbajo.equals("Pasarela") || posAbajo.equals("PasarelaMeta"))
                    && !(coordenadasVisitadas.contains(nuevaCoordenada))) {
                return esPorAca(nuevaCoordenada, coordenadasVisitadas);
            }
        }
        if ((columnaActual - 1) >= 0) {
            String posIzquierda = this.mapa.get(filaActual).get(columnaActual - 1);
            Coordenadas nuevaCoordenada = new Coordenadas(filaActual, columnaActual - 1);
            if ((posIzquierda.equals("PasarelaLargada") || posIzquierda.equals("Pasarela") || posIzquierda.equals("PasarelaMeta"))
                    && !(coordenadasVisitadas.contains(nuevaCoordenada))) {
                return esPorAca(nuevaCoordenada, coordenadasVisitadas);
            }
        }
        if ((columnaActual + 1) < this.ancho) {
            String posDerecha = this.mapa.get(filaActual).get(columnaActual + 1);
            Coordenadas nuevaCoordenada = new Coordenadas(filaActual, columnaActual + 1);
            if ((posDerecha.equals("PasarelaLargada") || posDerecha.equals("Pasarela") || posDerecha.equals("PasarelaMeta"))
                    && !(coordenadasVisitadas.contains(nuevaCoordenada))) {
                return esPorAca(nuevaCoordenada, coordenadasVisitadas);
            }
        }
        return false;
    }

    public Coordenadas devolverSiguientePasarela(Coordenadas cordenadaActual){

        int fila = cordenadaActual.fila();
        int columna = cordenadaActual.columna();
        String tipoDeTerreno = this.mapa.get(fila).get(columna);

        if(tipoDeTerreno.equals( "PasarelaMeta")){
            return cordenadaActual;
        }

        List<Coordenadas> visitados = new ArrayList<>();
        visitados.add(cordenadaActual);

        if((columna + 1) < this.ancho && tipoDeTerreno.equals( "Pasarela")){
            Coordenadas posibleCordenada = new Coordenadas(fila, columna +1 );
            if(this.esPorAca(posibleCordenada, visitados)){
                return posibleCordenada;
            }
        }

        if((columna - 1) >= 0 && tipoDeTerreno.equals( "Pasarela")){
            Coordenadas posibleCordenada = new Coordenadas(fila, columna - 1);
            if(this.esPorAca(posibleCordenada, visitados)){
                return posibleCordenada;
            }
        }
        if((fila - 1) >= 0 && tipoDeTerreno.equals("Pasarela")){
            Coordenadas posibleCordenada = new Coordenadas(fila  - 1, columna);
            if(this.esPorAca(posibleCordenada, visitados)){
                return posibleCordenada;
            }
        }
        if((fila +1) < this.alto && tipoDeTerreno.equals( "Pasarela")){
            Coordenadas posibleCordenada = new Coordenadas(fila + 1, columna);
            if(this.esPorAca(posibleCordenada, visitados)){
                return posibleCordenada;
            }
        }
        return cordenadaActual;
    }
    public int obtenerCantidadDeColumnas() {
        return this.mapaDelJuego.get(1).size();
    }
}
    



