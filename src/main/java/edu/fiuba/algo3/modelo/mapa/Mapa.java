package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.Torre;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.loaders.LoaderMapaJuego;
import edu.fiuba.algo3.modelo.parcela.*;
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
        this._buscarCoordenadasLargadaYMeta();
    }
    public Mapa(String jsonFilePath) throws IOException, ParseException, FormatoMapaInvalidoException {
        this.mapaDelJuego = LoaderMapaJuego.recuperarMapa(jsonFilePath);
        this._buscarCoordenadasLargadaYMeta();
    }
    private void _buscarCoordenadasLargadaYMeta() {
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

    public void recibir(Coordenadas coordenadas, Enemigo enemigo) {
        if ( enemigo != null ) {
            try {
                this.mapaDelJuego.get(coordenadas.obtenerFila()).get(coordenadas.obtenerColumna()).recibir(enemigo);
            }
            catch(NoEsPosibleRecibirEnemigosEnParcelaException e){
            }
        }
    }
    public void recibir(TrampaArenosa trampaArenosa) throws NoSePudoConstruirException {
        if ( trampaArenosa != null ) {
            Coordenadas coordenadas = trampaArenosa.obtenerCoordenadas();
            this.mapaDelJuego.get(coordenadas.obtenerFila()).get(coordenadas.obtenerColumna()).construir(trampaArenosa);
        }
    }
    public void recibir(Torre torre) throws NoSePudoConstruirException {
        if ( torre != null ) {
            Coordenadas coordenadas = torre.obtenerCoordenadas();
            this.mapaDelJuego.get(coordenadas.obtenerFila()).get(coordenadas.obtenerColumna()).construir(torre);
        }
    }
    public void borrar(Enemigo enemigo) throws NoSePudoBorrarElEnemigoException {
        Coordenadas coordenadas = enemigo.obtenerCoordenadas();
        this.mapaDelJuego.get(coordenadas.obtenerFila()).get(coordenadas.obtenerColumna()).borrarObjeto(enemigo);
    }
    public void borrar(Defensa defensa) {
        Coordenadas coordenadas = defensa.obtenerCoordenadas();
        this.mapaDelJuego.get(coordenadas.obtenerFila()).get(coordenadas.obtenerColumna()).borrarObjeto(defensa);
    }
    //recibe una coordenada y chequea, que para ese lado este la meta. 
    //Tambien recibe una lista, que contenga la posicion actual del enemigo

    public boolean esPorAca(Coordenadas coordenadaAVerificar, List<Coordenadas> coordenadasVisitadas) {
        int filaActual = coordenadaAVerificar.obtenerFila();
        int columnaActual = coordenadaAVerificar.obtenerColumna();
    
        Parcela celdaActual = this.obtenerCelda(coordenadaAVerificar);
    
        if ( coordenadaAVerificar.equals( this.coordenadasLargada ) ) {
            return false;
        }
        if ( coordenadaAVerificar.equals( this.coordenadasMeta ) ) {
            return true;
        }
        if (!celdaActual.equals(new PasarelaNormal(coordenadaAVerificar))) {
            return false;
        }
        coordenadasVisitadas.add(coordenadaAVerificar);
    
        return buscarSiguienteCoordenada(new Coordenadas(filaActual + 1, columnaActual), coordenadasVisitadas) ||
               buscarSiguienteCoordenada(new Coordenadas(filaActual - 1, columnaActual), coordenadasVisitadas) ||
               buscarSiguienteCoordenada(new Coordenadas(filaActual, columnaActual - 1), coordenadasVisitadas) ||
               buscarSiguienteCoordenada(new Coordenadas(filaActual, columnaActual + 1), coordenadasVisitadas);
    }
    
    private boolean buscarSiguienteCoordenada(Coordenadas nuevaCoordenada, List<Coordenadas> coordenadasVisitadas) {
        if (nuevaCoordenada.obtenerFila() <= 0 || nuevaCoordenada.obtenerColumna() <= 0 ){
            return false;
        }
        Parcela parcela = this.obtenerCelda(nuevaCoordenada);
        if (parcela != null) {
            boolean esPasarelaValida = parcela.equals(new PasarelaLargada(nuevaCoordenada))
                                    || parcela.equals(new PasarelaNormal(nuevaCoordenada))
                                    || parcela.equals(new PasarelaMeta(nuevaCoordenada));
    
            if (esPasarelaValida && !(coordenadasVisitadas.contains(nuevaCoordenada))) {
                return esPorAca(nuevaCoordenada, coordenadasVisitadas);
            }
        }
        return false;
    }

    public Coordenadas devolverSiguientePasarela_(Coordenadas coordenadaActual){

        int fila = coordenadaActual.obtenerFila();
        int columna = coordenadaActual.obtenerColumna();
        //Parcela celdaActual = this.obtenerCelda(coordenadaActual);

        List<Coordenadas> visitados = new ArrayList<>();
        visitados.add(coordenadaActual);

        if((columna + 1) <= this.obtenerCantidadDeColumnas() ){
            Coordenadas posiblecoordenada = new Coordenadas(fila, columna +1 );
            if(this.esPorAca(posiblecoordenada, visitados)){
                return posiblecoordenada;
            }
        }
    

        if((columna - 1) > 0){
            Coordenadas posiblecoordenada = new Coordenadas(fila, columna - 1);
            if(this.esPorAca(posiblecoordenada, visitados)){
                return posiblecoordenada;
            }
        }
        if((fila - 1) > 0 ){
            Coordenadas posiblecoordenada = new Coordenadas(fila  - 1, columna);
            if(this.esPorAca(posiblecoordenada, visitados)){
                return posiblecoordenada;
            }
        }
        if((fila +1) <= this.obtenerCantidadDeFilas()){
            Coordenadas posiblecoordenada = new Coordenadas(fila + 1, columna);
            if(this.esPorAca(posiblecoordenada, visitados)){
                return posiblecoordenada;
            }
        }
        return coordenadaActual;
    }
    public Coordenadas devolverSiguientePasarela(Coordenadas coordenadaActual, double cantidadDeMovimientos){
        int cantidadDeMovs = (int) cantidadDeMovimientos;
        for(int i = 0; i < cantidadDeMovs; i ++ ){
            coordenadaActual = devolverSiguientePasarela_(coordenadaActual);
        }
        return coordenadaActual;
    };
    public Coordenadas devolverSiguienteCoordenadaEnLineaRecta(Coordenadas coordenadaActual, double cantidadDeMovimientos){
        Coordenadas meta = this.getCoordenadasMeta();
        int columnaMeta = meta.obtenerColumna();
        int filaMeta = meta.obtenerFila();

        while(cantidadDeMovimientos != 0){
            if(columnaMeta > coordenadaActual.obtenerColumna()){
                coordenadaActual = new Coordenadas(coordenadaActual.obtenerFila(), coordenadaActual.obtenerColumna() + 1);
            }else if(columnaMeta < coordenadaActual.obtenerColumna()){
                coordenadaActual = new Coordenadas(coordenadaActual.obtenerFila(), coordenadaActual.obtenerColumna() - 1);   
            }else if(filaMeta > coordenadaActual.obtenerFila()){
                coordenadaActual = new Coordenadas(coordenadaActual.obtenerFila() + 1, coordenadaActual.obtenerColumna());   
            }else if(filaMeta < coordenadaActual.obtenerFila()){
                coordenadaActual = new Coordenadas(coordenadaActual.obtenerFila() - 1, coordenadaActual.obtenerColumna());   
            }
            cantidadDeMovimientos -= 1;
            if (meta.equals(coordenadaActual)){
                return coordenadaActual;
            }
        }
        return coordenadaActual;
        
    }
    public Coordenadas devolverSiguienteCoordenadaUsandoDiagonalesMasCercanaALaMeta(Coordenadas coordenadaActual){
        Coordenadas meta = this.getCoordenadasMeta();
        int columnaMeta = meta.obtenerColumna();
        int filaMeta = meta.obtenerFila();
        int filaActual = coordenadaActual.obtenerFila();
        int columnaActual = coordenadaActual.obtenerColumna();
        if (columnaMeta == columnaActual || filaMeta == filaActual){
            return devolverSiguienteCoordenadaEnLineaRecta(coordenadaActual, 1);
        }
        if(columnaMeta > columnaActual && filaMeta > filaActual ){
            coordenadaActual = new Coordenadas(filaActual + 1, columnaActual + 1);
        }else if(columnaMeta < columnaActual && filaMeta < filaActual ){
            coordenadaActual = new Coordenadas(filaActual - 1, columnaActual - 1); 

        }else if(columnaMeta > columnaActual && filaMeta < filaActual ){
            coordenadaActual = new Coordenadas(filaActual - 1, columnaActual + 1); 
        }else if(columnaMeta < columnaActual && filaMeta > filaActual ){
            coordenadaActual = new Coordenadas(filaActual + 1, columnaActual - 1); 
        }
        return coordenadaActual;
    }

    public Coordenadas devolverSiguientesNCoordenadaUsandoDiagonalesMasCercanaALaMeta(Coordenadas coordenadaActual, int cantidadDeMovimientos){
        for(int i = 0; i < cantidadDeMovimientos; i++){
            coordenadaActual = devolverSiguienteCoordenadaUsandoDiagonalesMasCercanaALaMeta(coordenadaActual);
        }
        return coordenadaActual;
    }

    public Coordenadas devolverSiguienteCoordenadaEnL(Coordenadas coordenadaActual, int cantidadDeMovimientos){
        Coordenadas meta = this.getCoordenadasMeta();
        int columnaMeta = meta.obtenerColumna();
        int filaMeta = meta.obtenerFila();
        int filaActual = coordenadaActual.obtenerFila();
        int columnaActual = coordenadaActual.obtenerColumna();
        if (columnaMeta == columnaActual || filaMeta == filaActual){
            return devolverSiguienteCoordenadaEnLineaRecta(coordenadaActual, 1);
        }
        for(int i = 2; i < 5 ; i ++){
            if(columnaActual < columnaMeta){
                columnaActual += 1;
                cantidadDeMovimientos --;
            }
            else if(columnaActual > columnaMeta){
                columnaActual -= 1;
                cantidadDeMovimientos --;
            }
        }
        for(int i =0 ; i <= cantidadDeMovimientos ; i = 1){
            if(filaActual < filaMeta){
                filaActual += 1;
                }
            if(filaActual > filaMeta){
                filaActual -= 1;
                }
            cantidadDeMovimientos --;
        }  
        return (new Coordenadas(filaActual, columnaActual));
    }


    public int obtenerCantidadDeColumnas() {
        return this.mapaDelJuego.get(1).size();
    }

    public int obtenerCantidadDeFilas() {
        return this.mapaDelJuego.size();
    }

    public Coordenadas getCoordenadasMeta() {
        return this.coordenadasMeta;
    }

    public Coordenadas getCoordenadasLargada() {
        return this.coordenadasLargada;
    }
}
    



