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

    EstadoDefensa pasarTurno(String nombre, String mensajeAlFinalizarConstruccion);
    int tiempoDeConstruccion();

    void atacarEnemigos(List<Enemigo> enemigos, TrampaArenosa trampa) throws DefensaEnConstruccionException;
    void atacarEnemigos(List<Enemigo> enemigos, Torre torre, ArrayList<Hormiga> hormigasAsesinadas) throws DefensaEnConstruccionException;
}
