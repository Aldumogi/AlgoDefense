package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.exceptions.DefensaEnConstruccionException;
import edu.fiuba.algo3.modelo.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.modelo.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.modelo.exceptions.FueraDeRangoException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;

import java.util.ArrayList;
import java.util.List;

public interface EstadoDefensa {
    // atacarEnemigo deberia ser interna (implementar adentro de Terminada)
    void atacarEnemigo(Enemigo enemigo, int rangoDeAtaque, int danio, Coordenadas coordenadasDefensa, String nombre) throws ElEnemigoMurioDuranteElAtaqueException,
            ElEnemigoEstaMuertoException, DefensaEnConstruccionException, FueraDeRangoException;
    void atacarEnemigos(List<Enemigo> enemigos, int rangoDeAtaque, int danio,
                        Coordenadas coordenadasDefensa, ArrayList<Hormiga> hormigasAsesinadas, String nombre) throws ElEnemigoMurioDuranteElAtaqueException,
            ElEnemigoEstaMuertoException, DefensaEnConstruccionException, FueraDeRangoException;

    void atacarEnemigos(List<Enemigo> enemigos, Coordenadas coordenadasDefensa, double factorDeRalentizacion, String nombre) throws ElEnemigoMurioDuranteElAtaqueException,
            ElEnemigoEstaMuertoException, DefensaEnConstruccionException, FueraDeRangoException;

    EstadoDefensa pasarTurno(List<Enemigo> enemigos, int rangoDeAtaque, int danio,
                             Coordenadas coordenadasDefensa, ArrayList<Hormiga> hormigasAsesinadas,
                             double factorDeRalentizacion, String nombre);
    EstadoDefensa pasarTurno(List<Enemigo> enemigos, Coordenadas coordenadasDefensa,
                             double factorDeRalentizacion, String nombre);
    int tiempoDeConstruccion();

    void ralentizarEnemigos(List<Enemigo> enemigos, Coordenadas coordenadasDefensa, Integer tiempoDeRalentizacion, double ralentizacion);
}
