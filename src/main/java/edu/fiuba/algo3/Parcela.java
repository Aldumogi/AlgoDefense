package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;
import edu.fiuba.algo3.exceptions.NoEsPosibleRecibirEnemigosEnParcelaException;
import edu.fiuba.algo3.exceptions.NoSePudoBorrarElEnemigoException;

import java.util.List;

public interface Parcela {
    void construir(Defensa defensa) throws NoDisponibleParaConstruirException;
    Coordenadas recibir(Enemigo enemigo) throws NoEsPosibleRecibirEnemigosEnParcelaException;
    List<Enemigo> obtener();
    void borrarObjeto(Enemigo enemigo) throws NoSePudoBorrarElEnemigoException;
}
