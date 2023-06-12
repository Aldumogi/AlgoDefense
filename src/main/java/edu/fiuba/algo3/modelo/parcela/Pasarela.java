package edu.fiuba.algo3.modelo.parcela;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import edu.fiuba.algo3.modelo.defensa.Torre;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import javafx.scene.paint.Color;

public class Pasarela implements Parcela {
    protected Coordenadas coordenadas;
    protected EstadoParcela estado;
    protected List<Enemigo> enemigos;
    protected TrampaArenosa trampaArenosa;
    public final Color color = Color.YELLOW;

    public Pasarela(Coordenadas coordenadas){
        this.estado = new ParcelaOcupada();
        this.coordenadas = coordenadas;
        this.enemigos = new ArrayList<Enemigo>();
        this.trampaArenosa = null;
    }

    public void construir(Torre torre) throws NoSePudoConstruirException {
        throw new NoSePudoConstruirException();
    }

    public void construir(TrampaArenosa trampaArenosa) throws NoSePudoConstruirException {
        this.trampaArenosa = trampaArenosa;
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

    public Coordenadas devolverCoordenadasLargada() {
        return null;
    }

    public Coordenadas obtenerCoordenadas() {
        return this.coordenadas;
    }

    public Color obtenerColor() {
        return this.color;
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

