package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.DefensaEnConstruccionException;
import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.exceptions.FueraDeRangoException;

public class TorreBlanca extends Defensa {
    public TorreBlanca() {
        this.nombre("Torre Blanca");
        this.costo(10);
        this.tiempoDeConstruccion(1);
        this.rangoDeAtaque(3);
        this.danio(1);
    }

    public void construir(Tierra tierra, int numeroDeTurno) {
        this.tierra = tierra;
        this.accionesDefensa = new EnConstruccion();
        this.turnoEnElQueSeInicioLaConstruccion = numeroDeTurno;
    }

    public void atacarEnemigo(Enemigo enemigo) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException,
            DefensaEnConstruccionException, FueraDeRangoException {
        this.accionesDefensa.atacarEnemigo(enemigo, this.rangoDeAtaque, this.danio , this.tierra.obtenerCoordenadas());
    }

}
