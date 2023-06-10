package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.DefensaEnConstruccionException;
import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.exceptions.FueraDeRangoException;

public class Terminada implements EstadoDefensa {
    private int tiempoDeConstruccion = 0;
    private int tiempoDeRalentizacion;
    public Terminada(int tiempoDeRalentizacion) {
        this.tiempoDeRalentizacion = tiempoDeRalentizacion;
    }
    public void atacarEnemigo(Enemigo enemigo, int rangoDeAtaque, int danio, Coordenadas coordenadasDefensa) throws ElEnemigoMurioDuranteElAtaqueException,
            ElEnemigoEstaMuertoException, DefensaEnConstruccionException, FueraDeRangoException {

        this.estaEnRango(enemigo.obtenerCoordenadas(), coordenadasDefensa, rangoDeAtaque);
        enemigo.recibirDanio(danio);
    }

    private void estaEnRango(Coordenadas coordenadasEnemigo,Coordenadas coordenadasDefensa, int rangoDeAtaque) throws FueraDeRangoException {
        if ( coordenadasDefensa.distanciaEntreCoordenadas( coordenadasEnemigo) > rangoDeAtaque ) throw new FueraDeRangoException();
    }

    public EstadoDefensa pasarTurno() {
        return this;
    }

    public int tiempoDeConstruccion() {
        return this.tiempoDeConstruccion;
    }

    public void ralentizarEnemigo(Enemigo enemigo, double ralentizacion) {
        if ( this.tiempoDeRalentizacion < 0 ) {
            return;
        }
        if ( this.tiempoDeRalentizacion == 0 ) {
            ralentizacion = 1;
        }
        enemigo.recibirRalentizacion(ralentizacion);
        this.tiempoDeRalentizacion--;
    }
}
