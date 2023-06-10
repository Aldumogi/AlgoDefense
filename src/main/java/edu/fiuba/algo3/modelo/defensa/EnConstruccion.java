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
    private int tiempoDeRalentizacion;
    public EnConstruccion(int tiempoDeConstruccion, int tiempoDeRalentizacion) {
        this.tiempoDeConstruccion = tiempoDeConstruccion;
        this.tiempoDeRalentizacion = tiempoDeRalentizacion;
    }
    public void atacarEnemigo(Enemigo enemigo, int rangoDeAtaque, int danio, Coordenadas coordenadasDefensa) throws ElEnemigoMurioDuranteElAtaqueException,
            ElEnemigoEstaMuertoException, DefensaEnConstruccionException, FueraDeRangoException {
        throw new DefensaEnConstruccionException();
    }
    public int tiempoDeConstruccion() { return this.tiempoDeConstruccion; }

    public void ralentizarEnemigo(Enemigo enemigo, double ralentizacion) { }

    public EstadoDefensa pasarTurno(List<Enemigo> enemigos, int rangoDeAtaque, int danio,
                                    Coordenadas coordenadasDefensa, ArrayList<Hormiga> hormigasAsesinadas,
                                    double factorDeRalentizacion) {
        this.tiempoDeConstruccion--;
        if ( this.tiempoDeConstruccion <= 0 ) {
            logger.info("La construcción terminó");
            return new Terminada(this.tiempoDeRalentizacion);
        }
        return this;
    }
}