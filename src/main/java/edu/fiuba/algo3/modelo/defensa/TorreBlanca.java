package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class TorreBlanca extends Torre {
    public TorreBlanca() {
        this.nombre = "Torre Blanca";
        this.costo = 10;
        this.tiempoDeConstruccion = 1;
        this.rangoDeAtaque = 3;
        this.danio = 1;
    }

    public void construir(Mapa mapa, Coordenadas coordenadas) throws NoSePudoConstruirException {
        this.coordenadas = coordenadas;
        mapa.recibir(this);
        this.estado = new EnConstruccion(this.tiempoDeConstruccion);

        logger.info("Jugador inicia la construcción de una Torre Blanca en la posición (" +
                coordenadas.obtenerFila() + ", " + coordenadas.obtenerColumna()
                + ")");
    }

    public void atacarEnemigo(Enemigo enemigo, ArrayList<Hormiga> hormigasAsesinadas) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException, FueraDeRangoException {
        this.estaEnRango(enemigo.obtenerCoordenadas(), this.coordenadas, this.rangoDeAtaque);
        logger.info("Torre Blanca ataca a una " + enemigo.obtenerNombre() + " en la posicion (" +
                enemigo.obtenerCoordenadas().obtenerFila() + ", " +
                enemigo.obtenerCoordenadas().obtenerColumna() + ")");
        enemigo.recibirDanio(this.danio);
        enemigo.acumularMuertos( hormigasAsesinadas );
        enemigo.cantidadCreditosOtorgados( hormigasAsesinadas.size() );
    }

}
