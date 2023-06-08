package edu.fiuba.algo3;

import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;
import edu.fiuba.algo3.exceptions.NoEsPosibleRecibirEnemigosEnParcelaException;
import edu.fiuba.algo3.exceptions.NoSePudoBorrarElEnemigoException;

import java.util.List;

public class Tierra implements Parcela {
    private Coordenadas coordenadas;
    private EstadoParcela estado;

    public Tierra(Coordenadas coordenadas){
        this.estado = new ParcelaDisponible();
        this.coordenadas = coordenadas;
    }
    public void construir(Defensa defensa) throws NoDisponibleParaConstruirException {
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

    public Coordenadas obtenerCoordenadas(){
        return this.coordenadas;
    }
}
