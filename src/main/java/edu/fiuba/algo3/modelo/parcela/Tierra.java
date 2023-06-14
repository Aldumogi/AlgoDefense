package edu.fiuba.algo3.modelo.parcela;

import edu.fiuba.algo3.modelo.defensa.Torre;
import edu.fiuba.algo3.modelo.defensa.TrampaArenosa;
import edu.fiuba.algo3.modelo.enemigo.Lechuza;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.defensa.Defensa;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Tierra implements Parcela {
    private Coordenadas coordenadas;
    private List<Enemigo> enemigos;
    private EstadoParcela estado;
    protected Defensa defensa;
    public final Color color = Color.BROWN;

    public Tierra(Coordenadas coordenadas){
        this.estado = new ParcelaDisponible();
        this.coordenadas = coordenadas;
        this.enemigos = new ArrayList<>();
    }

    public void construir(Torre torre) throws NoSePudoConstruirException {
        this.estado = this.estado.construir(torre);
        this.defensa = torre;
    }

    public void construir(TrampaArenosa trampaArenosa) throws NoSePudoConstruirException {
        throw new NoSePudoConstruirException();
    }

    public Coordenadas recibir(Enemigo enemigo){
        throw new NoEsPosibleRecibirEnemigosEnParcelaException();
    }

    public Coordenadas recibir(Lechuza lechuza) throws NoEsPosibleRecibirEnemigosEnParcelaException {
        this.enemigos.add(lechuza);
        return this.coordenadas;
    }

    public List<Enemigo> obtener() {
        return null;
    }

    public void borrarObjeto(Enemigo enemigo) throws NoSePudoBorrarElEnemigoException {
        throw new NoSePudoBorrarElEnemigoException();
    }

    public void borrarObjeto(Defensa defensa) {
        this.defensa = null;
    }

    public Coordenadas devolverCoordenadasMeta() {
        return null;
    }

    public Coordenadas devolverCoordenadasLargada() {
        return null;
    }

    public Coordenadas obtenerCoordenadas(){
        return this.coordenadas;
    }

    public Color obtenerColor() {
        return this.color;
    }
}
