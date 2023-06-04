package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.DefensaEnConstruccionException;
import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.exceptions.FueraDeRangoException;

public class TorrePlateada extends Defensa {

    public TorrePlateada() {
        this.nombre("Torre Plateada");
        this.costo(20);
        this.tiempoDeConstruccion(2);
        this.rangoDeAtaque(5);
        this.danio(2);
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
