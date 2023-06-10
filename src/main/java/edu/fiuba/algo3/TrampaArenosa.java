package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.DefensaEnConstruccionException;
import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.exceptions.FueraDeRangoException;

public class TrampaArenosa extends Defensa{
    private double ralentizacion;
    public TrampaArenosa() {
        this.nombre = "Trampa arenosa";
        this.costo = 25;
        this.tiempoDeConstruccion = 1;
        this.rangoDeAtaque = 3;
        this.danio = 0;
        this.ralentizacion = 0.5;
        this.tiempoDeRalentizacion = 3;
    }

    public void atacarEnemigo(Enemigo enemigo) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException, DefensaEnConstruccionException, FueraDeRangoException {

    }

    public void ralentizarEnemigo(Enemigo enemigo) {
        this.estado.ralentizarEnemigo(enemigo, this.ralentizacion);
    }

    public void construir(Parcela pasarela) {
        /* Tal vez aca tendriamos que crear una PasarelaNormal para evitar el if aca */
        if ( pasarela.equals( new Pasarela(pasarela.obtenerCoordenadas()) ) &&
                ! pasarela.equals( new PasarelaMeta(pasarela.obtenerCoordenadas()) )
            && ! pasarela.equals( new PasarelaLargada(pasarela.obtenerCoordenadas()) ) ){
            this.parcela = pasarela;
            this.estado = new EnConstruccion(this.tiempoDeConstruccion, this.tiempoDeRalentizacion);
        }
    }
}
