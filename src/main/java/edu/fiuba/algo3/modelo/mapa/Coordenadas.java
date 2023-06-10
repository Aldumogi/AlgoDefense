package edu.fiuba.algo3.modelo.mapa;

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
    public int fila(){
        return this.fila;
    }
    public int columna(){
        return this.columna;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
    
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
    
        Coordenadas other = (Coordenadas) obj;
        return fila == other.fila && columna == other.columna;
    }
    


    public int obtenerFila() {
        return fila;
    }

    public int obtenerColumna() {
        return columna;
    }

}
