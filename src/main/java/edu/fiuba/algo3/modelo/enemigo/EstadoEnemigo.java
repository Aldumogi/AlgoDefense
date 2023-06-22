package edu.fiuba.algo3.modelo.enemigo;

import edu.fiuba.algo3.modelo.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.modelo.exceptions.ElEnemigoMurioDuranteElAtaqueException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;

import java.util.ArrayList;
import java.util.List;

public interface EstadoEnemigo {
    void mover(Enemigo enemigo);
    EstadoEnemigo recibirDanio(int danio, Coordenadas coordenadas) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException;
    int creditosOtorgados(int creditos);

    void acumularHormigasMuertas(ArrayList<Hormiga> hormigasMuertas, Hormiga enemigo);
    void agregarIndiceDeEnemigoMuerto(List<Integer> indicesEnemigosMuertos, int posicionActual);

    int obtenerEnergia();
}
