package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcela.Parcela;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class TorrePlateada extends Torre {

    public TorrePlateada() {
        this.nombre = "Torre Plateada";
        this.costo = 20;
        this.tiempoDeConstruccion = 2;
        this.rangoDeAtaque = 5;
        this.danio = 2;
        this.tiempoDeRalentizacion = -1;
        this.factorDeRalentizacion = 1;
    }

    public void construir(Mapa mapa, Coordenadas coordenadas) throws NoSePudoConstruirException {
        this.coordenadas = coordenadas;
        mapa.recibir(this);
        String mensajeAlFinalizarConstruccion = "La construcción de " + this.nombre + " en la posición ("
                + this.coordenadas.obtenerFila() + ", " + this.coordenadas.obtenerColumna() + ") terminó" ;
        this.estado = new EnConstruccion(this.tiempoDeConstruccion, mensajeAlFinalizarConstruccion);

        logger.info("Jugador inicia la construcción de una Torre Plateada en la posición (" +
                coordenadas.obtenerFila() + ", " + coordenadas.obtenerColumna()
                + ")");
    }

    public void atacarEnemigo(Enemigo enemigo) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException,
            DefensaEnConstruccionException, FueraDeRangoException {
        this.estado.atacarEnemigo(enemigo, this.rangoDeAtaque, this.danio , this.obtenerCoordenadas(), this.nombre);

        logger.info("Torre Plateada ataca a una " + enemigo.obtenerNombre() + "en la posicion (" +
                enemigo.obtenerCoordenadas().obtenerFila() + ", " +
                enemigo.obtenerCoordenadas().obtenerColumna() + ")");
    }
}
