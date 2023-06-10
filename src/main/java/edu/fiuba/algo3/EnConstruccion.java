package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.DefensaEnConstruccionException;
import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.exceptions.FueraDeRangoException;

import java.util.ArrayList;
import java.util.List;

import static edu.fiuba.algo3.Inicializador.logger;

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
    public int cantidadDeHormigasAsesinadas() { return 0; }

    public void ralentizarEnemigo(Enemigo enemigo, double ralentizacion) { }

    public EstadoDefensa pasarTurno(List<Enemigo> enemigos, int rangoDeAtaque, int danio,
                                    Coordenadas coordenadasDefensa, ArrayList<Hormiga> hormigasAsesinadas) {
        this.tiempoDeConstruccion--;
        if ( this.tiempoDeConstruccion <= 0 ) {
            logger.info("La construcción terminó");
            return new Terminada(this.tiempoDeRalentizacion);
        }
        return this;
    }
}
