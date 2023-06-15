package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.exceptions.DefensaEnConstruccionException;
import edu.fiuba.algo3.modelo.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.modelo.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.modelo.exceptions.FueraDeRangoException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import edu.fiuba.algo3.modelo.mapa.Mapa;

import java.util.ArrayList;
import java.util.List;
import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class Terminada implements EstadoDefensa {
    private int tiempoDeConstruccion = 0;
    private int tiempoDeRalentizacion;
    public Terminada(int tiempoDeRalentizacion) {
        this.tiempoDeRalentizacion = tiempoDeRalentizacion;
    }
    public void atacarEnemigo(Enemigo enemigo, int rangoDeAtaque, int danio, Coordenadas coordenadasDefensa, String nombre) throws ElEnemigoMurioDuranteElAtaqueException,
            ElEnemigoEstaMuertoException, DefensaEnConstruccionException, FueraDeRangoException {

        this.estaEnRango(enemigo.obtenerCoordenadas(), coordenadasDefensa, rangoDeAtaque);
        enemigo.recibirDanio(danio);
        logger.info( nombre + " ataca a una " + enemigo.obtenerNombre() + " en la posicion (" +
                enemigo.obtenerCoordenadas().obtenerFila() + ", " +
                enemigo.obtenerCoordenadas().obtenerColumna() + ")");
    }

    private void estaEnRango(Coordenadas coordenadasEnemigo,Coordenadas coordenadasDefensa, int rangoDeAtaque) throws FueraDeRangoException {
        if ( coordenadasDefensa.distanciaEntreCoordenadas( coordenadasEnemigo) > rangoDeAtaque ) throw new FueraDeRangoException();
    }

    public EstadoDefensa pasarTurno(List<Enemigo> enemigos, int rangoDeAtaque, int danio,
                                    Coordenadas coordenadasDefensa, ArrayList<Hormiga> hormigasAsesinadas,
                                    double factorDeRalentizacion, String nombre) {
        for (Enemigo enemigo: enemigos) {
            try {
                this.atacarEnemigo(enemigo, rangoDeAtaque, danio, coordenadasDefensa, nombre);
                enemigo.acumularMuertos( hormigasAsesinadas );
                enemigo.cantidadCreditosOtorgados( hormigasAsesinadas.size() );

            } catch (ElEnemigoMurioDuranteElAtaqueException e) {}
            catch (ElEnemigoEstaMuertoException e) {}
            catch (DefensaEnConstruccionException e) {}
            catch (FueraDeRangoException e) {}
        }
        return this;
    }

    public EstadoDefensa pasarTurno(List<Enemigo> enemigos, Coordenadas coordenadasDefensa,
                                    double factorDeRalentizacion, String nombre) {
        this.tiempoDeRalentizacion--;
        for (Enemigo enemigo: enemigos) {
            this.ralentizarEnemigo(enemigo, coordenadasDefensa, factorDeRalentizacion);
        }
        return this;
    }

    public int tiempoDeConstruccion() {
        return this.tiempoDeConstruccion;
    }
    public int obtenerTiempoDeRalentizacion() { return this.tiempoDeRalentizacion; }
    public void ralentizarEnemigo(Enemigo enemigo, Coordenadas coordenadasDefensa, double ralentizacion) {
        if( coordenadasDefensa.distanciaEntreCoordenadas(enemigo.obtenerCoordenadas()) == 0
                && this.tiempoDeRalentizacion >= 0) {
            enemigo.recibirRalentizacion(ralentizacion);
        }
    }
}
