package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcela.Parcela;

import java.util.ArrayList;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class TorrePlateada extends Torre {

    public TorrePlateada() {
        this.nombre = "Torre Plateada";
        this.costo = 20;
        this.tiempoDeConstruccion = 2;
        this.rangoDeAtaque = 5;
        this.danio = 2;
    }

    public void construir(Mapa mapa, Coordenadas coordenadas) throws NoSePudoConstruirException {
        this.coordenadas = coordenadas;
        mapa.recibir(this);
        this.estado = new EnConstruccion(this.tiempoDeConstruccion);

        logger.info("Jugador inicia la construcción de una Torre Plateada en la posición (" +
                coordenadas.obtenerFila() + ", " + coordenadas.obtenerColumna()
                + ")");
        setChanged();
    }

    public void atacarEnemigo(Enemigo enemigo, ArrayList<Hormiga> hormigasAsesinadas) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException, FueraDeRangoException {
        this.estaEnRango(enemigo.obtenerCoordenadas(), this.coordenadas, this.rangoDeAtaque);
        logger.info("Torre Plateada ataca a una " + enemigo.obtenerNombre() + " en la posicion (" +
                enemigo.obtenerCoordenadas().obtenerFila() + ", " +
                enemigo.obtenerCoordenadas().obtenerColumna() + ")");
        enemigo.recibirDanio(this.danio);
        enemigo.acumularMuertos( hormigasAsesinadas );
        enemigo.cantidadCreditosOtorgados( hormigasAsesinadas.size() );
    }
}
