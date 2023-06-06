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

    public boolean esPorAca(Coordenadas coordenadaActual, List<Coordenadas> coordenadasVisitadas){
        int filaActual = coordenadaActual.fila();
        int columaActual = coordenadaActual.columna();

        String posActual = this.mapa.get(filaActual).get(columaActual);
        if(posActual.equals("pasarelaLargada")){
            return false;
        }
        if(posActual.equals("pasarelaMeta")){
            return true;
        }
        coordenadasVisitadas.add(coordenadaActual);

        if(filaActual + 1 < this.alto){
            String posArriba= this.mapa.get(filaActual + 1).get(columaActual);
            if(posArriba.equals("pasarelaLargada") || posArriba.equals("pasarela") || posArriba.equals("pasarelaMeta")){
                return esPorAca(new Coordenadas(filaActual+1, columaActual), coordenadasVisitadas);
            }
        }
        if((filaActual - 1) >= 0){
            String posAbajo = this.mapa.get(filaActual - 1).get(columaActual);
            if(posAbajo.equals("pasarelaLargada") || posAbajo.equals("pasarela") || posAbajo.equals("pasarelaMeta")){
                return esPorAca(new Coordenadas(filaActual-1, columaActual), coordenadasVisitadas);
            }
        }
        if((columaActual - 1) >= 0){
            String posIzquierda = this.mapa.get(filaActual ).get(columaActual - 1);
            if(posIzquierda.equals("pasarelaLargada") || posIzquierda.equals("pasarela") || posIzquierda.equals("pasarelaMeta")){
                return esPorAca(new Coordenadas(filaActual, columaActual - 1), coordenadasVisitadas);
            }
        }
        if((columaActual + 1) < this.ancho){
            String posIzquierda = this.mapa.get(filaActual ).get(columaActual - 1);
            if(posIzquierda.equals("pasarelaLargada") || posIzquierda.equals("pasarela") || posIzquierda.equals("pasarelaMeta")){
                return esPorAca(new Coordenadas(filaActual, columaActual - 1), coordenadasVisitadas);
            }
        }
        return false;
    }
    
}



