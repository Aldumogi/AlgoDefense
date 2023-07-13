package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.exceptions.DefensaEnConstruccionException;
import edu.fiuba.algo3.modelo.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.modelo.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.modelo.exceptions.FueraDeRangoException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class Terminada implements EstadoDefensa {
    private int tiempoDeConstruccion = 0;
    public Terminada() {
    }

    public EstadoDefensa pasarTurno(String mensajeAlFinalizarConstruccion) {
        return this;
    }

    public int tiempoDeConstruccion() {
        return this.tiempoDeConstruccion;
    }

    public void atacarEnemigos(List<Enemigo> enemigos, TrampaArenosa trampa ) {
        enemigos.forEach(trampa::ralentizarEnemigo);
    }

    public void atacarEnemigos(List<Enemigo> enemigos, Torre torre, ArrayList<Hormiga> hormigasAsesinadas) {
        enemigos.forEach(enemigo -> {
            try {
                torre.atacarEnemigo(enemigo, hormigasAsesinadas);
            } catch (ElEnemigoMurioDuranteElAtaqueException e) { }
            catch (ElEnemigoEstaMuertoException e) {}
            catch (DefensaEnConstruccionException e) {}
            catch (FueraDeRangoException e) {}
        });
    }

    public boolean enConstruccion() {
        return false;
    }
}
