package edu.fiuba.algo3.modelo.parcela;
import edu.fiuba.algo3.exceptions.*;
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
    public void construir(Defensa defensa) throws NoSePudoConstruirException {
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
