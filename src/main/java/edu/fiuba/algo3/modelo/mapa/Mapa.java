package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.defensa.Torre;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
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
    public void recibir(TrampaArenosa trampaArenosa) throws NoSePudoConstruirException {
        if ( trampaArenosa != null ) {
            Coordenadas coordenadas = trampaArenosa.obtenerCoordenadas();
            this.mapaDelJuego.get(coordenadas.fila()).get(coordenadas.columna()).construir(trampaArenosa);
        }
    }
    public void recibir(Torre torre) throws NoSePudoConstruirException {
        if ( torre != null ) {
            Coordenadas coordenadas = torre.obtenerCoordenadas();
            this.mapaDelJuego.get(coordenadas.fila()).get(coordenadas.columna()).construir(torre);
        }
    }
    public void borrar(Enemigo enemigo) throws NoSePudoBorrarElEnemigoException {
        Coordenadas coordenadas = enemigo.obtenerCoordenadas();
        this.mapaDelJuego.get(coordenadas.fila()).get(coordenadas.columna()).borrarObjeto(enemigo);
    }
    public void borrar(Defensa defensa) {
        Coordenadas coordenadas = defensa.obtenerCoordenadas();
        this.mapaDelJuego.get(coordenadas.fila()).get(coordenadas.columna()).borrarObjeto(defensa);
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
        if (nuevaCoordenada.fila() <= 0 || nuevaCoordenada.columna() <= 0 ){
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
    public Coordenadas devolverSiguienteCordenadaEnL(Coordenadas cordenadaActual, double cantidadDeMovimientos){
        Coordenadas meta = this.getCoordenadasMeta();
        int columnaMeta = meta.columna();
        int filaMeta = meta.fila();

        while(cantidadDeMovimientos != 0){
            if(columnaMeta > cordenadaActual.columna()){
                cordenadaActual = new Coordenadas(cordenadaActual.fila(), cordenadaActual.columna() + 1);
            }else if(columnaMeta < cordenadaActual.columna()){
                cordenadaActual = new Coordenadas(cordenadaActual.fila(), cordenadaActual.columna() - 1);   
            }else if(filaMeta > cordenadaActual.fila()){
                cordenadaActual = new Coordenadas(cordenadaActual.fila() + 1, cordenadaActual.columna());   
            }else if(filaMeta < cordenadaActual.fila()){
                cordenadaActual = new Coordenadas(cordenadaActual.fila() - 1, cordenadaActual.columna());   
            }
            cantidadDeMovimientos -= 1;
            if (meta.equals(cordenadaActual)){
                return cordenadaActual;
            }
        }
        return cordenadaActual;
        
    }
    public Coordenadas devolverSiguienteCordenadaUsandoDiagonalesMasCercanaALaMeta(Coordenadas cordenadaActual){
        Coordenadas meta = this.getCoordenadasMeta();
        int columnaMeta = meta.columna();
        int filaMeta = meta.fila();
        int filaActual = cordenadaActual.fila();
        int columnaActual = cordenadaActual.columna();
        if (columnaMeta == columnaActual || filaMeta == filaActual){
            return devolverSiguienteCordenadaEnL(cordenadaActual, 1);
        }
        if(columnaMeta > columnaActual && filaMeta > filaActual ){
            cordenadaActual = new Coordenadas(filaActual + 1, columnaActual + 1);
        }else if(columnaMeta < columnaActual && filaMeta < filaActual ){
            cordenadaActual = new Coordenadas(filaActual - 1, columnaActual - 1); 

        }else if(columnaMeta > columnaActual && filaMeta < filaActual ){
            cordenadaActual = new Coordenadas(filaActual - 1, columnaActual + 1); 
        }else if(columnaMeta < columnaActual && filaMeta > filaActual ){
            cordenadaActual = new Coordenadas(filaActual + 1, columnaActual - 1); 
        }
        return cordenadaActual;
    }
    public Coordenadas devolverSiguientesNCordenadaUsandoDiagonalesMasCercanaALaMeta(Coordenadas cordenadaActual, int cantidadDeMovimientos){
        for(int i = 0; i < cantidadDeMovimientos; i++){
            cordenadaActual = devolverSiguienteCordenadaUsandoDiagonalesMasCercanaALaMeta(cordenadaActual);
        }
        return cordenadaActual;
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
    



