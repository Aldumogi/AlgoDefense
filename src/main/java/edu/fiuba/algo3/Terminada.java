package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.DefensaEnConstruccionException;
import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.exceptions.FueraDeRangoException;

public class Terminada implements AccionesDefensa {
    public void atacarEnemigo(Enemigo enemigo, int rangoDeAtaque, int danio, Coordenadas coordenadasDefensa) throws ElEnemigoMurioDuranteElAtaqueException,
            ElEnemigoEstaMuertoException, DefensaEnConstruccionException, FueraDeRangoException {
        if ( ! this.estaEnRango(enemigo.obtenerCoordenadas(), coordenadasDefensa, rangoDeAtaque) ) {
            throw new FueraDeRangoException();
        }
        enemigo.recibirDanio(danio);
    }

    private boolean estaEnRango(Coordenadas coordenadasEnemigo,Coordenadas coordenadasDefensa, int rangoDeAtaque){
        return (coordenadasDefensa.distanciaEntreCoordenadas( coordenadasEnemigo) <= rangoDeAtaque)? true: false;
    }
    // vacia porque esta terminada
    public void estaTerminada() throws DefensaEnConstruccionException {   }
}
