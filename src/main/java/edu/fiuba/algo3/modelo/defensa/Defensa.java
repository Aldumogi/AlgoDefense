package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parcela.Parcela;

import java.util.ArrayList;
import java.util.List;

public abstract class Defensa {
    protected String nombre;
    protected int costo;
    protected int tiempoDeConstruccion;
    protected int rangoDeAtaque;
    protected int danio;
    protected EstadoDefensa estado;
    protected Coordenadas coordenadas;
    protected Parcela parcela;
    protected int tiempoDeRalentizacion;
    protected double factorDeRalentizacion;
    public abstract void atacarEnemigo(Enemigo enemigo) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException,
            DefensaEnConstruccionException, FueraDeRangoException;

    public abstract void construir(Mapa mapa, Coordenadas coordenadas) throws NoSePudoConstruirException;

    public int costo() {
        return this.costo;
    }

    public EstadoDefensa estadoDefensa() {
        return this.estado;
    }

    public void pasarTurno(List<Enemigo> enemigos, ArrayList<Hormiga> hormigasAsesinadas) {
        this.estado = this.estado.pasarTurno(enemigos, this.rangoDeAtaque, this.danio,
                this.obtenerCoordenadas(), hormigasAsesinadas, this.factorDeRalentizacion);
    }

    public String getNombre(){
        return this.nombre;
    }

    public Coordenadas obtenerCoordenadas() {
        return this.coordenadas;
    }
}
