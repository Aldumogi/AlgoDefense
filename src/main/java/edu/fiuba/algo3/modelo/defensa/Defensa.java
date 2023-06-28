package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import java.util.Observable;

import java.util.ArrayList;
import java.util.List;

public interface Defensa {
    void construir(Mapa mapa, Coordenadas coordenadas) throws NoSePudoConstruirException;

    int costo();

    EstadoDefensa estadoDefensa();

    void pasarTurno(List<Enemigo> enemigos, ArrayList<Hormiga> hormigasAsesinadas, Mapa mapa, List<Defensa> trampasAEliminar, String nombre);

    String getNombre();

    Coordenadas obtenerCoordenadas();
}
