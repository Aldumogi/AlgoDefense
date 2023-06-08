package edu.fiuba.algo3;

public class Coordenadas  {
    private int fila;
    private int columna;

    public Coordenadas(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }
    public Double distanciaEntreCoordenadas(Coordenadas c1) {
        return Math.sqrt( Math.pow(this.fila - c1.fila, 2) + Math.pow(this.columna - c1.columna, 2));
    }

}
