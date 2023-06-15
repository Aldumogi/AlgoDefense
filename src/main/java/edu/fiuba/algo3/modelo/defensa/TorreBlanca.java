package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class TorreBlanca extends Torre {
    public TorreBlanca() {
        this.nombre = "Torre Blanca";
        this.costo = 10;
        this.tiempoDeConstruccion = 1;
        this.rangoDeAtaque = 3;
        this.danio = 1;
        this.tiempoDeRalentizacion = -1;
        this.factorDeRalentizacion = 1;
    }

    public void construir(Mapa mapa, Coordenadas coordenadas) throws NoSePudoConstruirException {
        this.coordenadas = coordenadas;
        mapa.recibir(this);
        String mensajeAlFinalizarConstruccion = "La construcción de " + this.nombre + " en la posición ("
                + this.coordenadas.obtenerFila() + ", " + this.coordenadas.obtenerColumna() + ") terminó" ;
        this.estado = new EnConstruccion(this.tiempoDeConstruccion, this.tiempoDeRalentizacion, mensajeAlFinalizarConstruccion);

        logger.info("Jugador inicia la construcción de una Torre Blanca en la posición (" +
                coordenadas.obtenerFila() + ", " + coordenadas.obtenerColumna()
                + ")");
    }

    public void atacarEnemigo(Enemigo enemigo) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException,
            DefensaEnConstruccionException, FueraDeRangoException {
        this.estado.atacarEnemigo(enemigo, this.rangoDeAtaque, this.danio , this.obtenerCoordenadas());

        logger.info("Torre Blanca ataca a una " + enemigo.obtenerNombre() + " en la posicion (" +
                enemigo.obtenerCoordenadas().obtenerFila() + ", " +
                enemigo.obtenerCoordenadas().obtenerColumna() + ")");
    }

}
