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

public class Tierra extends Parcela {
    private Coordenadas coordenadas;
    private List<Enemigo> enemigos;
    private EstadoParcela estado;
    private Defensa defensa;
    public final String tipo = "T";

    public Tierra(Coordenadas coordenadas){
        this.estado = new ParcelaDisponible();
        this.coordenadas = coordenadas;
        this.enemigos = new ArrayList<>();
    }

    public void construir(Torre torre) throws NoSePudoConstruirException {
        this.estado = this.estado.construir();
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
        setChanged();
        return this.coordenadas;
    }

    public List<Enemigo> obtener() {
        return this.enemigos;
    }

    public void borrarObjeto(Enemigo enemigo) throws NoSePudoBorrarElEnemigoException {
        this.enemigos.remove(enemigo);
    }

    public void borrarObjeto(Defensa defensa) {
        this.defensa = null;
        setChanged();
    }

    public Coordenadas obtenerCoordenadas(){
        return this.coordenadas;
    }

    public String obtenerTipo() {
        return this.tipo;
    }

    public boolean tengoDefensaConstruida(){
        return this.defensa != null;
    }
}
