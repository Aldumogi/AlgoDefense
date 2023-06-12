package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.exceptions.DefensaEnConstruccionException;
import edu.fiuba.algo3.modelo.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.modelo.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.modelo.exceptions.FueraDeRangoException;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.parcela.Parcela;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class TorreBlanca extends Defensa {
    public TorreBlanca() {
        this.nombre = "Torre Blanca";
        this.costo = 10;
        this.tiempoDeConstruccion = 1;
        this.rangoDeAtaque = 3;
        this.danio = 1;
        this.tiempoDeRalentizacion = -1;
        this.factorDeRalentizacion = 1;
    }

    public void construir(Parcela tierra) {
        this.parcela = tierra;
        this.estado = new EnConstruccion(this.tiempoDeConstruccion, this.tiempoDeRalentizacion);

        logger.info("Se pusó en construcción una Torre Blanca");
    }

    public void atacarEnemigo(Enemigo enemigo) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException,
            DefensaEnConstruccionException, FueraDeRangoException {
        this.estado.atacarEnemigo(enemigo, this.rangoDeAtaque, this.danio , this.parcela.obtenerCoordenadas());

        logger.info("Torre Blanca atacó a un enemigo");
    }

}
