package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import java.util.Observable;

import java.util.ArrayList;
import java.util.List;

abstract public class Defensa extends Observable {
    abstract public void construir(Mapa mapa, Coordenadas coordenadas) throws NoSePudoConstruirException;

    abstract public int costo();

    abstract public EstadoDefensa estadoDefensa();

    abstract public void pasarTurno(List<Enemigo> enemigos, ArrayList<Hormiga> hormigasAsesinadas, Mapa mapa, List<Defensa> trampasAEliminar, String nombre);

    abstract public String getNombre();

    abstract public Coordenadas obtenerCoordenadas();

    abstract public boolean enConstruccion();
}
