package edu.fiuba.algo3;
import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;

import java.util.ArrayList;
import java.util.List;

import static edu.fiuba.algo3.Inicializador.logger;

public class Jugador {
    private int puntosDeVida;
    private int cantidadDeCreditos;
    private String nombre;
    private List<Defensa> defensas;

    
    public Jugador(String nombre){
        this.puntosDeVida = 20;
        this.cantidadDeCreditos = 100;
        this.nombre = nombre;
        this.defensas = new ArrayList<Defensa>();
    }

    public int obtenerPuntosDeVida() {
        return this.puntosDeVida;
    }

    public int obtenerCantidadDeCreditos(){
        return this.cantidadDeCreditos;
    }

    public List<Defensa> obtenerDefensas(){
        return this.defensas;
    }

    public void generarConstruccion(Defensa unaDefensa, Coordenadas coordenadas) throws NoDisponibleParaConstruirException {
        if(this.cantidadDeCreditos >= unaDefensa.costo()){
            Tierra tierra = new Tierra(coordenadas);
            tierra.construir(unaDefensa);
            this.defensas.add(unaDefensa);
            this.cantidadDeCreditos -= unaDefensa.costo();
        }

        logger.info("El jugador creó una" + unaDefensa.nombre);
    }

    public void actualizarDefensasAlFinalizarTurno(){
        this.defensas.forEach( Defensa::pasarTurno );
    }

    public void agregarCreditosAlMatarEnemigos(int creditos) {
        this.cantidadDeCreditos += creditos;
    }

    public boolean estaVivo() {
        return (this.puntosDeVida > 0);
    }

    public void restarEnergia(int energia) {
        this.puntosDeVida -= energia;
    }
}
