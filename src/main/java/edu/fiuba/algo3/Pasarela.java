package edu.fiuba.algo3;
import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.exceptions.*;

public class Pasarela implements Parcela {
    protected Coordenadas coordenadas;
    protected DisponibilidadParcela disponibilidad;
    protected List<Enemigo> enemigos;

    public Pasarela(Coordenadas coordenadas){
        this.disponibilidad = new ParcelaOcupada();
        this.coordenadas = coordenadas;
        this.enemigos = new ArrayList<Enemigo>();
    }
    public void construir(Defensa defensa, int numeroDeTurno) throws NoDisponibleParaConstruirException {
        throw new NoDisponibleParaConstruirException();
    }
    public void ocupar(Defensa defensa) throws NoDisponibleParaConstruirException {}

    public void recibirEnemigo(Enemigo enemigo){
        enemigos.add(enemigo);
    };
}
