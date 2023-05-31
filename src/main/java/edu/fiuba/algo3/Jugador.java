package edu.fiuba.algo3;
import edu.fiuba.algo3.exceptions.NoDisponibleParaConstruirException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
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
    public void actualizarDefensasAlFinalizarTurno(int numeroDeTurno){
        this.defensas.forEach(defensa -> defensa.actualizarEstado(numeroDeTurno));
    }
    public boolean generarConstruccion(Defensa unaDefensa) {
        if(this.obtenerCantidadDeCreditos() >= unaDefensa.costo()){
            int fila = ThreadLocalRandom.current().nextInt(1, 100);
            int columna = ThreadLocalRandom.current().nextInt(1, 100);
            Coordenadas coordenadas = new Coordenadas( fila, columna );

            if ( unaDefensa.construir(coordenadas) ) {
                this.defensas.add(unaDefensa);
                this.cantidadDeCreditos -= unaDefensa.costo();
                return true;
            }
        }
        return false;
    }
}
