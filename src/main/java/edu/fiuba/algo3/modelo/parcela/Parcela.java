package edu.fiuba.algo3.modelo.parcela;

import edu.fiuba.algo3.modelo.defensa.*;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.exceptions.NoEsPosibleRecibirEnemigosEnParcelaException;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoBorrarElEnemigoException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;

import java.util.List;

public interface Parcela {
    void construir(Torre torre) throws NoSePudoConstruirException;
    void construir(TrampaArenosa trampaArenosa) throws NoSePudoConstruirException;
    Coordenadas recibir(Enemigo enemigo) throws NoEsPosibleRecibirEnemigosEnParcelaException;
    List<Enemigo> obtener();
    void borrarObjeto(Enemigo enemigo) throws NoSePudoBorrarElEnemigoException;

    Coordenadas devolverCoordenadasMeta();

    Coordenadas devolverCoordenadasLargada();
    Coordenadas obtenerCoordenadas();
}
