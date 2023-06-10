package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.DefensaEnConstruccionException;
import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.exceptions.FueraDeRangoException;

import static edu.fiuba.algo3.Inicializador.logger;

public class TorreBlanca extends Defensa {
    public TorreBlanca() {
        this.nombre = "Torre Blanca";
        this.costo = 10;
        this.tiempoDeConstruccion = 1;
        this.rangoDeAtaque = 3;
        this.danio = 1;
        this.tiempoDeRalentizacion = -1;
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
