package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.DefensaEnConstruccionException;
import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.exceptions.FueraDeRangoException;

import static edu.fiuba.algo3.Inicializador.logger;

public class TorrePlateada extends Defensa {

    public TorrePlateada() {
        this.nombre = "Torre Plateada";
        this.costo = 20;
        this.tiempoDeConstruccion = 2;
        this.rangoDeAtaque = 5;
        this.danio = 2;
        this.tiempoDeRalentizacion = -1;
    }

    public void construir(Parcela tierra) {
        this.parcela = tierra;
        this.estado = new EnConstruccion(this.tiempoDeConstruccion, this.tiempoDeRalentizacion);

        logger.info("Se pusó en construcción una Torre Plateada");
    }
    public void atacarEnemigo(Enemigo enemigo) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException,
            DefensaEnConstruccionException, FueraDeRangoException {
        this.estado.atacarEnemigo(enemigo, this.rangoDeAtaque, this.danio , this.parcela.obtenerCoordenadas());

        logger.info("Torre Plateada atacó a un enemigo");
    }
}
