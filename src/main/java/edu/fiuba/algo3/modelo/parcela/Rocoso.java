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

public class Rocoso extends Parcela {
    public final String tipo = "R";
    private List<Enemigo> enemigos;
    private Coordenadas coordenadas;
    private EstadoParcela estado;

    public Rocoso(Coordenadas coordenadas){
        this.estado = new ParcelaOcupada();
        this.coordenadas = coordenadas;
        this.enemigos = new ArrayList<>();
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
        setChanged();
    }

    public void borrarObjeto(Defensa defensa) { }

    public Coordenadas obtenerCoordenadas() {
        return this.coordenadas;
    }

    public String obtenerTipo() {
        return this.tipo;
    }

    public boolean tengoDefensaConstruida(){
        return false;
    }
}
