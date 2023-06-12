package edu.fiuba.algo3.modelo.parcela;

import edu.fiuba.algo3.modelo.exceptions.NoSePudoConstruirException;
import edu.fiuba.algo3.modelo.exceptions.NoEsPosibleRecibirEnemigosEnParcelaException;
import edu.fiuba.algo3.modelo.exceptions.NoSePudoBorrarElEnemigoException;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;

import java.util.List;

public class Tierra implements Parcela {
    private Coordenadas coordenadas;
    private EstadoParcela estado;

    public Tierra(Coordenadas coordenadas){
        this.estado = new ParcelaDisponible();
        this.coordenadas = coordenadas;
    }
    public void construir(Defensa defensa) throws NoSePudoConstruirException {
        this.estado = this.estado.construir(defensa, this);
    }

    public Coordenadas recibir(Enemigo enemigo){
        throw new NoEsPosibleRecibirEnemigosEnParcelaException();
    }

    public List<Enemigo> obtener() {
        return null;
    }

    public void borrarObjeto(Enemigo enemigo) throws NoSePudoBorrarElEnemigoException {
        throw new NoSePudoBorrarElEnemigoException();
    }

    public Coordenadas devolverCoordenadasMeta() { return null; }

    public Coordenadas devolverCoordenadasLargada() { return null; }

    public Coordenadas obtenerCoordenadas(){
        return this.coordenadas;
    }
}
