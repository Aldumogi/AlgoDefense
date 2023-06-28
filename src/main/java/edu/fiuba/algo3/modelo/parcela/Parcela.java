package edu.fiuba.algo3.modelo.parcela;

import edu.fiuba.algo3.modelo.defensa.*;
import edu.fiuba.algo3.modelo.enemigo.Lechuza;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.exceptions.NoEsPosibleRecibirEnemigosEnParcelaException;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoBorrarElEnemigoException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;

import java.util.List;
import java.util.Observable;

public abstract class Parcela extends Observable{
    abstract public void construir(Torre torre) throws NoSePudoConstruirException;
    abstract public void construir(TrampaArenosa trampaArenosa) throws NoSePudoConstruirException;
    abstract public Coordenadas recibir(Enemigo enemigo) throws NoEsPosibleRecibirEnemigosEnParcelaException;
    abstract public Coordenadas recibir(Lechuza lechuza) throws NoEsPosibleRecibirEnemigosEnParcelaException;
    abstract public List<Enemigo> obtener();
    abstract public void borrarObjeto(Enemigo enemigo) throws NoSePudoBorrarElEnemigoException;
    abstract public void borrarObjeto(Defensa defensa) ;

    abstract public Coordenadas obtenerCoordenadas();
    abstract public String obtenerTipo();
}
