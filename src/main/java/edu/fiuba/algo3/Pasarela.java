package edu.fiuba.algo3;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import edu.fiuba.algo3.exceptions.*;

public class Pasarela implements Parcela {
    protected Coordenadas coordenadas;
    protected EstadoParcela estado;
    protected List<Enemigo> enemigos;

    public Pasarela(Coordenadas coordenadas){
        this.estado = new ParcelaOcupada();
        this.coordenadas = coordenadas;
        this.enemigos = new ArrayList<Enemigo>();
    }
    public void construir(Defensa defensa) throws NoSePudoConstruirException {
        throw new NoSePudoConstruirException();
    }
    public Coordenadas recibir(Enemigo enemigo){
        enemigos.add(enemigo);
        return this.coordenadas;
    }

    public List<Enemigo> obtener() {
        return this.enemigos;
    }

    public void borrarObjeto(Enemigo enemigo) throws NoSePudoBorrarElEnemigoException {
        this.enemigos.remove(enemigo);
    }

    public Coordenadas devolverCoordenadasMeta() {
        return null;
    }

    public Coordenadas devolverCoordenadasLargada() { return null; }

    public Coordenadas obtenerCoordenadas() {
        return this.coordenadas;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pasarela other = (Pasarela) obj;
        return (Objects.equals(coordenadas, other.coordenadas));
        }
    }

