package edu.fiuba.algo3.modelo.defensa;

import edu.fiuba.algo3.modelo.enemigo.Hormiga;
import edu.fiuba.algo3.modelo.exceptions.*;
import edu.fiuba.algo3.modelo.enemigo.Enemigo;
import edu.fiuba.algo3.modelo.mapa.Coordenadas;
import edu.fiuba.algo3.modelo.mapa.Mapa;

import java.util.ArrayList;
import java.util.List;

import static edu.fiuba.algo3.modelo.LoggerManager.logger;

public class TrampaArenosa implements Defensa{
    protected String nombre;
    protected int costo;
    protected int tiempoDeConstruccion;
    protected EstadoDefensa estado;
    protected Coordenadas coordenadas;
    protected int tiempoDeRalentizacion;
    protected double factorDeRalentizacion;

    public TrampaArenosa() {
        this.nombre = "Trampa arenosa";
        this.costo = 25;
        this.tiempoDeConstruccion = 1;
        this.factorDeRalentizacion = 0.5;
        this.tiempoDeRalentizacion = 3;
    }

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

    public void construir(Mapa mapa, Coordenadas coordenadas) throws NoSePudoConstruirException {
        this.coordenadas = coordenadas;
        mapa.recibir(this);
        String mensajeAlFinalizarConstruccion = this.nombre + " está operativa en la posición ("
                + this.coordenadas.obtenerFila() + ", " + this.coordenadas.obtenerColumna() + ") " ;
        this.estado = new EnConstruccion(this.tiempoDeConstruccion, mensajeAlFinalizarConstruccion);

        logger.info("Jugador agrega una Trampa Arenosa en la posición (" +
                coordenadas.obtenerFila() + ", " + coordenadas.obtenerColumna()
                + ")");
    }

    public void pasarTurno(List<Enemigo> enemigos, ArrayList<Hormiga> hormigasAsesinadas, List<Defensa> defensas, Mapa mapa, List<Defensa> trampasAEliminar, String nombre) {
        // esta linea solo deberia de ocuparse de pasar de EnConstruccion a Terminada()
        this.estado = this.estado.pasarTurno(enemigos, this.obtenerCoordenadas(), this.factorDeRalentizacion, nombre);
        this.tiempoDeRalentizacion--;
        this.estado.ralentizarEnemigos(enemigos, this.coordenadas, this.tiempoDeRalentizacion, this.factorDeRalentizacion);
        if ( this.tiempoDeRalentizacion == 0 ) {
            mapa.borrar(this);
            trampasAEliminar.add(this);
        }
    }
}
