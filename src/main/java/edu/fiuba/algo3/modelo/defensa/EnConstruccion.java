package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import edu.fiuba.algo3.modelo.exceptions.DefensaEnConstruccionException;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

import java.util.ArrayList;
import java.util.List;

public class EnConstruccion implements EstadoDefensa {
    private int tiempoDeConstruccion;

    public EnConstruccion(int tiempoDeConstruccion) {
        this.tiempoDeConstruccion = tiempoDeConstruccion;
    }
    public int tiempoDeConstruccion() { return this.tiempoDeConstruccion; }

    public void atacarEnemigos(List<Enemigo> enemigos, TrampaArenosa trampa) throws DefensaEnConstruccionException {
        throw new DefensaEnConstruccionException();
    }
    public void atacarEnemigos(List<Enemigo> enemigos, Torre torre, ArrayList<Hormiga> hormigasAsesinadas) throws DefensaEnConstruccionException {
        throw new DefensaEnConstruccionException();
    }

    public EstadoDefensa pasarTurno(String mensajeAlFinalizarConstruccion) {
        this.tiempoDeConstruccion--;
        if ( this.tiempoDeConstruccion <= 0 ) {
            logger.info( mensajeAlFinalizarConstruccion );
            return new Terminada();
        }
        return this;
    }

    public boolean enConstruccion() {
        return true;
    }
}
