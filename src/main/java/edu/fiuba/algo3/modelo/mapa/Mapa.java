package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.exceptions.FormatoMapaInvalidoException;
import edu.fiuba.algo3.exceptions.NoEsPosibleRecibirEnemigosEnParcelaException;
import edu.fiuba.algo3.exceptions.NoSePudoBorrarElEnemigoException;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.parcela.Parcela;
import edu.fiuba.algo3.modelo.parcela.Pasarela;
import edu.fiuba.algo3.modelo.parcela.PasarelaLargada;
import edu.fiuba.algo3.modelo.parcela.PasarelaMeta;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapa {

    private Map<Integer, HashMap<Integer, Parcela>> mapaDelJuego;
    private Coordenadas coordenadasLargada;
    private Coordenadas coordenadasMeta;

    public Mapa() throws IOException, ParseException, FormatoMapaInvalidoException {
        this.mapaDelJuego = LoaderMapaJuego.recuperarMapa("src/main/java/edu/fiuba/algo3/resources/mapa.json");
        this.buscarCoordenadasLargadaYMeta();
    }
    public Mapa(String jsonFilePath) throws IOException, ParseException, FormatoMapaInvalidoException {
        this.mapaDelJuego = LoaderMapaJuego.recuperarMapa(jsonFilePath);
        this.buscarCoordenadasLargadaYMeta();
    }
    private void buscarCoordenadasLargadaYMeta() {
        for ( int fila = 1 ; fila <= this.mapaDelJuego.size() ; fila++ ) {
            for ( int columna = 1 ; columna <= this.mapaDelJuego.get(fila).size() ; columna++ ) {
                Coordenadas coord = new Coordenadas(fila, columna);
                Parcela parcela = this.mapaDelJuego.get(fila).get(columna);
                if ( parcela.equals( new PasarelaMeta( coord ) ) ) {
                    this.coordenadasMeta = coord;
                }
                if ( parcela.equals( new PasarelaLargada( coord ) ) ) {
                    this.coordenadasLargada = coord;
                }
            }
        }
    }
    public Parcela obtenerCelda(Coordenadas coordenada) {
        return this.mapaDelJuego.get(coordenada.obtenerFila()).get(coordenada.obtenerColumna());
    }

    public int obtenerCantidadDeFilas() {
        return this.mapaDelJuego.size();
    }
    /* En el futuro puede agregar otra cosas si se desea, no solo enemigo */
    public void recibir(Coordenadas coordenadas, Enemigo enemigo) {
        if ( enemigo != null ) {
            for (int fila = 1 ; fila <= this.mapaDelJuego.size() ; fila ++ ) {
                for (int columna = 1 ; columna <= this.mapaDelJuego.get(fila).size() ; columna ++ ) {
                    try {
                        this.mapaDelJuego.get(fila).get(columna).recibir(enemigo);
                    }
                    catch(NoEsPosibleRecibirEnemigosEnParcelaException e){
                    }
                }
            }
        }
    }

    public void borrar(Enemigo enemigo) throws NoSePudoBorrarElEnemigoException {
        Coordenadas coordenadas = enemigo.obtenerCoordenadas();
        this.mapaDelJuego.get(coordenadas.fila()).get(coordenadas.columna()).borrarObjeto(enemigo);
    }

    //recibe una cordenada y chequea, que para ese lado este la meta. 
    //Tambien recibe una lista, que contenga la posicion actual del enemigo

    public boolean esPorAca(Coordenadas coordenadaAVerificar, List<Coordenadas> coordenadasVisitadas) {
        int filaActual = coordenadaAVerificar.fila();
        int columnaActual = coordenadaAVerificar.columna();
    
        Parcela celdaActual = this.obtenerCelda(coordenadaAVerificar);
    
        if ( coordenadaAVerificar.equals( this.coordenadasLargada ) ) {
            return false;
        }
        if ( coordenadaAVerificar.equals( this.coordenadasMeta ) ) {
            return true;
        }
        if (!celdaActual.equals(new Pasarela(coordenadaAVerificar))) {
            return false;
        }
        coordenadasVisitadas.add(coordenadaAVerificar);
    
        return buscarSiguienteCoordenada(new Coordenadas(filaActual + 1, columnaActual), coordenadasVisitadas) ||
               buscarSiguienteCoordenada(new Coordenadas(filaActual - 1, columnaActual), coordenadasVisitadas) ||
               buscarSiguienteCoordenada(new Coordenadas(filaActual, columnaActual - 1), coordenadasVisitadas) ||
               buscarSiguienteCoordenada(new Coordenadas(filaActual, columnaActual + 1), coordenadasVisitadas);
    }
    
    private boolean buscarSiguienteCoordenada(Coordenadas nuevaCoordenada, List<Coordenadas> coordenadasVisitadas) {
        if (nuevaCoordenada.fila() <= 0 || nuevaCoordenada.columna() <= 0 ){
            return false;
        }
        Parcela parcela = this.obtenerCelda(nuevaCoordenada);
        if (parcela != null) {
            boolean esPasarelaValida = parcela.equals(new PasarelaLargada(nuevaCoordenada))
                                    || parcela.equals(new Pasarela(nuevaCoordenada))
                                    || parcela.equals(new PasarelaMeta(nuevaCoordenada));
    
            if (esPasarelaValida && !(coordenadasVisitadas.contains(nuevaCoordenada))) {
                return esPorAca(nuevaCoordenada, coordenadasVisitadas);
            }
        }
        return false;
    }

    public Coordenadas devolverSiguientePasarela_(Coordenadas cordenadaActual){

        int fila = cordenadaActual.fila();
        int columna = cordenadaActual.columna();
        //Parcela celdaActual = this.obtenerCelda(cordenadaActual);

        List<Coordenadas> visitados = new ArrayList<>();
        visitados.add(cordenadaActual);

        if((columna + 1) <= this.obtenerCantidadDeColumnas() ){
            Coordenadas posibleCordenada = new Coordenadas(fila, columna +1 );
            if(this.esPorAca(posibleCordenada, visitados)){
                return posibleCordenada;
            }
        }
    

        if((columna - 1) > 0){
            Coordenadas posibleCordenada = new Coordenadas(fila, columna - 1);
            if(this.esPorAca(posibleCordenada, visitados)){
                return posibleCordenada;
            }
        }
        if((fila - 1) > 0 ){
            Coordenadas posibleCordenada = new Coordenadas(fila  - 1, columna);
            if(this.esPorAca(posibleCordenada, visitados)){
                return posibleCordenada;
            }
        }
        if((fila +1) <= this.obtenerCantidadDeFilas()){
            Coordenadas posibleCordenada = new Coordenadas(fila + 1, columna);
            if(this.esPorAca(posibleCordenada, visitados)){
                return posibleCordenada;
            }
        }
        return cordenadaActual;
    }
    public Coordenadas devolverSiguientePasarela(Coordenadas cordenadaActual, double cantidadDeMovimientos){
        int cantidadDeMovs = (int) cantidadDeMovimientos;
        for(int i = 0; i < cantidadDeMovs; i ++ ){
            cordenadaActual = devolverSiguientePasarela_(cordenadaActual);
        }
        return cordenadaActual;
    };

    public int obtenerCantidadDeColumnas() {
        return this.mapaDelJuego.get(1).size();
    }

    public Coordenadas getCoordenadasMeta() {
        return this.coordenadasMeta;
    }
    public Coordenadas getCoordenadasLargada() {
        return this.coordenadasLargada;
    }
}
    



