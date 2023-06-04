package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.ElEnemigoEstaMuertoException;
import edu.fiuba.algo3.exceptions.ElEnemigoEstaVivoException;
import edu.fiuba.algo3.exceptions.ElEnemigoMurioDuranteElAtaqueException;

import java.util.List;

public interface EstadoEnemigo {
    void mover(Enemigo enemigo);
    EstadoEnemigo recibirDanio(int danio) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException;
    int creditosOtorgados(int creditos);
    void verSiEstaMuerto() throws ElEnemigoEstaVivoException;

    int contarMuerto();
    void agregarIndiceDeEnemigoMuerto(List<Integer> indicesEnemigosMuertos, int posicionActual);
}
