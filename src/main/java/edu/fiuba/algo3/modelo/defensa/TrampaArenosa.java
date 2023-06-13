package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcela.Parcela;
import edu.fiuba.algo3.modelo.parcela.Pasarela;
import edu.fiuba.algo3.modelo.parcela.PasarelaLargada;
import edu.fiuba.algo3.modelo.parcela.PasarelaMeta;

public class TrampaArenosa extends Defensa{
    public TrampaArenosa() {
        this.nombre = "Trampa arenosa";
        this.costo = 25;
        this.tiempoDeConstruccion = 1;
        this.rangoDeAtaque = 3;
        this.danio = 0;
        this.factorDeRalentizacion = 0.5;
        this.tiempoDeRalentizacion = 3;
    }

    public void atacarEnemigo(Enemigo enemigo) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException, DefensaEnConstruccionException, FueraDeRangoException {

    }

    public void ralentizarEnemigo(Enemigo enemigo) {
        this.estado.ralentizarEnemigo(enemigo, this.factorDeRalentizacion);
    }

    public void construir(Mapa mapa, Coordenadas coordenadas) throws NoSePudoConstruirException {
        this.coordenadas = coordenadas;
        mapa.recibir(this);
        this.estado = new EnConstruccion(this.tiempoDeConstruccion, this.tiempoDeRalentizacion);
    }

}
