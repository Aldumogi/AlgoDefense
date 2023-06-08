package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.DefensaEnConstruccionException;

public class Terminada implements AccionesDefensa {
    public Boolean atacarEnemigo(Enemigo enemigo, int rangoDeAtaque, int danio, Coordenadas coordenadasDefensa) {
        return ( this.estaEnRango(enemigo.obtenerCoordenadas(), coordenadasDefensa, rangoDeAtaque) )?
                enemigo.recibirDanio(danio): false;
    }

    private boolean estaEnRango(Coordenadas coordenadasEnemigo,Coordenadas coordenadasDefensa, int rangoDeAtaque){
        return (coordenadasDefensa.distanciaEntreCoordenadas( coordenadasEnemigo) <= rangoDeAtaque)? true: false;
    }
    // vacia porque esta terminada
    public void estaTerminada() throws DefensaEnConstruccionException {   }
}
