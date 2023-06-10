package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.DefensaEnConstruccionException;
import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.exceptions.FueraDeRangoException;

import java.util.ArrayList;
import java.util.List;

public interface EstadoDefensa {
    void atacarEnemigo(Enemigo enemigo, int rangoDeAtaque, int danio, Coordenadas coordenadasDefensa) throws ElEnemigoMurioDuranteElAtaqueException,
            ElEnemigoEstaMuertoException, DefensaEnConstruccionException, FueraDeRangoException;
    EstadoDefensa pasarTurno(List<Enemigo> enemigos, int rangoDeAtaque, int danio,
                             Coordenadas coordenadasDefensa, ArrayList<Hormiga> hormigasAsesinadas,
                             double factorDeRalentizacion);
    int tiempoDeConstruccion();

    void ralentizarEnemigo(Enemigo enemigo, double ralentizacion);

}
