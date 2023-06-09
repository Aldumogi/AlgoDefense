package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public abstract class Torre extends Defensa{
    protected String nombre;
    protected int costo;
    protected int tiempoDeConstruccion;
    protected int rangoDeAtaque;
    protected int danio;
    protected EstadoDefensa estado;
    protected Coordenadas coordenadas;

    public int costo() {
        return this.costo;
    }

    public EstadoDefensa estadoDefensa() {
        return this.estado;
    }
    public String getNombre(){
        return this.nombre;
    }

    public Coordenadas obtenerCoordenadas() {
        return this.coordenadas;
    }

    public abstract void atacarEnemigo(Enemigo enemigo, ArrayList<Hormiga> hormigasAsesinadas) throws ElEnemigoMurioDuranteElAtaqueException, ElEnemigoEstaMuertoException,
            DefensaEnConstruccionException, FueraDeRangoException;

    public abstract void construir(Mapa mapa, Coordenadas coordenadas) throws NoSePudoConstruirException;

    public void pasarTurno(List<Enemigo> enemigos, ArrayList<Hormiga> hormigasAsesinadas, Mapa mapa, List<Defensa> trampasAEliminar, String nombre) {
        try {
            this.estado.atacarEnemigos(enemigos, this, hormigasAsesinadas);
        } catch( Exception e ) {}
        String mensajeAlFinalizarConstruccion = "La construcción de " + this.nombre + " en la posición ("
                + this.coordenadas.obtenerFila() + ", " + this.coordenadas.obtenerColumna() + ") estará terminada para el próximo turno" ;
        this.estado = this.estado.pasarTurno(mensajeAlFinalizarConstruccion);
        if(!this.enConstruccion()){
            setChanged();
        }
    }

    protected void estaEnRango(Coordenadas coordenadasEnemigo,Coordenadas coordenadasDefensa, int rangoDeAtaque) throws FueraDeRangoException {
        if ( coordenadasDefensa.distanciaEntreCoordenadas( coordenadasEnemigo) > rangoDeAtaque ) throw new FueraDeRangoException();
    }

    public boolean enConstruccion(){
        return this.estado.enConstruccion();
    }
}
