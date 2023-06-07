package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mapa {
    private List<List<String>> mapa;
    private int alto;
    private int ancho;

    public Mapa(){

        List<String> fila1 = new ArrayList<>();
        fila1.addAll(Arrays.asList("Rocoso","PasarelaLargada","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Rocoso","Rocoso","Rocoso","Rocoso","Rocoso"));
        List<String> fila2 = new ArrayList<>();
        fila2.addAll(Arrays.asList("Tierra","Pasarela","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Rocoso","Rocoso","Rocoso","Rocoso","Rocoso"));
        List<String> fila3 = new ArrayList<>();
        fila3.addAll(Arrays.asList("Tierra","Pasarela","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Rocoso","Rocoso","Rocoso","Rocoso","Rocoso"));
        List<String> fila4 = new ArrayList<>();
        fila4.addAll(Arrays.asList("Tierra","Pasarela","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Rocoso","Rocoso","Rocoso","Rocoso","Rocoso"));
        List<String> fila5 = new ArrayList<>();
        fila5.addAll(Arrays.asList("Tierra","Pasarela","Rocoso","Rocoso","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra"));
        List<String> fila6 = new ArrayList<>();
        fila6.addAll(Arrays.asList("Tierra","Pasarela","Rocoso","Rocoso","Tierra","Tierra","Tierra","Rocoso","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra"));
        List<String> fila7 = new ArrayList<>();
        fila7.addAll(Arrays.asList("Tierra","Pasarela","Pasarela","Pasarela","Pasarela","Pasarela","Pasarela","Pasarela","Pasarela","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra"));
        List<String> fila8 = new ArrayList<>();
        fila8.addAll(Arrays.asList("Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Pasarela","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra"));
        List<String> fila9 = new ArrayList<>();
        fila9.addAll(Arrays.asList("Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Pasarela","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra"));
        List<String> fila10 = new ArrayList<>();
        fila10.addAll(Arrays.asList("Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Pasarela","Rocoso","Tierra","Tierra","Tierra","Tierra","Tierra"));
        List<String> fila11 = new ArrayList<>();
        fila11.addAll(Arrays.asList("Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Pasarela","Pasarela","Pasarela","Pasarela","Pasarela","Pasarela","PasarelaMeta"));
        List<String> fila12 = new ArrayList<>();
        fila12.addAll(Arrays.asList("Rocoso","Rocoso","Rocoso","Rocoso","Rocoso","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra"));
        List<String> fila13 = new ArrayList<>();
        fila13.addAll(Arrays.asList("Rocoso","Rocoso","Rocoso","Rocoso","Rocoso","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra"));
        List<String> fila14 = new ArrayList<>();
        fila14.addAll(Arrays.asList("Rocoso","Rocoso","Rocoso","Rocoso","Rocoso","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra"));
        List<String> fila15 = new ArrayList<>();
        fila15.addAll(Arrays.asList("Rocoso","Rocoso","Rocoso","Rocoso","Rocoso","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra","Tierra"));
        
        this.mapa = new ArrayList<>();
        this.mapa.addAll(Arrays.asList(fila1,fila2,fila3,fila4,fila5,fila6,fila7,fila8,
                                    fila9,fila10,fila11,fila12,fila13,fila14, fila15));
                                
        this.alto = this.mapa.size();
        this.ancho = this.mapa.get(0).size();


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

//        Mapa unMapa = new Mapa();"
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
            System.out.println("Hola, mundo!");
            if(this.esPorAca(posibleCordenada, visitados)){
                System.out.println("Hola, mundo!");
                return posibleCordenada;
            }
        }
        return cordenadaActual;
    }
}
    



