package edu.fiuba.algo3;

public class Terminada implements AccionesDefensa {
    public Boolean atacarEnemigo(Enemigo enemigo, int rangoDeAtaque, int danio, Coordenadas coordenadasDefensa) {
        if ( this.estaEnRango(enemigo.obtenerCoordenadas(), coordenadasDefensa, rangoDeAtaque) ) {
            return enemigo.recibirDanio(danio);
        }
        return false;
    }

    private boolean estaEnRango(Coordenadas coordenadasEnemigo,Coordenadas coordenadasDefensa, int rangoDeAtaque){
        return (coordenadasDefensa.distanciaEntreCoordenadas( coordenadasEnemigo) <= rangoDeAtaque)? true: false;
    }

}
