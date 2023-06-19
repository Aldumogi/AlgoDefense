package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.exceptions.DefensaEnConstruccionException;
import edu.fiuba.algo3.modelo.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.modelo.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.modelo.exceptions.FueraDeRangoException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import static edu.fiuba.algo3.modelo.LoggerManager.logger;

import java.util.ArrayList;
import java.util.List;

public class EnConstruccion implements EstadoDefensa {
    private int tiempoDeConstruccion;
    private String mensajeAlFinalizarConstruccion;

    public EnConstruccion(int tiempoDeConstruccion, String mensajeAlFinalizarConstruccion) {
        this.tiempoDeConstruccion = tiempoDeConstruccion;
        this.mensajeAlFinalizarConstruccion = mensajeAlFinalizarConstruccion;
    }
    public void atacarEnemigo(Enemigo enemigo, int rangoDeAtaque, int danio, Coordenadas coordenadasDefensa, String nombre) throws ElEnemigoMurioDuranteElAtaqueException,
            ElEnemigoEstaMuertoException, DefensaEnConstruccionException, FueraDeRangoException {
        throw new DefensaEnConstruccionException();
    }

    public void atacarEnemigos(List<Enemigo> enemigos, int rangoDeAtaque, int danio, Coordenadas coordenadasDefensa, ArrayList<Hormiga> hormigasAsesinadas, String nombre) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException, DefensaEnConstruccionException, FueraDeRangoException {
        throw new DefensaEnConstruccionException();
    }

    public void atacarEnemigos(List<Enemigo> enemigos, Coordenadas coordenadasDefensa, double factorDeRalentizacion, String nombre) throws DefensaEnConstruccionException {
        throw new DefensaEnConstruccionException();
    }

    public int tiempoDeConstruccion() { return this.tiempoDeConstruccion; }

    public void ralentizarEnemigos(List<Enemigo> enemigos, Coordenadas coordenadasDefensa, Integer tiempoDeRalentizacion, double ralentizacion) { }

    public EstadoDefensa pasarTurno(List<Enemigo> enemigos, int rangoDeAtaque, int danio,
                                    Coordenadas coordenadasDefensa, ArrayList<Hormiga> hormigasAsesinadas,
                                    String nombre) {
        this.tiempoDeConstruccion--;
        if ( this.tiempoDeConstruccion <= 0 ) {
            logger.info( this.mensajeAlFinalizarConstruccion );
            return new Terminada();
        }
        return this;
    }

    public EstadoDefensa pasarTurno(List<Enemigo> enemigos, Coordenadas coordenadasDefensa, String nombre) {
        return this.pasarTurno(enemigos, 0, 0, coordenadasDefensa, null, nombre);
    }
}
