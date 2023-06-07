package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.DefensaEnConstruccionException;
import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.exceptions.FueraDeRangoException;

import static edu.fiuba.algo3.Inicializador.logger;

public class EnConstruccion implements EstadoDefensa {
    private int tiempoDeConstruccion;
    public EnConstruccion(int tiempoDeConstruccion) {
        this.tiempoDeConstruccion = tiempoDeConstruccion;
    }
    public void atacarEnemigo(Enemigo enemigo, int rangoDeAtaque, int danio, Coordenadas coordenadasDefensa) throws ElEnemigoMurioDuranteElAtaqueException,
            ElEnemigoEstaMuertoException, DefensaEnConstruccionException, FueraDeRangoException {
        throw new DefensaEnConstruccionException();
    }
    public int tiempoDeConstruccion() { return this.tiempoDeConstruccion; }

    public EstadoDefensa pasarTurno() {
        this.tiempoDeConstruccion--;
        if ( this.tiempoDeConstruccion <= 0 ) {
            logger.info("La construcción terminó");
            return new Terminada();
        }
        return this;
    }
}
