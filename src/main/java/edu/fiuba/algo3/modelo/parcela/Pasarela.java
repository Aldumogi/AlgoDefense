package edu.fiuba.algo3.modelo.parcela;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Observable;

import edu.fiuba.algo3.modelo.defensa.Torre;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.enemigo.Lechuza;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import javafx.scene.paint.Color;

public abstract class Pasarela extends Parcela {
    protected Coordenadas coordenadas;
    protected EstadoParcela estado;
    protected List<Enemigo> enemigos;
    protected TrampaArenosa trampaArenosa;
    public final String tipo = "P";

    public Pasarela(Coordenadas coordenadas){
        this.estado = new ParcelaDisponible();
        this.coordenadas = coordenadas;
        this.enemigos = new ArrayList<Enemigo>();
        this.trampaArenosa = null;
    }

    public void construir(Torre torre) throws NoSePudoConstruirException {
        throw new NoSePudoConstruirException();
    }

    public abstract void construir(TrampaArenosa trampaArenosa) throws NoSePudoConstruirException;

    public Coordenadas recibir(Enemigo enemigo){
        enemigos.add(enemigo);
        setChanged();
        return this.coordenadas;
    }

    public Coordenadas recibir(Lechuza lechuza) throws NoEsPosibleRecibirEnemigosEnParcelaException {
        enemigos.add(lechuza);
        setChanged();
        return this.coordenadas;
    }

    public List<Enemigo> obtener() {
        return this.enemigos;
    }

    public void borrarObjeto(Enemigo enemigo) throws NoSePudoBorrarElEnemigoException {
        this.enemigos.remove(enemigo);
        setChanged();
    }

    public void borrarObjeto(Defensa defensa) {
        setChanged();
    }

    public Coordenadas obtenerCoordenadas() {
        return this.coordenadas;
    }

    public String obtenerTipo() {
        return this.tipo;
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
    
    public boolean tengoDefensaConstruida(){
        return this.trampaArenosa != null;
    }
    }

