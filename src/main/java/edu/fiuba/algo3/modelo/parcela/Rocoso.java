package edu.fiuba.algo3.modelo.parcela;
import edu.fiuba.algo3.modelo.defensa.Torre;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.exceptions.NoEsPosibleRecibirEnemigosEnParcelaException;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoBorrarElEnemigoException;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;

import java.util.List;

public class Rocoso implements Parcela {
    private Coordenadas coordenadas;
    private EstadoParcela estado;
    public Rocoso(Coordenadas coordenadas){
        this.estado = new ParcelaOcupada();
        this.coordenadas = coordenadas;
    }

    public void construir(Torre torre) throws NoSePudoConstruirException {
        throw new NoSePudoConstruirException();
    }

    public void construir(TrampaArenosa trampaArenosa) throws NoSePudoConstruirException {
        throw new NoSePudoConstruirException();
    }

    public Coordenadas recibir(Enemigo enemigo){
        throw new NoEsPosibleRecibirEnemigosEnParcelaException();
    }

    public List<Enemigo> obtener() { return null; }

    public void borrarObjeto(Enemigo enemigo) throws NoSePudoBorrarElEnemigoException {
        throw new NoSePudoBorrarElEnemigoException();
    }

    public Coordenadas devolverCoordenadasMeta() { return null; }

    public Coordenadas devolverCoordenadasLargada() { return null; }

    public Coordenadas obtenerCoordenadas() {
        return this.coordenadas;
    }
}
